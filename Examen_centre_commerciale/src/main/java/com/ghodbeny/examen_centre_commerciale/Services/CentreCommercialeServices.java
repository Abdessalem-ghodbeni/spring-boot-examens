package com.ghodbeny.examen_centre_commerciale.Services;


import com.ghodbeny.examen_centre_commerciale.Entities.Boutique;
import com.ghodbeny.examen_centre_commerciale.Entities.CentreCommerciale;
import com.ghodbeny.examen_centre_commerciale.Repository.IBoutiqueRepository;
import com.ghodbeny.examen_centre_commerciale.Repository.ICentreCommercialeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CentreCommercialeServices implements ICentreCommercialeServie{

private final IBoutiqueRepository iBoutiqueRepository;
    private final ICentreCommercialeRepository centreCommercialeRepository;
    @Transactional
    @Override
    public void ajoutCentre(CentreCommerciale centre) {
        centreCommercialeRepository.save(centre);
        Set<Boutique> boutiques = centre.getBoutiques();
        for (Boutique boutique : boutiques) {

            boutique.setCentreCommerciale(centre);

            iBoutiqueRepository.save(boutique);
        }

        }


}
