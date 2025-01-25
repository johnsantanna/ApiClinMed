package clin.med.api.dto.paciente;

import clin.med.api.dto.EnderecoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record PacienteCreateDTO(
        Long id,
        @NotBlank
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank
        @CPF
        String cpf,
        @Pattern(regexp = "\\d{10,20}", message = "{telefone.invalido}")
        String telefone,
        EnderecoDTO endereco
) {
}
