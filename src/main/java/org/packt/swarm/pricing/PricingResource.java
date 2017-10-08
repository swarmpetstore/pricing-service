package org.packt.swarm.pricing;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
