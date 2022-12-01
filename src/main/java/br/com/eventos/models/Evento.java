package br.com.eventos.models;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // A classe será uma tabela no banco
public class Evento {

	@Id // Informando que a coluna no banco será um ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O valor será gerado automaticamente
	private long codigo;

	@NonNull // Anotação para validação de nulo ou branco
	private String nome;

	@NonNull // Anotação para validação de nulo ou branco
	private String local;

	@NonNull // Anotação para validação de nulo ou branco
	private String data;

	@NonNull // Anotação para validação de nulo ou branco
	private String horario;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
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
