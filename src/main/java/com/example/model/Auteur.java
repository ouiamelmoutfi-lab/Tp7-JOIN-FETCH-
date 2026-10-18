package com.example.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auteurs")

@NamedEntityGraph(
        name = "Auteur.livres",
        attributeNodes = @NamedAttributeNode("livres")
)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livre> livres = new ArrayList<>();

    // Constructeurs, getters et setters

    public Auteur() {
    }

    public Auteur(String nom, List<Livre> livres) {
        this.nom = nom;
        this.livres = livres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        livre.setAuteur(this);
    }

    public void retirerLivre(Livre livre) {
        livres.remove(livre);
        livre.setAuteur(null);
    }
}
