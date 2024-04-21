package com.master.controller;

import com.master.model.Demande;
import com.master.service.DemandeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DemandeController {
    @Autowired
    DemandeService demandeService;

    @GetMapping("/")
    public String showHome() {
        return "redirect:/demande";
    }

    @GetMapping("/demande")
    public String showDemandeForm(Model model) {
        model.addAttribute("demandes", demandeService.getAllDemandes());
        model.addAttribute("demande", new Demande());
        return "demande";
    }
    @PostMapping("/addDemande")
    public String addDemande(@Valid Demande demande, BindingResult bindingResult, RedirectAttributes rdAttributes) {
        Demande newDemande = demandeService.findById(demande.getId());
        if (newDemande != null) {
            bindingResult.rejectValue("id", "error.demande", "L'identifiant existe déjà");
        }
        if (bindingResult.hasErrors()) {
            rdAttributes.addFlashAttribute("error", "Erreur lors de l'ajout de la demande");
            return "redirect:/demande";
        }
        demandeService.saveDemande(demande);
        rdAttributes.addFlashAttribute("success", "Demande ajoutée avec succès");
        return "redirect:/demande";
    }
    @PostMapping("/updateDemande")
    public String updateDemande(@Valid Demande demande, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la modification de la demande");
            return "redirect:/demande";
        }
        demandeService.saveDemande(demande);
        redirectAttributes.addFlashAttribute("success", "Demande modifiée avec succès");
        return "redirect:/demande";
    }
    @GetMapping("/demandeDelete/{id}")
     public String deleteDemande(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
          System.out.println("delete method triggerd !!");
          System.out.println("id = " + id);
          demandeService.deleteDemande(id);
          redirectAttributes.addFlashAttribute("success", "Demande supprimée avec succès");
          return "redirect:/demande";
     }

}
