package com.master.controller;

import com.master.model.Demande;
import com.master.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DemandeController {
    @Autowired
    DemandeService demandeService;

    @GetMapping("/demande")
    public String showDemandeForm(Model model) {
        model.addAttribute("demandes", demandeService.getAllDemandes());
        model.addAttribute("demande", new Demande());
        return "demande";
    }
    @PostMapping("/addDemande")
    public String addDemande(@Valid Demande demande, BindingResult bindingResult) {
        Demande newDemande = demandeService.findById(demande.getId());
        if (newDemande != null) {
            bindingResult.rejectValue("id", "error.demande", "L'identifiant existe déjà");
        }
        if (bindingResult.hasErrors()) {
            return "redirect:/demande";
        }
        demandeService.saveDemande(demande);
        return "redirect:/demande";
    }
}
