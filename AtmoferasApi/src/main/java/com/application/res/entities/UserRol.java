package com.application.res.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "tipo_rol")
    private String type_rol;
    @Column(name = "activo")
    private Integer active;


    /***
     * Un UserRol puede tener muchos User
     * Vamos a mapear el atributo idserol
     * fetch hace que no se sobrecargue el listado cuando haya un userRol, solamente se van a añadir datos a la
     * lista cuando se necesite
     * orphanRemoval hace que cuando se elimine el UserRol también se eliminen todos sus usuarios. Un user no puede
     * existir si no existe una categoria de el
     * Con @JsonIgnore permitimos que los datos sean serializados o agregados al userList
     ***/
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<User> userList = new ArrayList<>();
}
