package com.iot2.estacaometeorologica.web.Controller;

import java.net.URI;
import java.util.List;

import com.iot2.estacaometeorologica.web.dto.UsuarioDTO;
import com.iot2.estacaometeorologica.web.dto.UsuarioLogin;
import com.iot2.estacaometeorologica.web.dto.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iot2.estacaometeorologica.Service.UsuarioService;
import com.iot2.estacaometeorologica.Entity.Usuario;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @CrossOrigin(origins = "*")
    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(novoUsuario.getId());
        usuarioDTO.setName(novoUsuario.getName());
        usuarioDTO.setUsername(novoUsuario.getUsername());
        usuarioDTO.setDataCriacao(novoUsuario.getDataCriacao());
        return ResponseEntity.created(URI.create("/usuarios/" + novoUsuario.getId())).body(usuarioDTO);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setName(usuario.getName());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setDataCriacao(usuario.getDataCriacao());
        return ResponseEntity.ok(usuarioDTO);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/nome/{name}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String name) {
        Usuario usuario = usuarioService.buscarPorNome(name);
        UsuarioDTO user = new UsuarioDTO(usuario);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        return ResponseEntity.ok(user);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/username/{name}")
    public ResponseEntity<?> buscarPorUsername(@PathVariable String name) {
        Usuario usuario = usuarioService.buscarPorUsername(name);
        UsuarioDTO user = new UsuarioDTO(usuario);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        return ResponseEntity.ok(user);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestBody UsuarioLogin user) {
        String username= user.getUsername();
        String password= user.getPassword();
        if (usuarioService.validarLogin(username, password)) {
            Usuario usuario = usuarioService.buscarPorUsername(username);
            System.out.println("usuario "+ usuario);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setName(usuario.getName());
            usuarioDTO.setUsername(usuario.getUsername());
            usuarioDTO.setDataCriacao(usuario.getDataCriacao());
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login inválido.");
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }













//    private final UsuarioService usuarioService;
//
//    @CrossOrigin(origins = "*")
//    @PostMapping
//    public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioCreatDto creatDto){
//
//        Usuario usuario = UsuarioMapper.toUsuario(creatDto);
//
//        Usuario user = usuarioService.salvar(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioDto(user));
//    }
//    @CrossOrigin(origins = "*")
//    @GetMapping
//    public ResponseEntity<List<Usuario>> getAll(){
//        List<Usuario> users = usuarioService.buscaTodosUsuarios();
//        return ResponseEntity.ok(users);
//    }
//    @CrossOrigin(origins = "*")
//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id){
//        Usuario user = usuarioService.buscaPorId(id);
//
//        return ResponseEntity.ok(UsuarioMapper.toUsuarioDto(user));
//    }
//    @GetMapping("/findbynome/{nome}")
//    public ResponseEntity<UsuarioDto> getByNome(@PathVariable String nome) {
//        Usuario usuario = usuarioService.buscaPorNome(nome);
//        return ResponseEntity.ok(UsuarioMapper.toUsuarioDto(usuario));
//    }
//    @CrossOrigin(origins = "*")
//    @PatchMapping("/senha/{id}")
//    public ResponseEntity<UsuarioDto> updatePassword(@RequestBody String senha, @PathVariable Long id){
//        Usuario user = usuarioService.alteraSenha(id, senha);
//        return ResponseEntity.ok(UsuarioMapper.toUsuarioDto(user));
//    }
}
