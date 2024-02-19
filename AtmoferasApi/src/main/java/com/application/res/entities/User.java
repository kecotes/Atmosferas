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
@Table(name = "usuario")
public class User {

    @Id //id_usuario es el id principal
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA genra el id unico para la entidad es como un auto_icrement
    private Long id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "correo")
    private String email;
    @Column(name = "contrasena")
    private String password;
    @Column(name = "tipo_documento")
    private String type_document;
    @Column(name = "documento")
    private String document;
    @Column(name = "country")
    private String pais;
    @Column(name = "departamento")
    private String department;
    @Column(name = "ciudad")
    private String city;
    @Column(name = "direccion")
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    @ManyToOne
    @JoinColumn(name = "id_usuario_rol", nullable = false) //nullable false indica que siempre tiene que estar esta relación
    private UserRol rol;
}
