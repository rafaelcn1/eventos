package br.com.eventos.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity // A classe será uma tabela no banco
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id// Informando que a coluna no banco será um ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O valor será gerado automaticamente
	private Integer codigo;

	//@NotNull // Anotação para validação de nulo ou branco
	private String nome;

	//@NotNull // Anotação para validação de nulo ou branco
	private String local;

	//@NotNull // Anotação para validação de nulo ou branco
	private String data;

	//@NotNull // Anotação para validação de nulo ou branco
	private String horario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
