package org.tomp.api.payment;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.repository.DefaultRepository;

import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;

@Component
@ConditionalOnProperty(value = "tomp.providers.payment", havingValue = "generic", matchIfMissing = true)
public class GenericPaymentProvider implements PaymentProvider {

	@Autowired
	DefaultRepository repository;

	@Override
	public JournalEntry claimExtraCosts(String acceptLanguage, String api, String apiVersion, String id,
			ExtraCosts body) {
		JournalEntry extraCosts = new JournalEntry();
		extraCosts.setAmount(body.getAmount());
		extraCosts.setAmountExVat(body.getAmountExVat());
		extraCosts.setComment(body.getDescription());
		extraCosts.setCurrencyCode(body.getCurrencyCode());
		extraCosts.setDetails(body);
		// extraCosts.setExpirationDate(body.get);
		extraCosts.setJournalId(id);
		extraCosts.setState(JournalState.TO_INVOICE);
		extraCosts.setVatCountryCode(body.getVatCountryCode());
		extraCosts.setVatRate(body.getVatRate());
		return extraCosts;
	}

	@Override
	public List<JournalEntry> getJournalEntries(String acceptLanguage, String api, String apiVersion,
			@NotNull @Valid OffsetDateTime from, @NotNull @Valid OffsetDateTime to, JournalState state, String category,
			String id, String maasId) {

		JournalEntry invoice = new JournalEntry();
		invoice.setAmount(new BigDecimal("4.76"));
		invoice.setAmountExVat(new BigDecimal("4"));
		invoice.setComment("Invoice for your tomp trip");
		invoice.setCurrencyCode("EUR");
		invoice.setDetails("Invoice for your tomp trip");
		//invoice.setExpirationDate();
		invoice.setJournalId(UUID.randomUUID().toString());
		invoice.setState(JournalState.TO_INVOICE);
		invoice.setVatCountryCode("DE");
		invoice.setVatRate(new BigDecimal("19"));
		invoice.setUsedTime(new BigDecimal("15"));

		return List.of(invoice);
	}

}
