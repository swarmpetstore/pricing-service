package org.packt.swarm.petstore.pricing;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PricingService {

    @PersistenceContext(unitName = "PricingPU")
    private EntityManager em;

    public Price findByName(String name) {
        return em.createNamedQuery("Price.findByName", Price.class).setParameter("name",name).getResultList().get(0);
    }
}
