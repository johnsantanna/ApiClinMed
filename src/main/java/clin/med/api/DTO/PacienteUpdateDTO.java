package clin.med.api.DTO;

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
