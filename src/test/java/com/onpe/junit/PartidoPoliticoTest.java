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

import com.onpe.entity.PartidoPolitico;
import com.onpe.service.IPartidoPoliticoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartidoPoliticoTest {
	
	@Autowired
	private IPartidoPoliticoService partidoPoliticoService;
	private static PartidoPolitico partidoPolitico;
	
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

			
			partidoPolitico = new PartidoPolitico();
			partidoPolitico.setNombre("APRA");
			partidoPolitico.setEstado("ACT");
			
			partidoPoliticoService.save(partidoPolitico);
			
			Assert.assertTrue(partidoPoliticoService.exists(partidoPolitico.getId()));
			
			
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

			PartidoPolitico partidoPoliticoToRetrive = new PartidoPolitico();
			partidoPoliticoToRetrive = partidoPoliticoService.findById(partidoPolitico.getId());
			
			
			Assert.assertEquals(partidoPoliticoToRetrive.getId(), partidoPolitico.getId());
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

			
			String newNombre = "PPC";
			
			partidoPoliticoService.udpate(partidoPolitico.getId(), newNombre);
			
			Assert.assertEquals(partidoPoliticoService.findById(partidoPolitico.getId()).getNombre(), newNombre);			
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

			partidoPoliticoService.delete(partidoPolitico.getId());
			
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
}
