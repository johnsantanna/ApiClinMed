package clin.med.api.controller;

import jakarta.validation.Valid;
import clin.med.api.DTO.MedicoCadastroDTO;
import clin.med.api.DTO.MedicoConsultaDTO;
import clin.med.api.DTO.MedicoDetailDTO;
import clin.med.api.DTO.MedicoUpdateDTO;
import clin.med.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService servico;

    @PostMapping @Transactional
    public ResponseEntity addMedico(@RequestBody @Valid MedicoCadastroDTO medico, UriComponentsBuilder uriBuilder) {
        var medico_ = servico.addMedicoDto(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico_.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDetailDTO(medico_));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoConsultaDTO>> showMedicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){ //direction = Sort.Direction.DESC
        var page = servico.showMedicosDto(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping @Transactional
    public ResponseEntity updateMedico(@RequestBody @Valid MedicoUpdateDTO medicoUpdate){
        var medico = servico.updateMedico(medicoUpdate);
        return ResponseEntity.ok(new MedicoDetailDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id){
        servico.inativeMedico(id);
        return ResponseEntity.noContent().build();
    }

}
