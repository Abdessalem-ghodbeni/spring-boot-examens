package com.example.datacenter.Repository;

import com.example.datacenter.Entities.DataCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IDataCenterRepository extends JpaRepository<DataCenter,Integer> {

//    @Query("Select dc From DataCenter dc where dc.dateFabrication > '2019-11-01'")
//    List<DataCenter> listerDataCenter();
@Query("SELECT dc FROM DataCenter dc WHERE dc.dateFabrication > :dateFabrication")
List<DataCenter> listerDataCenter(@Param("dateFabrication") Date dateFabrication);


}
