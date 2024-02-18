package com.application.res.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table("usuario")
public class User {

    @Id //id_usuario es el id principal
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA genra el id unico para la entidad es como un auto_icrement
    private Long id_usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String tipo_documento;
    private String documento;
    private String pais;
    private String departamento;
    private String ciudad ;
    private String direccion;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
}
