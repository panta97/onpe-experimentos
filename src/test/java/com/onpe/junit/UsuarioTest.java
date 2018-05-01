package com.onpe.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onpe.entity.Usuario;
import com.onpe.service.IUsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {

	@Autowired
	private IUsuarioService usuarioService;
	private static Usuario usuario;
	
	@BeforeClass
	public static void inicioClase() {
		System.out.println("Inicio de la Clase");
	}
	
	@AfterClass
	public static void finClase() {
		System.out.println("Fin de la Clase");
	}
	
	@Before
	public void inicioTest() {
		System.out.println("Antes del Test");
	}
	
	@After
	public void finTest() {
		System.out.println("Despues del Test");
	}
	
	@Test
	public void a_ingresar() {
		try {
			
			System.out.println("Met. Ingresar");
			
			usuario = new Usuario();
			usuario.setNombre("John");
			usuario.setApellido("Vilchez");
			usuario.setCodigo("CS01");
			usuario.setPassword("asAS12!@");
			usuario.setEstado("ACT");
			usuario.setRol("ADMIN");
			
			usuarioService.save(usuario);
			
			Assert.assertTrue(usuarioService.exists(usuario.getId()));			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void b_leer() {
		try {
			
			System.out.println("Met. Leer");

			Usuario usuarioToRetrieve = new Usuario();
			usuarioToRetrieve = usuarioService.findById(usuario.getId());
			
			Assert.assertEquals(usuarioToRetrieve.getId(), usuario.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void c_editar() {
		try {
			
			System.out.println("Met. Editar");

			
			String newNombre = "Json";
			String newApellido = "Suarez";
			
			usuarioService.update(usuario.getId(), newNombre, newApellido);
			
			
			String errorStr = "";
			
			if(!newNombre.equals(usuarioService.findById(usuario.getId()).getNombre())) {
				errorStr += "expected: " + newNombre + ", actual: " + usuarioService.findById(usuario.getId()).getNombre() + "\n";
			}
			
			if(!newNombre.equals(usuarioService.findById(usuario.getId()).getNombre())) {
				errorStr += "expected: " + newNombre + ", actual: " + usuarioService.findById(usuario.getId()).getNombre() + "\n";
			}
			
			Assert.assertEquals("", errorStr);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void d_eliminar() {
		try {
			
			System.out.println("Met. Eliminar");
			
			usuarioService.delete(usuario.getId());
			
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
}
