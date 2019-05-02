package fr.eni.enienchere.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ehourman2019
 *
 */
@Data
@Entity(name = "ARTICLES_VENDUS")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_Article")
    private Long idArticle;

    @Column(name = "nom_article")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_debut_encheres")
    private LocalDate auctionStartDate;

    @Column(name = "date_fin_encheres")
    private LocalDate auctionEndDate;

    @Column(name = "prix_initial")
    private int initPrice;

    @Column(name = "prix_vente")
    private int sellPrice;

    @ManyToOne
    @JoinColumn(name = "no_utilisateur")
    private User user;

    @ManyToOne
    @JoinColumn(name = "no_categorie")
    private Category category;

    public Article(String name, String description, LocalDate auctionStartDate, LocalDate auctionEndDate, int initPrice, int sellPrice, User user, Category category) {
        this.name = name;
        this.description = description;
        this.auctionStartDate = auctionStartDate;
        this.auctionEndDate = auctionEndDate;
        this.initPrice = initPrice;
        this.sellPrice = sellPrice;
        this.user = user;
        this.category = category;
    }

    public Article() {
    }
}
