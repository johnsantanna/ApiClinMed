package clin.med.api.model;

import jakarta.persistence.*;
import lombok.*;
import clin.med.api.dto.paciente.PacienteCreateDTO;
import clin.med.api.dto.paciente.PacienteUpdateDTO;

@Entity
@Table(name = "pacientes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco;

    public int active;

    public Paciente(PacienteCreateDTO pacienteCreateDTO) {
        this.active = 1;
        this.nome = pacienteCreateDTO.nome();
        this.email = pacienteCreateDTO.email();
        this.cpf = pacienteCreateDTO.cpf();
        this.telefone = pacienteCreateDTO.telefone();
        this.endereco = new Endereco(pacienteCreateDTO.endereco());
    }

    public void updatePaciente(PacienteUpdateDTO pacienteUpdateDTO) {
        if (pacienteUpdateDTO.nome() != null) this.nome = pacienteUpdateDTO.nome();
        if (pacienteUpdateDTO.telefone() != null) this.telefone = pacienteUpdateDTO.telefone();
        if (pacienteUpdateDTO.endereco() != null) this.endereco.updateDados(pacienteUpdateDTO.endereco());
    }

}
