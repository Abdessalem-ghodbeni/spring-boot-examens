package com.ghodbeny.examen_centre_commerciale.Repository;

import com.ghodbeny.examen_centre_commerciale.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Long> {

}
