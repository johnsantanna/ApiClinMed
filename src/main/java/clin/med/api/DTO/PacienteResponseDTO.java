package clin.med.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PacienteResponseDTO(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank @CPF
        String cpf,
        String telefone
) {
}
