package clin.med.api.service;

import clin.med.api.DTO.MedicoCadastroDTO;
import clin.med.api.DTO.MedicoConsultaDTO;
import clin.med.api.DTO.MedicoUpdateDTO;
import clin.med.api.model.Medico;
import clin.med.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repositorio;

    public Page<MedicoConsultaDTO> showMedicosDto(Pageable paginacao) {
        int active = 1;
        Page<Medico> medicos = repositorio.findAllByActiveIs(paginacao, active);
        return medicos.map(medico -> new MedicoConsultaDTO(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade()));
    }

    public Medico addMedicoDto(MedicoCadastroDTO medicoCadastroDTO) {
        Medico medico = new Medico(medicoCadastroDTO);
        repositorio.save(medico);
        return medico;
    }

    // O `UPDATE` ocorre no commit da transação (@Transactional) via JPA.
    public Medico updateMedico(MedicoUpdateDTO medicoUpdate) {
        var medico = repositorio.findMedicoById(medicoUpdate.id());
        medico.get().updateDados(medicoUpdate);
        return medico.get();
    }

    public void inativeMedico(Long id) {
        var medico = repositorio.getReferenceById(id);
        medico.inativarMedico();
    }

    public Medico detalharMedico(Long id) {
        return repositorio.getReferenceById(id);
    }
}