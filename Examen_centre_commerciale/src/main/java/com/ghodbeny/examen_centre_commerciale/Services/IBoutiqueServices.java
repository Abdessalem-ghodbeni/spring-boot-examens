package com.ghodbeny.examen_centre_commerciale.Services;

import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.Client;

import java.util.List;

public interface IBoutiqueServices {
    void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
    List<Boutique> listeBoutiques(Long idCentre);
}
