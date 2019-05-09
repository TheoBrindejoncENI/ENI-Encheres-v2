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
@Table(name = "UTILISATEURS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_utilisateur")
    private Long idUser;

    @Column(name = "pseudo")
    private String userName;

    @Column(name = "nom")
    private String lastName;

    @Column(name = "prenom")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String phoneNumber;

    @Column(name = "rue")
    private String street;

    @Column(name = "code_postal")
    private String postalCode;

    @Column(name = "ville")
    private String city;

    @Column(name = "mot_de_passe")
    private String password;

    @Column(name = "credit")
    private Integer money;

    @Column(name = "administrateur")
    private boolean userAdmin;

    public User(String userName, String lastName, String firstName, String email, String phoneNumber, String street,
                String postalCode, String city, String password, Integer money, boolean userAdmin) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.money = money;
        this.userAdmin = userAdmin;
    }

    public User(String userName, String lastName, String firstName, String email, String phoneNumber, String street, String postalCode, String city, String password) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
    }

    public User() {
    }

}

