package com.iot2.estacaometeorologica.Service;

import com.iot2.estacaometeorologica.Entity.Sensores;
import com.iot2.estacaometeorologica.Repository.SensoresRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SensoresService {
    private final SensoresRepository sensoresRepository;
    @Transactional
    public List<Sensores> buscarTodosSensores() {
        return sensoresRepository.findAll();

    }

    @Transactional
    public Sensores salvar(Sensores sensores) {
        return sensoresRepository.save(sensores);
    }
    
}
