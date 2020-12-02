/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.23).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.model.AssetType;
import io.swagger.model.EndpointImplementation;
import io.swagger.model.Error;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemAlert;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-12-02T11:35:19.171Z[GMT]")
public interface OperatorApi {

	@Operation(summary = "informs customers about changes to the system outside of normal operations", description = "This feed is intended to inform customers about changes to the system that do not fall within the normal system operations. For example, system closures due to weather would be listed here, but a system that only operated for part of the year would have that schedule listed in the system-calendar.json feed. This file is an array of alert objects defined as below. Obsolete alerts should be removed so the client application can safely present to the end user everything present in the feed. The consumer could use the start/end information to determine if this is a past, ongoing or future alert and adjust the presentation accordingly. [from GBFS]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "returns currently active system alerts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = SystemAlert.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/alerts", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SystemAlert>> operatorAlertsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId);

	@Operation(summary = "", description = "Returns a list of available assets.", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Available assets or asset-types. In case assets are replied, the realtime location is also available.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AssetType.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/operator/available-assets", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<AssetType>> operatorAvailableAssetsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId);

	@Operation(summary = "describes the system", description = "Describes the system including System operator, System location, year implemented, URLs, contact info, time zone. [from GBFS]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = SystemInformation.class))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/information", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<SystemInformation> operatorInformationGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion);

	@Operation(summary = "describes the running implementations", description = "all versions that are implemented on this url, are described in the result of this endpoint. In contains all versions and per version the endpoints, their status and the supported scenarios.", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO", "MP" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EndpointImplementation.class)))) })
	@RequestMapping(value = "/operator/meta", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<EndpointImplementation>> operatorMetaGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage);

	@Operation(summary = "describes the operating calendar for a system. An array of year objects defined as follows (if start/end year are omitted, then assume the start and end months do not change from year to year). [from GFBS]", description = "", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = SystemCalendar.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/operating-calendar", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId);

	@Operation(summary = "describes the system hours of operation", description = "Describes the hours of operation of all available systems of the transport operator [from GBFS]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = SystemHours.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/operating-hours", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId);

	@Operation(summary = "gives pricing information", description = "Describes pricing of systems or assets [from GBFS]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "returns standard pricing plans for an operator", content = @Content(array = @ArraySchema(schema = @Schema(implementation = SystemPricingPlan.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/pricing-plans", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the station to use in the filter (/operator/stations)", schema = @Schema()) @Valid @RequestParam(value = "stationId", required = false) String stationId);

	@Operation(summary = "describes regions for a system that is broken up by geographic or political region. It is defined as a separate feed to allow for additional region metadata (such as shape definitions). [from GBFS]", description = "", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = SystemRegion.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/regions", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<SystemRegion>> operatorRegionsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit);

	@Operation(summary = "describes all available stations", description = "All stations contained in this list are considered public (ie, can be shown on a map for public use). If there are private stations (such as Capital Bikeshare's White House station) these should not be exposed here and their status should not be included [from GBFS]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "operator information", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = StationInformation.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))) })
	@RequestMapping(value = "/operator/stations", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<StationInformation>> operatorStationsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit,
			@Parameter(in = ParameterIn.QUERY, description = "optional id of the region to use in the filter (/operator/regions)", schema = @Schema()) @Valid @RequestParam(value = "regionId", required = false) String regionId);

}
