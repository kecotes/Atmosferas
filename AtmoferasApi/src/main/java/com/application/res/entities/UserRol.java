package com.application.res.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario_rol")
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_usuario")
    private Long iduser;
    @Column(name = "tipo_rol")
    private String type_rol;
    @Column(name = "activo")
    private Integer active;

}
