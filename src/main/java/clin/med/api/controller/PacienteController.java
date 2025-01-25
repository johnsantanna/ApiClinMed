package clin.med.api.controller;

import jakarta.validation.Valid;
import clin.med.api.dto.paciente.PacienteCreateDTO;
import clin.med.api.dto.paciente.PacienteDetailDTO;
import clin.med.api.dto.paciente.PacienteResponseDTO;
import clin.med.api.dto.paciente.PacienteUpdateDTO;
import clin.med.api.service.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService servico;

    @GetMapping
    public ResponseEntity<Page<PacienteResponseDTO>> showPacientes(Pageable paginacao) {
        var page = servico.showPacientes(paginacao);
        return ResponseEntity.ok(page);
    }

    @PostMapping @Transactional
    public ResponseEntity addPaciente(@RequestBody @Valid PacienteCreateDTO pacienteCreateDTO, UriComponentsBuilder uriBuilder) {
        var paciente = servico.addPaciente(pacienteCreateDTO);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteDetailDTO(paciente));
    }

    @PutMapping @Transactional
    public ResponseEntity updatePaciente(@RequestBody @Valid PacienteUpdateDTO pacienteUpdateDTO){
        var paciente = servico.updatePaciente(pacienteUpdateDTO);
        return ResponseEntity.ok(new PacienteDetailDTO(paciente));
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deletePaciente(@PathVariable Long id){
        servico.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPaciente(@PathVariable Long id){
        return ResponseEntity.ok(new PacienteDetailDTO(servico.detalharPaciente(id)));
    }

}
