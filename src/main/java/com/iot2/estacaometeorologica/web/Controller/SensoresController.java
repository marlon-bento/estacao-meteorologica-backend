package com.iot2.estacaometeorologica.web.Controller;

import com.iot2.estacaometeorologica.Entity.Sensores;
import com.iot2.estacaometeorologica.Entity.Usuario;
import com.iot2.estacaometeorologica.Service.SensoresService;
import com.iot2.estacaometeorologica.web.dto.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/sensores")
public class SensoresController {
    private final SensoresService sensoresService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Sensores> postSensores(@RequestBody Sensores sensores){
        Sensores resposta = sensoresService.salvar(sensores);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Sensores>> getAll(){
        List<Sensores> sensores = sensoresService.buscarTodosSensores();
        return ResponseEntity.ok(sensores);
    }
}
