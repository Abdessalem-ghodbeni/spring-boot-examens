package com.ghodbeny.examen_centre_commerciale.Repository;

import com.ghodbeny.examen_centre_commerciale.Entities.CentreCommerciale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICentreCommercialeRepository extends JpaRepository<CentreCommerciale,Long> {
}
