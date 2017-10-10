package org.packt.swarm.petstore.pricing;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class PricingResource {

    @Inject
    private PricingService pricingService;

    @GET
    @Path("price")
    @Produces(MediaType.APPLICATION_JSON)
    public Price priceByName(@QueryParam("name") String name) {
        return pricingService.findByName(name);
    }

}
