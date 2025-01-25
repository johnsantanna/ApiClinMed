package clin.med.api.dto.paciente;

import clin.med.api.dto.EnderecoDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        String telefone,
        EnderecoDTO endereco
) {
}
