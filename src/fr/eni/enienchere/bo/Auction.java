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
@Entity
@Table(name = "ENCHERES")
public class Auction implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="no_utilisateur")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="no_article")
    private Article article;

    @Column(name = "date_enchere")
    private LocalDate date;

    @Column(name = "montant_enchere")
    private int price;

    public Auction(User user, Article article, LocalDate date, int price) {
        this.user = user;
        this.article = article;
        this.date = date;
        this.price = price;
    }

    public Auction() {
    }
}
