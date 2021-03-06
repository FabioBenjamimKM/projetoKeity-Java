package com.agendamento.consulta.horario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horarios")
public class horarioRest {

	@Autowired
	horarioService _service;
	
	@GetMapping("/{idJornada}")
	public List<horarioEntity> getHorarios(@PathVariable String idJornada) {
		return _service.getHorarios(idJornada);
	}
	
	@PutMapping("/{idHorario}/{nomePaciente}/{idPaciente}")
	public List<horarioEntity> atualizaHorario(@PathVariable Long idHorario, @PathVariable String nomePaciente,@PathVariable String idPaciente) {
		return _service.atualizaHorario(idHorario, nomePaciente, Long.parseLong(idPaciente));
	}
	
	@PutMapping("consultaRealizada/{idHorario}/{nomePaciente}/{idPaciente}/{consultaStatus}")
	public List<horarioEntity> atualizaHorario(@PathVariable Long idHorario, @PathVariable String nomePaciente,@PathVariable String idPaciente,@PathVariable String consultaStatus) {
		return _service.atualizaHorarios(idHorario, nomePaciente, Long.parseLong(idPaciente), consultaStatus);
	}
	
	@GetMapping("/paciente/{idPaciente}")
	public List<horarioEntity> getHorariosPacientes(@PathVariable String idPaciente){
		return _service.getHorariosPacientes(Long.parseLong(idPaciente));
	}
}
