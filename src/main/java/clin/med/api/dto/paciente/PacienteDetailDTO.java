package clin.med.api.dto.paciente;

import clin.med.api.model.Endereco;
import clin.med.api.model.Paciente;

public record PacienteDetailDTO(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public PacienteDetailDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
