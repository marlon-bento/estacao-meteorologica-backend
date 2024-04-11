package com.iot2.estacaometeorologica.web.dto;

import com.iot2.estacaometeorologica.Entity.Usuario;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioDTO {
    private Long id;
    private String name;
    private String username;
    private LocalDateTime dataCriacao;

    public UsuarioDTO(Usuario user){
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.dataCriacao = user.getDataCriacao();
    }
}
