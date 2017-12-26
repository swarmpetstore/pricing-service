package org.packt.swarm.petstore.pricing;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/")
public class PricingResource {

    @Inject
    private PricingService pricingService;

    @GET
    @Path("price/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Price priceByName(@PathParam("name") String name, @Context SecurityContext securityContext) {
        System.out.println("IDZIE PRICE BY NAME");
        System.out.println("PRINCIPAL TO "+securityContext.getUserPrincipal());
        return pricingService.findByName(name);
    }

}
