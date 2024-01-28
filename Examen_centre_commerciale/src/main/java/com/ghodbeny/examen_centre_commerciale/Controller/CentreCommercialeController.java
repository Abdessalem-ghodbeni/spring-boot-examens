package com.ghodbeny.examen_centre_commerciale.Controller;

import com.ghodbeny.examen_centre_commerciale.Entities.CentreCommerciale;
import com.ghodbeny.examen_centre_commerciale.Services.CentreCommercialeServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/centres")
public class CentreCommercialeController {
    private  final CentreCommercialeServices centreCommercialeServices;
    @PostMapping(path = "/add")
    public void ajouterCentre(@RequestBody CentreCommerciale centre){
        centreCommercialeServices.ajoutCentre(centre);
    }

}
