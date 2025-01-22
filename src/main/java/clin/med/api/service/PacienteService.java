package clin.med.api.service;

import jakarta.validation.Valid;
import clin.med.api.DTO.PacienteCreateDTO;
import clin.med.api.DTO.PacienteResponseDTO;
import clin.med.api.DTO.PacienteUpdateDTO;
import clin.med.api.model.Paciente;
import clin.med.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repositorio;

    public Page<PacienteResponseDTO> showPacientes(Pageable paginacao) {
        return repositorio.findAllByActiveIs(paginacao,1).map(p -> new PacienteResponseDTO(p.getId(), p.getNome(),p.getEmail(),p.getCpf(), p.getTelefone()));
    }

    public Paciente addPaciente(@Valid PacienteCreateDTO pacienteCreateDTO) {
        Paciente paciente = new Paciente(pacienteCreateDTO);
        repositorio.save(paciente);
        return paciente;
    }

    public Paciente updatePaciente(@Valid PacienteUpdateDTO pacienteUpdateDTO) {
        Optional<Paciente> paciente = repositorio.findById(pacienteUpdateDTO.id());
        paciente.ifPresent(p -> p.updatePaciente(pacienteUpdateDTO));
        return paciente.get();
    }

    public void deletePaciente(Long id) {
        Optional<Paciente> paciente = repositorio.findById(id);
        paciente.ifPresent(p -> p.active = 0);
    }
}
