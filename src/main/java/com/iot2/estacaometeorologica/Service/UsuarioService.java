package com.iot2.estacaometeorologica.Service;
import com.iot2.estacaometeorologica.Entity.Usuario;
import com.iot2.estacaometeorologica.Repository.UsuarioRepository;

import com.iot2.estacaometeorologica.web.dto.UsuarioCreatDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario buscarPorNome(String name) {
        return usuarioRepository.findByName(name);
    }

    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean validarLogin(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario != null){
            System.out.println("==========================Entrei aqui tem usuario============================");
        }else{
            System.out.println("===========================Entrei aqui tem usuario===================");
        }
        return usuario != null && usuario.getPassword().equals(password);
    }
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }












//    private final UsuarioRepository usuarioRepository;
//
//    @Transactional
//    public Usuario salvar(Usuario usuario){
//        //save já está criado na extensão da jpa repository
//        return usuarioRepository.save(usuario);
//    }
//
//    @Transactional
//    public Usuario buscaPorId(Long id){
//        //find já está criado na extensão da jpa repository
//        return usuarioRepository.findById(id).orElseThrow(
//            () -> new RuntimeException("Usuário não encontrado.")
//        );
//    }
//    @Transactional
//    public Usuario buscaPorNome(String nome) {
//        return usuarioRepository.findByNome(nome).orElseThrow(
//                () -> new RuntimeException("Usuário não encontrado.")
//        );
//    }
//
//    @Transactional
//    public List<Usuario> buscaTodosUsuarios(){
//        return usuarioRepository.findAll();
//    }
//
//    @Transactional
//    public Usuario alteraSenha(Long id, String password) {
//        Usuario user = buscaPorId(id);
//        user.setPassword(password);
//        //o hibernate já sabe automaticamente que a senha foi trocada e atualiza
//        return user;
//    }
}
