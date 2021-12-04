package org.homegarden.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/relay")
public interface RelayResource {

    @GET
    @Path("/start/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response start(@PathParam("id") int id);

    @GET
    @Path("/stop/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response stop(@PathParam("id") int id);

}
