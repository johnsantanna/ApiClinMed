package clin.med.api.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import clin.med.api.model.Especialidade;

public record MedicoCadastroDTO(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank @Size(min = 10, max = 20)
        String telefone,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        EnderecoDTO endereco) {
}
