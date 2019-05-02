package fr.eni.enienchere.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author ehourman2019
 *
 */
@Data
@Entity(name = "RETRAITS")
public class PickUp  implements Serializable {

    @Id
    @ManyToOne
    @Column(name = "no_article")
    private Article article;

    @Column(name = "rue")
    private String street;

    @Column(name = "code_postal")
    private String postalCode;

    @Column(name = "ville")
    private String city;

    public PickUp(Article article, String street, String postalCode, String city) {
        this.article = article;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public PickUp() {
    }
}
