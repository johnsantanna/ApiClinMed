package clin.med.api.dto.medico;

import clin.med.api.dto.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import clin.med.api.model.Especialidade;

public record MedicoCadastroDTO(

        Long id,
        @NotBlank
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 10, max = 20, message = "Telefone inválido")
        String telefone,
        @NotBlank(message = "{crm.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
        String crm,
        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        EnderecoDTO endereco) {
}
