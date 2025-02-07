package org.tomp.api.booking;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.tomp.api.model.MaasOperator;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.GeoCoderUtil;

import io.swagger.client.ApiException;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "generic", matchIfMissing = true)
public class GenericBookingProvider implements BookingProvider {

	private static final Logger log = LoggerFactory.getLogger(GenericBookingProvider.class);

	private List<String> listeners = new ArrayList<>();

	@Autowired
	ClientUtil clientUtil;

	@Autowired
	GeoCoderUtil geocoderUtil;

	@Autowired
	DefaultRepository repository;

	@Override
	public Booking addNewBooking(@Valid BookingRequest body, String acceptLanguage) {
		log.info("POST bookings {}", body.getId());

		String id = body.getId();
		validateId(id);

		Booking booking = repository.getSavedOption(id);
		booking.setState(BookingState.PENDING);



		if (geocoderUtil.isActive()) {
			@NotNull
			@Valid
			Place from = booking.getFrom();
			@Valid
			Place to = booking.getTo();

			Address address = from.getPhysicalAddress();
			if (address == null) {
				address = new Address();
				Place p = new Place();
				p.setPhysicalAddress(address);
				booking.setFrom(p);
			}
			Coordinates coord = booking.getFrom().getCoordinates();
			geocoderUtil.getPhysicalAddressByCoordinate(coord, address);

			address = to.getPhysicalAddress();
			if (address == null) {
				address = new Address();
				Place p = new Place();
				p.setPhysicalAddress(address);
				booking.setTo(p);
			}
			coord = booking.getTo().getCoordinates();
			geocoderUtil.getPhysicalAddressByCoordinate(coord, address);
		}

		repository.saveBooking(booking);
		return booking;
	}

	protected void validateId(String id) {
		if (repository.getSavedOption(id) == null) {
			log.error("Did not provide this leg {}", id);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking addNewBookingEvent(BookingOperation body, String acceptLanguage, String id) {
		validateId(id);
		log.info("POST bookings/{}/events {}", id, body.getOperation());
		Booking booking = repository.getBooking(id);
		if (booking == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		switch (body.getOperation()) {
		case COMMIT:
			booking.setState(BookingState.CONFIRMED);
			booking.getLegs().get(0).setState(LegState.NOT_STARTED);
			break;
		case CANCEL:
			booking.setState(BookingState.CANCELLED);
			booking.getLegs().get(0).setState(LegState.CANCELLED);
			break;
		case DENY:
			booking.setState(BookingState.RELEASED);
			booking.getLegs().get(0).setState(LegState.CANCELLED);
			break;
		case EXPIRE:
			booking.setState(BookingState.EXPIRED);
			booking.getLegs().get(0).setState(LegState.CANCELLED);
			break;
		}


		informListeners(body, id);
		repository.saveBooking(booking);
		return booking;
	}

	private void informListeners(BookingOperation body, String id) {
		if (listeners.contains(id)) {
			MaasOperator to = new MaasOperator();
			// to.setUrl(listener.getWebhook());
			try {
				clientUtil.post(to, "", body, Void.class);
			} catch (ApiException e) {
				log.error(e.getMessage());
			}
		}
	}

	@Override
	public void setRequest(HttpServletRequest request) {
	}

	@Override
	public Booking getBooking(String id) {
		return repository.getBooking(id);
	}

	@Override
	public void subscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		listeners.add(id);
	}

	@Override
	public void unsubscribeToBookings(String acceptLanguage, String api, String apiVersion, String id) {
		listeners.remove(id);
	}
}
