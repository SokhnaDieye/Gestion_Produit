package com.isi.gestion_produits.service;

import com.isi.gestion_produits.dao.ProduitDao;
import com.isi.gestion_produits.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService {
    @Autowired
    private ProduitDao produitDao;

    public void addproduit(Produit produit) {
        produitDao.save(produit);
    }

    public List<Produit> getAllproduits() {
        return produitDao.findAll();
    }

    public List<Produit> searchproduits(String keyword) {
        return produitDao.findByDesignationContaining(keyword);
    }

    public Produit getproduitById(Long id) {
        return produitDao.findById(id).orElse(null);
    }

    public void updateproduit(Produit produit) {
        produitDao.save(produit);
    }

    public void deleteproduit(Long id) {
        produitDao.deleteById(id);
    }
}