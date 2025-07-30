package br.itb.projeto.BarbeariaChicoLeme.model.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.itb.projeto.BarbeariaChicoLeme.model.entity.Usuario;
import br.itb.projeto.BarbeariaChicoLeme.model.service.UsuarioService;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/todos")
	public List<Usuario> getAll(Model model){
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		return usuarios;
	}
}
