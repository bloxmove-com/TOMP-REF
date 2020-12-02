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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.model.Asset;
import io.swagger.model.Error;
import io.swagger.model.Leg;
import io.swagger.model.LegEvent;
import io.swagger.model.LegProgress;
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
public interface LegsApi {

	@Operation(summary = "", description = "Returns a list of available assets for the given leg. These assets can be used to POST to /legs/{id}/asset if no specific asset is assigned by the TO. If picking an asset is not allowed for this booking, or one already has been, 403 should be returned. If the booking is unknown, 404 should be returned. See (4.7) in the process flow. - trip execution", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Available assets for the leg. If no suitable assets are found an empty array is to be returned.", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Asset.class)))),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/legs/{id}/available-assets", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Asset>> legsIdAvailableAssetsGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.QUERY, description = "start of the selection", schema = @Schema(defaultValue = "0")) @Valid @RequestParam(value = "offset", required = false, defaultValue = "0") BigDecimal offset,
			@Parameter(in = ParameterIn.QUERY, description = "count of the selection", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) BigDecimal limit);

	@Operation(summary = "", description = "This endpoint must be used to alter the state of a leg.<br> Operations:<br> `PREPARE` the TO can send a message telling the MP that he is preparing the booked leg [To be implemented by the MP] (see (7.2) in the process flow - trip execution),<br> `ASSIGN_ASSET` can assign an asset to a leg. Can be to assign an asset in case there is still an asset type assigned [Optionally implementable by the MP]. See (4.7) in the process flow - trip execution<br> `SET_IN_USE` will activate the leg or resume the leg [TO and MP] (see (4.6) in process flow),<br> `TIME_EXTEND` will be used to request an extension in time; the end user wants to use the asset longer, the `time` field contains the new end time,<br> `TIME_POSTPONE` will be used to request a delay in the departure time, the end user wants to depart later, the `time` field contains the new departure time,<br> `PAUSE` will pause the leg [TO and MP] (see (4.6) in process flow),<br> `START_FINISHING` will start the end-of-leg [Optionally implementable by TO and MP],<br> `FINISH` will end this leg (see (4.6) in process flow) [TO and MP]", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "MP", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "operation successful", content = @Content(schema = @Schema(implementation = Leg.class))),

			@ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),

			@ApiResponse(responseCode = "503", description = "In case of temporary malfunctioning, this response can be send (e.g. bluetooth lock jammed). See also https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Retry-After") })
	@RequestMapping(value = "/legs/{id}/events", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Leg> legsIdEventsPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody LegEvent body);

	@Operation(summary = "", description = "Retrieves the latest summary of the leg, being the execution of a portion of a journey travelled using one asset (vehicle). Every leg belongs to one booking, every booking has at least one leg. Where the booking describes the agreement between user/MP and TO, the leg describes the journey as it occured. See (4.3) in the flow chart - trip execution", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "TO", "MP" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "operation successful", content = @Content(schema = @Schema(implementation = Leg.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/legs/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Leg> legsIdGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id);

	@Operation(summary = "", description = "Monitors the current location of the asset and duration & distance of the leg (see (4.7) in process flow)", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "TO" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "operation successful", content = @Content(schema = @Schema(implementation = LegProgress.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/legs/{id}/progress", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<LegProgress> legsIdProgressGet(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.QUERY, description = "Specifies if only the location should be returned", schema = @Schema(defaultValue = "false")) @Valid @RequestParam(value = "location-only", required = false, defaultValue = "false") Boolean locationOnly);

	@Operation(summary = "", description = "Monitors the current location of the asset and duration & distance of the leg", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "MP" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/legs/{id}/progress", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> legsIdProgressPost(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody LegProgress body);

	@Operation(summary = "", description = "Updates the leg with new information. Only used for updates about execution to the MP. To request changes as the MP, the booking should be updated and the TO can accept the change and update the leg in turn.", security = {
			@SecurityRequirement(name = "ApiKeyAuth"), @SecurityRequirement(name = "BasicAuth"),
			@SecurityRequirement(name = "BearerAuth"), @SecurityRequirement(name = "OAuth", scopes = { "", }),
			@SecurityRequirement(name = "OpenId") }, tags = { "trip execution", "MP" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Request was successful, no content to return."),

			@ApiResponse(responseCode = "400", description = "Bad request. See https://github.com/TOMP-WG/TOMP-API/wiki/Error-handling-in-TOMP for further explanation of error code.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "401", description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\". That is, the client must authenticate itself to get the requested response.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "403", description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response. Unlike 401, the client's identity is known to the server.", content = @Content(schema = @Schema(implementation = Error.class))),

			@ApiResponse(responseCode = "404", description = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
	@RequestMapping(value = "/legs/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> legsIdPut(
			@Parameter(in = ParameterIn.HEADER, description = "A list of the languages/localizations the user would like to see the results in. For user privacy and ease of use on the TO side, this list should be kept as short as possible, ideally just one language tag from the list in operator/information", required = true, schema = @Schema()) @RequestHeader(value = "Accept-Language", required = true) String acceptLanguage,
			@Parameter(in = ParameterIn.HEADER, description = "API description, can be TOMP or maybe other (specific/derived) API definitions", required = true, schema = @Schema()) @RequestHeader(value = "Api", required = true) String api,
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API.", required = true, schema = @Schema()) @RequestHeader(value = "Api-Version", required = true) String apiVersion,
			@Parameter(in = ParameterIn.PATH, description = "Leg identifier", required = true, schema = @Schema()) @PathVariable("id") String id,
			@Parameter(in = ParameterIn.DEFAULT, description = "changed leg (e.g. with different duration or destination)", required = true, schema = @Schema()) @Valid @RequestBody Leg body);

}
