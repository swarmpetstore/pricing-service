package org.packt.swarm.pricing;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PricingService {

    @PersistenceContext(unitName = "PricesPU")
    private EntityManager em;

    public Price findByName(String name) {
        return em.createNamedQuery("Pet.findByName", Price.class).setParameter("name",name).getResultList().get(0);
    }
}
