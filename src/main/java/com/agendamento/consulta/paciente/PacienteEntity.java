package com.agendamento.consulta.paciente;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.agendamento.consulta.medico.MedicoEntity;
import com.agendamento.consulta.notas.NotaEntity;
import com.agendamento.consulta.util.SexoEnum;

@Entity
@Table(name = "PACIENTES" )
public class PacienteEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private SexoEnum sexo;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String cep;
	
	@Column
	private String endereco;
	
	@Column
	private String numero;
	
	@Column
	private String complemento;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;

	@Column
	private String cpf;
	
	@Column
	private String rg;
	
	@Column
	private String senha;
	
	@Column
	private String lat;
	
	@Column
	private String lng;
	
	@ElementCollection
	private Collection<Integer> avaliacao;
	

	
	public void atualizarPaciente(PacienteEntity pacientes) {
		this.avaliacao.addAll(pacientes.getAvaliacao());
	}
	
	
	public Collection<Integer> getAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(Collection<Integer> avaliacao) {
		this.avaliacao = avaliacao;
	}


	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}
	
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
	
		
}
