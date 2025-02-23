package com.isi.gestion_produits.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La référence ne peut pas être vide")
    private String reference;

    @NotBlank(message = "La désignation ne peut pas être vide")
    private String designation;

    @Min(value = 100, message = "Le prix doit être supérieur à 100")
    private double prix;

    private int quantite;

    public Produit() {
    }

    public Produit(Long id, String reference, String designation, double prix, int quantite) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "La référence ne peut pas être vide") String getReference() {
        return reference;
    }

    public void setReference(@NotBlank(message = "La référence ne peut pas être vide") String reference) {
        this.reference = reference;
    }

    public @NotBlank(message = "La désignation ne peut pas être vide") String getDesignation() {
        return designation;
    }

    public void setDesignation(@NotBlank(message = "La désignation ne peut pas être vide") String designation) {
        this.designation = designation;
    }

    public  double getPrix() {
        return prix;
    }

    public void setPrix(@Min(value = 100, message = "Le prix doit être supérieur à 100") double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite( int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
