package com.iot2.estacaometeorologica.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length=100)
    private String name;

    @Column(name = "username", nullable = false, unique = true, length=100)
    private String username;

    @Column(name = "password", nullable= false)
    private String password;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    // Método que será executado antes de persistir a entidade pela primeira vez
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//
//
//    @Column(name = "name", nullable = false, unique = true, length=100)
//    private String name;
//
//    @Column(name = "username", nullable = false, unique = true, length=100)
//    private String username;
//
//
//    @Column(name = "password", nullable= false)
//    private String password;
//
//
//
//    @Column(name = "data_criacao")
//    private LocalDateTime dataCriacao;
//
//    @Column(name = "data_modificacao")
//    private LocalDateTime dataModificacao;
//
//    @Column(name = "criador_por")
//    private String criadoPor;
//
//    @Column(name = "modificado_por")
//    private String modificadoPor;
//
//
//    // Método que será executado antes de persistir a entidade pela primeira vez
//    @PrePersist
//    protected void onCreate() {
//        this.dataCriacao = LocalDateTime.now();
//    }
//    @Override
//    public boolean equals(Object o){
//        if(this == o) return true;
//        if(o == null || getClass() != o.getClass()) return false;
//        Usuario usuario = (Usuario) o;
//        return Objects.equals(id, usuario.id);
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(id);
//    }
//    //padrão de retornar só o id
//    @Override
//    public String toString() {
//        return "Usuario{"+
//        "id=" + id +"}";
//    }


}
