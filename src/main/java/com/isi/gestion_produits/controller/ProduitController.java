
package com.isi.gestion_produits.controller;

import com.isi.gestion_produits.model.Produit;
import com.isi.gestion_produits.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    public String listproduits(Model model) {
        model.addAttribute("produits", produitService.getAllproduits());
        model.addAttribute("produit", new Produit());
        return "produits";
    }

    @PostMapping("/produits")
    public String addproduit(@Valid @ModelAttribute Produit produit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("produits", produitService.getAllproduits());
            return "produits";
        }
        produitService.addproduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/produits/edit/{id}")
    public String editProduit(@PathVariable Long id, Model model) {
        Produit produit = produitService.getproduitById(id);
        model.addAttribute("produit", produit);
        model.addAttribute("produits", produitService.getAllproduits());
        return "produits";
    }

    @PostMapping("/produits/update/{id}")
    public String updateProduit(@PathVariable Long id, @Valid @ModelAttribute Produit produit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("produits", produitService.getAllproduits());
            return "produits";
        }
        produit.setId(id);
        produitService.updateproduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/produits/delete/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitService.deleteproduit(id);
        return "redirect:/produits";
    }
    @GetMapping("/produits/search")
    public String searchproduits(@RequestParam String keyword, Model model) {
        model.addAttribute("produits", produitService.searchproduits(keyword));
        model.addAttribute("produit", new Produit());
        return "produits";
    }
}
