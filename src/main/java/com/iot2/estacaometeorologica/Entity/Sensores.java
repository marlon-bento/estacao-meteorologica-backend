package com.iot2.estacaometeorologica.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sensores")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Sensores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sensor_temperatura", nullable= false)
    private double sensorTemp;

    @Column(name = "sensor_umidade", nullable= false)
    private double sensorUmidade;

    @Column(name = "sensor_pressao", nullable= false)
    private double sensorPressao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Sensores sensores = (Sensores) o;
        return Objects.equals(id, sensores.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    //padrão de retornar só o id
    @Override
    public String toString() {
        return "Sensor{"+
                "id=" + id +"}";
    }
}
