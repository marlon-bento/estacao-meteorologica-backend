package com.iot2.estacaometeorologica.web.dto.mapper;
import com.iot2.estacaometeorologica.Entity.Usuario;
import com.iot2.estacaometeorologica.web.dto.UsuarioCreatDto;
import com.iot2.estacaometeorologica.web.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioCreatDto creatDto){
        return new ModelMapper().map(creatDto, Usuario.class);
    }
    public static Usuario toUsuario(UsuarioDTO userDto){
        return new ModelMapper().map(userDto, Usuario.class);
    }
    public static UsuarioCreatDto toUsuarioCreatDto(Usuario user){
        return new ModelMapper().map(user, UsuarioCreatDto.class);
    }
    public static UsuarioDTO toUsuarioDto(Usuario user){

        return new ModelMapper().map(user, UsuarioDTO.class);
    }
}
