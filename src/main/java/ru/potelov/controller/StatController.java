package ru.potelov.controller;

import ru.potelov.service.IStatService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Stateless

public class StatController {

    @Inject
    private IStatService iStatService;

    @GET
    public Response getRegionDiseasesStats(
            @QueryParam("territory") Integer territory,
            @QueryParam("month") Integer month) {

        return Response.ok(iStatService.getRegionDiseasesStats(territory, month)).build();
    }

}
