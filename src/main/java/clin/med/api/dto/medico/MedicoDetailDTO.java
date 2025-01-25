package clin.med.api.dto.medico;

import clin.med.api.model.Endereco;
import clin.med.api.model.Especialidade;
import clin.med.api.model.Medico;

public record MedicoDetailDTO(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

        public MedicoDetailDTO(Medico medico) {
                this(
                        medico.getId(),
                        medico.getNome(),
                        medico.getEmail(),
                        medico.getTelefone(),
                        medico.getCrm(),
                        medico.getEspecialidade(),
                        medico.getEndereco()
                );
        }

}
