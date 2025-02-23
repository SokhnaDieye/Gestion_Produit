package com.isi.gestion_produits.dao;

import com.isi.gestion_produits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitDao extends JpaRepository<Produit, Long> {
    List<Produit> findByDesignationContaining(String keyword);
}