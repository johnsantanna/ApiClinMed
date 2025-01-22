package clin.med.api.model;

import jakarta.persistence.*;
import lombok.*;
import clin.med.api.DTO.MedicoCadastroDTO;
import clin.med.api.DTO.MedicoUpdateDTO;

@Entity @Table(name = "medicos") // JPA ANNOTATIONS
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id") // LOMBOK ANNOTATIONS
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public int active;

    public Medico(MedicoCadastroDTO medicoCadastroDTO) {
        this.active = 1;
        this.nome = medicoCadastroDTO.nome();
        this.email = medicoCadastroDTO.email();
        this.telefone = medicoCadastroDTO.telefone();
        this.crm = medicoCadastroDTO.crm();
        this.especialidade = medicoCadastroDTO.especialidade();
        this.endereco = new Endereco(medicoCadastroDTO.endereco());
    }

    public void updateDados(MedicoUpdateDTO medicoUpdate) {
        if (medicoUpdate.nome() != null) {this.nome = medicoUpdate.nome();}
        if (medicoUpdate.telefone() != null) {this.telefone = medicoUpdate.telefone();}
        if (medicoUpdate.endereco() != null) {this.endereco.updateDados(medicoUpdate.endereco());}
    }

    public void inativarMedico() {
        this.active = 0;
    }
}
