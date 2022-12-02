package br.com.eventos.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eventos.models.Evento;
import br.com.eventos.repository.EventoRepository;

@RestController // Anotação parecida como o @Controller, mas como é um projeto webservice
				// usaremos o @RestController
//@RequestMapping("/evento") // url da requisição, comentei para colocar no metodo findById
public class EventoResource {

	@Autowired // Anotação para fazer automaticamente as injeções de dependencia da interface
				// EventoRepository
	private EventoRepository er; // acesso aos metodos de acesso ao banco, como findAll, save, delete, findById

	@GetMapping(value = "/evento", produces = "application/json") // Requisição GET, do tipo json
	public Iterable<Evento> listaEventos() {
		Iterable<Evento> todosEventos = er.findAll();
		return todosEventos;
	}

	@PostMapping() // Metodo que irá enviar o evendo para ser salvo, do tipo POST
	public Evento cadastroEvento(@RequestBody Evento evento) { // Esse metodo vai receber um evendo pelo corpo da
																// requisição, por isso usamos a anotação @RequestBody,
																// a anotação @Validated é devido ao uso da anotação
																// @NotNull na classe modelo evento
		Evento eventoCadastrado = er.save(evento);
		return eventoCadastrado;
	}

	@DeleteMapping() // Anotação para deletar objeto do banco
	@RequestMapping(value = "/evento/delete")
	public Evento deletaEvento(@RequestBody Evento evento) { // Sera deletado o evento que irá também pelo corpo da
																// requisição (@RequestBody)
		er.delete(evento);
		return evento; // O retorno vai ser o proprio evento passado pelo corpo da requisição
	}

	@GetMapping(value = "/evento/{id}", produces = "application/json")
	public Optional<Evento> listaEventoPorId(@PathVariable String id) {
		Optional<Evento> evento = er.findById(id);
		return evento;
	}
	
	@DeleteMapping(value = "/evento/{id}") // Anotação para deletar objeto do banco
	public void deletaEventoPorId(@PathVariable String id) { // Sera deletado o evento que irá também pelo corpo da
		er.deleteById(id);
	}
}
