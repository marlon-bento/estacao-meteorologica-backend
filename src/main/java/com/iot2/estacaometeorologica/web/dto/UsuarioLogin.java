package com.iot2.estacaometeorologica.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioLogin {
    private String username;
    private String password;
}
