package com.agendamento.consulta.consultorio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.consulta.consultorio.ConsultorioEntity;
import com.agendamento.consulta.consultorio.ConsultorioService;

@RestController
@RequestMapping("/consultorios")
public class ConsultorioRest {
	
	@Autowired
	ConsultorioService _service;
	
	@GetMapping
	public List<ConsultorioEntity> getConsultorios() {
		return _service.getConsultorios();
	}
	
	@PostMapping
	public ResponseEntity createConsultorio(@RequestBody ConsultorioEntity consultorio) {
		return _service.createConsultorios(consultorio);
	}
	
	@PutMapping 
	public ResponseEntity atualizateConsultorio(@RequestBody ConsultorioEntity consultorio) {
		return _service.atualizateConsultorio(consultorio);
	}
	
//	@PutMapping("/medicos")
//	public ResponseEntity adicionaMedicoConsultorio(@RequestBody ConsultorioEntity consultorio) {
//		return _service.adicionaMedico(consultorio);
//	}
	
	@PutMapping("/agenda")
	public ResponseEntity adicionaAgendaConsultorio(@RequestParam Long idConsultorio, @RequestParam Long idMedico) {
		return _service.adicionaAgenda(idConsultorio, idMedico);
	}
}