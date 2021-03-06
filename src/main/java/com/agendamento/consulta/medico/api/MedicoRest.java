package com.agendamento.consulta.medico.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.lastLogin.LastLoginService;
import com.agendamento.consulta.medico.MedicoEntity;
import com.agendamento.consulta.medico.MedicoRepository;
import com.agendamento.consulta.medico.MedicoService;
import com.agendamento.consulta.medico.api.dto.MedicoEspecializacoes;

@RestController
@RequestMapping("/medicos")
public class MedicoRest {

	@Autowired
	MedicoService _service;
	
	@Autowired
	LastLoginService _serviceLastLoginMedico;

	@Autowired
	MedicoRepository medicos;

	@GetMapping(value = { "/{idMedico}", "" })
	public Optional<MedicoEntity> getMedicos(@PathVariable Optional<Long> idMedico) {
		return _service.getMedicos(idMedico.get());
	}

	@GetMapping("/buscaMedico/{especializacao}")
	public List<MedicoEntity> getMedicos(@PathVariable String especializacao) {
		return _service.getMedicoEspecialidade(especializacao);
	}

	@GetMapping("/especializacoes")
	public List<MedicoEspecializacoes> getEspecializacao() {
		return _service.getEspecializacao();
	}

	@PostMapping("/medico1")
	public Optional<MedicoEntity> getMedico1(@RequestParam String cpf) {
		return _service.getMedico(cpf);
	}

	@PostMapping("/medico")
	public Optional<MedicoEntity> getMedico(@RequestParam Long idMedico) {
		return _service.getMedico(idMedico);
	}

	@PostMapping
	public ResponseEntity createMedico(@RequestBody MedicoEntity medico) {
		return _service.createMedicos(medico);
	}

	@PutMapping("/consultorios")
	public ResponseEntity adicionaConsultorios(@RequestBody MedicoEntity medico) {
		return _service.adicionaConsultorios(medico);
	}

	@PostMapping("/{Autentica}")
	public ResponseEntity<Boolean> Login(@RequestBody MedicoEntity medicoRequest) {
		Optional<MedicoEntity> medico = medicos.findByCpf(medicoRequest.getCpf());
		if (medico != null && medico.get().getSenha().equals(medicoRequest.getSenha())) {
			_serviceLastLoginMedico.saveLastLoginMedico(medico.get());
			return ResponseEntity.ok(true);
		} else {
			return (ResponseEntity<Boolean>) ResponseEntity.badRequest();
		}
	}

	@PutMapping("/trocaSenha")
	public ResponseEntity atualizarMedico(@RequestBody MedicoEntity medico) {
		if (medico.getIdMedico() != null) {
			Optional<MedicoEntity> medicoChange = medicos.findById(medico.getIdMedico());
			medicoChange.get().atualizarMedico(medico);
			medicos.save(medicoChange.get());
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}

}
