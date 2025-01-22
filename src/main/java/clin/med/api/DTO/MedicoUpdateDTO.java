package clin.med.api.DTO;

import jakarta.validation.constraints.NotNull;
import clin.med.api.model.Endereco;

public record MedicoUpdateDTO(@NotNull Long id, String nome, String telefone, Endereco endereco)
{
}
