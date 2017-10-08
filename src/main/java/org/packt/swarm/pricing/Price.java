package org.packt.swarm.pricing;

import javax.persistence.*;

@Entity
@Table(name = "Price")
@NamedQueries({
        @NamedQuery(name="Price.findByName",
                query="SELECT p FROM Price p WHERE p.price = :price"),
})
public class Price {

    @Column(length = 30)
    private String name;
    @Column
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
