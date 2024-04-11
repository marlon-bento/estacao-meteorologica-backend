package com.iot2.estacaometeorologica.Repository;

import com.iot2.estacaometeorologica.Entity.Sensores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensoresRepository extends JpaRepository<Sensores,Long> {

}
