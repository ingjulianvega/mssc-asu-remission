package ingjulianvega.ximic.msscasuremission.web.controller;

import ingjulianvega.ximic.msscasuremission.web.model.ApiError;
import ingjulianvega.ximic.msscasuremission.web.model.Remission;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionDto;
import ingjulianvega.ximic.msscasuremission.web.model.RemissionList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface RemissionI {

    @Operation(summary = "Endpoint to get the list of remissions", description = "Returns a list of remission", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RemissionList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RemissionList> get();

    @Operation(summary = "Endpoint to get the information of a remission given the id", description = "Returns a remission", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RemissionDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RemissionDto> getById(@Parameter(in = ParameterIn.PATH, description = "The remission id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to get the list of remissions having the visitId", description = "Returns a list of remission for a visit", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RemissionList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/visit-id/{visit-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RemissionList> getByVisittId(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("visit-id") UUID visitId);

    @Operation(summary = "Endpoint to create a remission", description = "Creates a new remission", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "remission's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Remission remission);

    @Operation(summary = "Endpoint to update the information of a remission given the id", description = "Updates a remission", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The remission id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "remission's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Remission remission);


    @Operation(summary = "Endpoint to delete a remission", description = "Deletes a remission", tags = {"remission"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The remission id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
