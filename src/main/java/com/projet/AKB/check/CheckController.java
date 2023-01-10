package com.projet.AKB.check;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/check")
public class CheckController {
    @GET
    public Response isOK() {
        return Response.ok("It's OK. All is good.").build();
    }

}

