package com.master.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Demande {
    @Id
    @NotNull
    @Size(min = 1, max = 12, message = "La taille de l'identifiant doit être entre 1 et 12 caractères")
    private Long id;
    @Size(min = 10, max = 50, message = "La taille de la description doit être entre 10 et 50 caractères")
    private String description;

}
