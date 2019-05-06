package fr.eni.enienchere.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author ehourman2019
 *
 */
@Data
@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_categorie")
    private Long idCategory;

    @Column(name = "libelle")
    private String title;

    public Category(String title) {
        this.title = title;
    }

    public Category() {
    }
}
