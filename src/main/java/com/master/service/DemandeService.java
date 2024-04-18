package com.master.service;

import com.master.model.Demande;
import com.master.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {
    @Autowired
    DemandeRepository demandeRepository;
    public Demande saveDemande(Demande demande) {
        return demandeRepository.save(demande);
    }
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }
    public Demande findById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }
}
