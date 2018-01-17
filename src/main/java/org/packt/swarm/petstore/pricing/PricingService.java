package org.packt.swarm.petstore.pricing;

import org.packt.swarm.petstore.pricing.model.Price;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class PricingService {

    @PersistenceContext(unitName = "PricingPU")
    private EntityManager em;

    public Price findByItemId(String itemId) {
        System.out.println("SZUKAM ITEMA "+itemId);
        List<Price> result = em.createNamedQuery("Price.findByItemId", Price.class).setParameter("itemId", itemId).getResultList();
        if(result.isEmpty()){
            return null;
        } else {
            return result.get(0);
        }
    }
}
