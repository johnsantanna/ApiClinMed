package clin.med.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import clin.med.api.model.Especialidade;

public record MedicoConsultaDTO(

        Long id, @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade) {
}
