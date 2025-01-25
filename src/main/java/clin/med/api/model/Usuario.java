package clin.med.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios") // JPA ANNOTATIONS
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // LOMBOK ANNOTATIONS
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

}
