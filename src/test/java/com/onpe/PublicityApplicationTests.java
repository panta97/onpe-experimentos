package com.onpe;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onpe.entity.Candidato;
import com.onpe.entity.Distrito;
import com.onpe.entity.PartidoPolitico;
import com.onpe.entity.Usuario;
import com.onpe.repository.PartidoPoliticoRepository;
import com.onpe.service.ICandidatoService;
import com.onpe.service.IDistritoService;
import com.onpe.service.IPartidoPoliticoService;
import com.onpe.service.IUsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicityApplicationTests {
	
	@Autowired
	private IDistritoService distritoService;
	
	@Autowired
	private IPartidoPoliticoService partidoPoliticoService;
	
	@Autowired
	private ICandidatoService candidatoService;
	
	@Autowired
	private IUsuarioService usuarioService;

	@Test
	public void contextLoads() {
		
//		entityDistrito("CREATE");
//		entityPartidoPolitico("CREATE");
		entityCandidato("CREATE");
//		entityUsuario("RETRIEVE");
	
	}
	
	
	private void entityDistrito(String crudOperation) {
		switch (crudOperation) {
		case "CREATE":
			
			Distrito distrito = new Distrito();
			distrito.setNombre("LA");
			distrito.setEstado("ACT");
			
			distritoService.save(distrito);
			
			break;
		case "UPDATE":
			
			break;
		case "RETRIEVE":
	
			break;
		case "DELETE":
	
			break;
		default:
			break;
		}
	}
	
	
	private void entityPartidoPolitico(String crudOperation) {
		switch (crudOperation) {
		case "CREATE":
			
			PartidoPolitico partidoPolitico = new PartidoPolitico();
			partidoPolitico.setNombre("KKK");
			partidoPolitico.setEstado("ACT");
		
			partidoPoliticoService.save(partidoPolitico);
			
			break;
		case "UPDATE":
			
			break;
		case "RETRIEVE":
	
			break;
		case "DELETE":
	
			break;
		default:
			break;
		}
	}

	
	
	private void entityCandidato(String crudOperation) {
		switch (crudOperation) {
		case "CREATE":
			
			Candidato candidato = new Candidato();
			candidato.setNombre("will");
			candidato.setApellido("smith");
			candidato.setEstado("ACT");
			
			Distrito distrito = distritoService.findById(1);
			candidato.setDistrito(distrito);
			
			PartidoPolitico partidoPolitico = partidoPoliticoService.findById(1);
			candidato.setPartidoPolitico(partidoPolitico);
			
		
			candidatoService.save(candidato);
			
			break;
		case "UPDATE":
			
			break;
		case "RETRIEVE":
	
			break;
		case "DELETE":
	
			break;
		default:
			break;
		}
	}
	
	private void entityUsuario(String crudUsuario) {
		switch (crudUsuario) {
		
		case "CREATE":
			
			Usuario usuario = 
			new Usuario("judovico", "smith", "u20141a099", "123456", "ROL01", "ACT");
			
			usuarioService.save(usuario);
			
			break;
		case "UPDATE":
			
			usuarioService.update(2, "Diego", "Cueva Fuster");
			
			break;
		case "RETRIEVE":
			
			List<Usuario> usuarios = usuarioService.findAll();
			
			for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
				Usuario usuarioList = (Usuario) iterator.next();
				
				System.out.println(usuarioList.getNombre());
				
			}
			
			
//			Usuario u1 = usuarioService.findById(1);
//			System.out.println(u1.getNombre());

	
			break;
		case "DELETE":
	
			break;
		default:
			break;
		}
	}

}
