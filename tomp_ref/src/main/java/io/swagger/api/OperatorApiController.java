package io.swagger.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemAlert;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")
@RestController
public class OperatorApiController implements OperatorApi {

	private static final Logger log = LoggerFactory.getLogger(OperatorApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public OperatorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<List<SystemAlert>> operatorAlertsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SystemAlert>>(objectMapper.readValue(
						"[ {\n  \"summary\" : \"station closed\",\n  \"lastUpdated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"alertType\" : \"SYSTEM_CLOSURE\",\n  \"startAndEndTimes\" : [ [ \"2000-01-23T04:56:07.000+00:00\", \"2000-01-23T04:56:07.000+00:00\" ], [ \"2000-01-23T04:56:07.000+00:00\", \"2000-01-23T04:56:07.000+00:00\" ] ],\n  \"stationIds\" : \"stationID0001\",\n  \"regionId\" : \"regionID0001\",\n  \"description\" : \"station closed indefinitely due to vandalism\",\n  \"alertId\" : \"alertId\",\n  \"url\" : \"http://www.rentmyfreebike.com/alerts\"\n}, {\n  \"summary\" : \"station closed\",\n  \"lastUpdated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"alertType\" : \"SYSTEM_CLOSURE\",\n  \"startAndEndTimes\" : [ [ \"2000-01-23T04:56:07.000+00:00\", \"2000-01-23T04:56:07.000+00:00\" ], [ \"2000-01-23T04:56:07.000+00:00\", \"2000-01-23T04:56:07.000+00:00\" ] ],\n  \"stationIds\" : \"stationID0001\",\n  \"regionId\" : \"regionID0001\",\n  \"description\" : \"station closed indefinitely due to vandalism\",\n  \"alertId\" : \"alertId\",\n  \"url\" : \"http://www.rentmyfreebike.com/alerts\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SystemAlert>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SystemAlert>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<AssetType>> operatorAvailableAssetsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<AssetType>>(objectMapper.readValue(
						"[ {\n  \"assets\" : [ {\n    \"overriddenProperties\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 1,\n      \"cabrio\" : true,\n      \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n      \"buildingYear\" : 6,\n      \"stateOfCharge\" : 56,\n      \"co2PerKm\" : 0.8008281904610115,\n      \"propulsion\" : \"MUSCLE\",\n      \"infantSeat\" : true,\n      \"persons\" : 1,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : \"\",\n      \"name\" : \"name\",\n      \"location\" : {\n        \"name\" : \"name\",\n        \"coordinates\" : {\n          \"lng\" : 6.169639,\n          \"lat\" : 52.253279\n        },\n        \"physicalAddress\" : {\n          \"areaReference\" : \"Smallcity, Pinetree county\",\n          \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n          \"postalCode\" : \"postalCode\"\n        },\n        \"stopReference\" : [ {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        }, {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        } ],\n        \"stationId\" : \"stationId\",\n        \"extraInfo\" : \"\"\n      }\n    },\n    \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n    \"isReserved\" : true,\n    \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"isDisabled\" : true,\n    \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n    \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n    \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"overriddenProperties\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 1,\n      \"cabrio\" : true,\n      \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n      \"buildingYear\" : 6,\n      \"stateOfCharge\" : 56,\n      \"co2PerKm\" : 0.8008281904610115,\n      \"propulsion\" : \"MUSCLE\",\n      \"infantSeat\" : true,\n      \"persons\" : 1,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : \"\",\n      \"name\" : \"name\",\n      \"location\" : {\n        \"name\" : \"name\",\n        \"coordinates\" : {\n          \"lng\" : 6.169639,\n          \"lat\" : 52.253279\n        },\n        \"physicalAddress\" : {\n          \"areaReference\" : \"Smallcity, Pinetree county\",\n          \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n          \"postalCode\" : \"postalCode\"\n        },\n        \"stopReference\" : [ {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        }, {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        } ],\n        \"stationId\" : \"stationId\",\n        \"extraInfo\" : \"\"\n      }\n    },\n    \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n    \"isReserved\" : true,\n    \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"isDisabled\" : true,\n    \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n    \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n    \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"nrAvailable\" : 0,\n  \"id\" : \"id\",\n  \"assetClass\" : \"AIR\",\n  \"assetSubClass\" : \"assetSubClass\",\n  \"stationId\" : \"stationId\",\n  \"sharedProperties\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 1,\n    \"cabrio\" : true,\n    \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n    \"buildingYear\" : 6,\n    \"stateOfCharge\" : 56,\n    \"co2PerKm\" : 0.8008281904610115,\n    \"propulsion\" : \"MUSCLE\",\n    \"infantSeat\" : true,\n    \"persons\" : 1,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : \"\",\n    \"name\" : \"name\",\n    \"location\" : {\n      \"name\" : \"name\",\n      \"coordinates\" : {\n        \"lng\" : 6.169639,\n        \"lat\" : 52.253279\n      },\n      \"physicalAddress\" : {\n        \"areaReference\" : \"Smallcity, Pinetree county\",\n        \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n        \"postalCode\" : \"postalCode\"\n      },\n      \"stopReference\" : [ {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      }, {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      } ],\n      \"stationId\" : \"stationId\",\n      \"extraInfo\" : \"\"\n    }\n  }\n}, {\n  \"assets\" : [ {\n    \"overriddenProperties\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 1,\n      \"cabrio\" : true,\n      \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n      \"buildingYear\" : 6,\n      \"stateOfCharge\" : 56,\n      \"co2PerKm\" : 0.8008281904610115,\n      \"propulsion\" : \"MUSCLE\",\n      \"infantSeat\" : true,\n      \"persons\" : 1,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : \"\",\n      \"name\" : \"name\",\n      \"location\" : {\n        \"name\" : \"name\",\n        \"coordinates\" : {\n          \"lng\" : 6.169639,\n          \"lat\" : 52.253279\n        },\n        \"physicalAddress\" : {\n          \"areaReference\" : \"Smallcity, Pinetree county\",\n          \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n          \"postalCode\" : \"postalCode\"\n        },\n        \"stopReference\" : [ {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        }, {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        } ],\n        \"stationId\" : \"stationId\",\n        \"extraInfo\" : \"\"\n      }\n    },\n    \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n    \"isReserved\" : true,\n    \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"isDisabled\" : true,\n    \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n    \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n    \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n  }, {\n    \"overriddenProperties\" : {\n      \"pets\" : true,\n      \"airConditioning\" : true,\n      \"other\" : \"other\",\n      \"fuel\" : \"NONE\",\n      \"travelAbroad\" : true,\n      \"energyLabel\" : \"A\",\n      \"winterTires\" : true,\n      \"undergroundParking\" : true,\n      \"smoking\" : true,\n      \"towingHook\" : true,\n      \"model\" : \"model\",\n      \"gearbox\" : \"MANUAL\",\n      \"cargo\" : \"cargo\",\n      \"brand\" : \"brand\",\n      \"gears\" : 1,\n      \"cabrio\" : true,\n      \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n      \"buildingYear\" : 6,\n      \"stateOfCharge\" : 56,\n      \"co2PerKm\" : 0.8008281904610115,\n      \"propulsion\" : \"MUSCLE\",\n      \"infantSeat\" : true,\n      \"persons\" : 1,\n      \"colour\" : \"colour\",\n      \"easyAccessibility\" : \"LIFT\",\n      \"meta\" : \"\",\n      \"name\" : \"name\",\n      \"location\" : {\n        \"name\" : \"name\",\n        \"coordinates\" : {\n          \"lng\" : 6.169639,\n          \"lat\" : 52.253279\n        },\n        \"physicalAddress\" : {\n          \"areaReference\" : \"Smallcity, Pinetree county\",\n          \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n          \"postalCode\" : \"postalCode\"\n        },\n        \"stopReference\" : [ {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        }, {\n          \"country\" : \"NL\",\n          \"id\" : \"id\",\n          \"type\" : \"GTFS_STOP_ID\"\n        } ],\n        \"stationId\" : \"stationId\",\n        \"extraInfo\" : \"\"\n      }\n    },\n    \"rentalUrl\" : \"https://www.rentmyfreebike.com/app?sid=1234567890\",\n    \"isReserved\" : true,\n    \"isReservedFrom\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"id\" : \"id\",\n    \"isDisabled\" : true,\n    \"rentalUrlAndroid\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=android\",\n    \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n    \"isReservedTo\" : \"2000-01-23T04:56:07.000+00:00\"\n  } ],\n  \"nrAvailable\" : 0,\n  \"id\" : \"id\",\n  \"assetClass\" : \"AIR\",\n  \"assetSubClass\" : \"assetSubClass\",\n  \"stationId\" : \"stationId\",\n  \"sharedProperties\" : {\n    \"pets\" : true,\n    \"airConditioning\" : true,\n    \"other\" : \"other\",\n    \"fuel\" : \"NONE\",\n    \"travelAbroad\" : true,\n    \"energyLabel\" : \"A\",\n    \"winterTires\" : true,\n    \"undergroundParking\" : true,\n    \"smoking\" : true,\n    \"towingHook\" : true,\n    \"model\" : \"model\",\n    \"gearbox\" : \"MANUAL\",\n    \"cargo\" : \"cargo\",\n    \"brand\" : \"brand\",\n    \"gears\" : 1,\n    \"cabrio\" : true,\n    \"image\" : \"https://files.fietsersbond.nl/app/uploads/2014/10/30151126/ST2_Men_Side_CityKit-Stromer.jpg\",\n    \"buildingYear\" : 6,\n    \"stateOfCharge\" : 56,\n    \"co2PerKm\" : 0.8008281904610115,\n    \"propulsion\" : \"MUSCLE\",\n    \"infantSeat\" : true,\n    \"persons\" : 1,\n    \"colour\" : \"colour\",\n    \"easyAccessibility\" : \"LIFT\",\n    \"meta\" : \"\",\n    \"name\" : \"name\",\n    \"location\" : {\n      \"name\" : \"name\",\n      \"coordinates\" : {\n        \"lng\" : 6.169639,\n        \"lat\" : 52.253279\n      },\n      \"physicalAddress\" : {\n        \"areaReference\" : \"Smallcity, Pinetree county\",\n        \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n        \"postalCode\" : \"postalCode\"\n      },\n      \"stopReference\" : [ {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      }, {\n        \"country\" : \"NL\",\n        \"id\" : \"id\",\n        \"type\" : \"GTFS_STOP_ID\"\n      } ],\n      \"stationId\" : \"stationId\",\n      \"extraInfo\" : \"\"\n    }\n  }\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<AssetType>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<AssetType>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<SystemInformation> operatorInformationGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SystemInformation>(objectMapper.readValue(
						"{\n  \"licenseUrl\" : \"https://www.rentmyfreebike.com/license\",\n  \"systemId\" : \"XXTO0001\",\n  \"discoveryUriAndroid\" : \"discoveryUriAndroid\",\n  \"timezone\" : \"IST\",\n  \"language\" : [ \"fr-FR\", \"fr-FR\" ],\n  \"storeUriAndroid\" : \"https://play.google.com/store/apps/details?id=com.rentmyfreebike.android\",\n  \"discoveryUriIOS\" : \"discoveryUriIOS\",\n  \"storeUriIOS\" : \"itms-apps://itunes.apple.com/app/idcom.rentmyfreebike.ios\",\n  \"operator\" : \"FreeBike\",\n  \"url\" : \"https://www.rentmyfreebike.com\",\n  \"chamberOfCommerceInfo\" : {\n    \"number\" : \"number\",\n    \"place\" : \"place\"\n  },\n  \"purchaseUrl\" : \"https://www.rentmyfreebike.com/purchase\",\n  \"typeOfSystem\" : \"FREE_FLOATING\",\n  \"phoneNumber\" : \"555-12345\",\n  \"name\" : \"FreeBike\",\n  \"feedContactEmail\" : \"\",\n  \"shortName\" : \"FB\",\n  \"conditions\" : \"conditions\",\n  \"assetClasses\" : [ \"AIR\", \"AIR\" ],\n  \"startDate\" : \"2000-01-23\",\n  \"email\" : \"rent@freebike.com\",\n  \"productType\" : \"RENTAL\"\n}",
						SystemInformation.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SystemInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SystemInformation>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<EndpointImplementation>> operatorMetaGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<EndpointImplementation>>(objectMapper.readValue(
						"[ {\n  \"version\" : \"0.5.0\",\n  \"baseUrl\" : \"https://dummy-bikes.org/\",\n  \"endpoints\" : [ ],\n  \"scenarios\" : [ \"POSTPONED_COMMIT\" ],\n  \"processIdentifiers\" : {\n    \"planning\" : [ \"LOCATION_BASED\" ],\n    \"booking\" : [ \"ACCESS_CODE_QR\", \"ACCESS_CODE_IN_COMMIT_EVENT\" ]\n  }\n}, {\n  \"version\" : \"0.5.0\",\n  \"baseUrl\" : \"https://dummy-bikes.org/\",\n  \"endpoints\" : [ ],\n  \"scenarios\" : [ \"POSTPONED_COMMIT\" ],\n  \"processIdentifiers\" : {\n    \"planning\" : [ \"LOCATION_BASED\" ],\n    \"booking\" : [ \"ACCESS_CODE_QR\", \"ACCESS_CODE_IN_COMMIT_EVENT\" ]\n  }\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<EndpointImplementation>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<EndpointImplementation>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SystemCalendar>>(objectMapper.readValue(
						"[ {\n  \"regionId\" : \"regionId\",\n  \"startMonth\" : 1,\n  \"startDay\" : 1,\n  \"endDay\" : 31,\n  \"startYear\" : 2019,\n  \"endMonth\" : 12,\n  \"endYear\" : 2099,\n  \"stationId\" : \"stationId\"\n}, {\n  \"regionId\" : \"regionId\",\n  \"startMonth\" : 1,\n  \"startDay\" : 1,\n  \"endDay\" : 31,\n  \"startYear\" : 2019,\n  \"endMonth\" : 12,\n  \"endYear\" : 2099,\n  \"stationId\" : \"stationId\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SystemCalendar>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SystemCalendar>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SystemHours>>(objectMapper.readValue(
						"[ {\n  \"regionId\" : \"regionId\",\n  \"days\" : [ \"MON\", \"MON\" ],\n  \"startTime\" : \"startTime\",\n  \"userType\" : \"MEMBER\",\n  \"endTime\" : \"endTime\",\n  \"stationId\" : \"stationId\"\n}, {\n  \"regionId\" : \"regionId\",\n  \"days\" : [ \"MON\", \"MON\" ],\n  \"startTime\" : \"startTime\",\n  \"userType\" : \"MEMBER\",\n  \"endTime\" : \"endTime\",\n  \"stationId\" : \"stationId\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SystemHours>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SystemHours>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SystemPricingPlan>>(objectMapper.readValue(
						"[ {\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"vatRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"vatRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"regionId\" : \"regionId\",\n  \"name\" : \"Free Plan\",\n  \"isTaxable\" : true,\n  \"description\" : \"Unlimited plan for free bikes, as long as you don't break them!\",\n  \"planId\" : \"freeplan1\",\n  \"url\" : \"https://www.rentmyfreebike.com/freeplan\",\n  \"stationId\" : \"stationId\"\n}, {\n  \"fare\" : {\n    \"estimated\" : true,\n    \"parts\" : [ {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"vatRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    }, {\n      \"amount\" : 9.96,\n      \"currencyCode\" : \"EUR\",\n      \"vatRate\" : 21,\n      \"type\" : \"FLEX\",\n      \"unitType\" : \"HOUR\",\n      \"units\" : 1\n    } ],\n    \"description\" : \"description\",\n    \"class\" : \"class\"\n  },\n  \"regionId\" : \"regionId\",\n  \"name\" : \"Free Plan\",\n  \"isTaxable\" : true,\n  \"description\" : \"Unlimited plan for free bikes, as long as you don't break them!\",\n  \"planId\" : \"freeplan1\",\n  \"url\" : \"https://www.rentmyfreebike.com/freeplan\",\n  \"stationId\" : \"stationId\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SystemPricingPlan>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SystemPricingPlan>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<SystemRegion>> operatorRegionsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SystemRegion>>(objectMapper.readValue(
						"[ {\n  \"serviceArea\" : \"\",\n  \"regionId\" : \"BikeRegion\",\n  \"name\" : \"BikeTown\"\n}, {\n  \"serviceArea\" : \"\",\n  \"regionId\" : \"BikeRegion\",\n  \"name\" : \"BikeTown\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SystemRegion>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SystemRegion>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<StationInformation>> operatorStationsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<StationInformation>>(objectMapper.readValue(
						"[ {\n  \"rentalUrl\" : \"https://www.rentmyfreebike.com\",\n  \"regionId\" : \"regionId\",\n  \"name\" : \"Island Central\",\n  \"coordinates\" : {\n    \"lng\" : 6.169639,\n    \"lat\" : 52.253279\n  },\n  \"physicalAddress\" : {\n    \"areaReference\" : \"Smallcity, Pinetree county\",\n    \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n    \"postalCode\" : \"postalCode\"\n  },\n  \"rentalMethods\" : [ \"CREDITCARD\", \"PAYPASS\", \"APPLEPAY\" ],\n  \"crossStreet\" : \"on the corner with Secondary Road\",\n  \"rentalUrlAndroid\" : \"https://www.rentmyfreebikecom/app?sid=1234567890&platform=android\",\n  \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n  \"stationId\" : \"XX:Y:12345678\"\n}, {\n  \"rentalUrl\" : \"https://www.rentmyfreebike.com\",\n  \"regionId\" : \"regionId\",\n  \"name\" : \"Island Central\",\n  \"coordinates\" : {\n    \"lng\" : 6.169639,\n    \"lat\" : 52.253279\n  },\n  \"physicalAddress\" : {\n    \"areaReference\" : \"Smallcity, Pinetree county\",\n    \"streetAddress\" : \"example street 18, 2nd floor, 18-B33\",\n    \"postalCode\" : \"postalCode\"\n  },\n  \"rentalMethods\" : [ \"CREDITCARD\", \"PAYPASS\", \"APPLEPAY\" ],\n  \"crossStreet\" : \"on the corner with Secondary Road\",\n  \"rentalUrlAndroid\" : \"https://www.rentmyfreebikecom/app?sid=1234567890&platform=android\",\n  \"rentalUrlIOS\" : \"https://www.rentmyfreebike.com/app?sid=1234567890&platform=ios\",\n  \"stationId\" : \"XX:Y:12345678\"\n} ]",
						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<StationInformation>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<StationInformation>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
