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

import com.onpe.entity.Candidato;
import com.onpe.entity.Distrito;
import com.onpe.entity.PartidoPolitico;
import com.onpe.service.ICandidatoService;
import com.onpe.service.IDistritoService;
import com.onpe.service.IPartidoPoliticoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CandidatoTest {
	
	@Autowired
	private ICandidatoService candidatoService;
	@Autowired
	private IDistritoService distritoService;
	@Autowired
	private IPartidoPoliticoService partidoPoliticoService;
	private static Candidato candidato;
	private static Distrito distrito;
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
	public void a_insertar() {
		try {
			System.out.println("Met. Insertar");
			
			//Datos de Entrada
			
			distrito = new Distrito();
			distrito.setNombre("LIMA");
			distrito.setEstado("ACT");
			distritoService.save(distrito);

			partidoPolitico = new PartidoPolitico();
			partidoPolitico.setNombre("APRA");
			partidoPolitico.setEstado("ACT");
			partidoPoliticoService.save(partidoPolitico);
			
			candidato = new Candidato();
			candidato.setApellido("Terry");
			candidato.setNombre("Alan");
			candidato.setDistrito(distrito);
			candidato.setPartidoPolitico(partidoPolitico);
			candidato.setEstado("ACT");
						
			//Ejecutar Prueba
			
			candidatoService.save(candidato);
			
			//Validar la prueba
			Assert.assertTrue(candidatoService.exists(candidato.getId()));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	@Test
	public void b_leer() {
		try {
			
			System.out.println("Met. Leer");

			
			//Datos de Entrada
			//Ejecutar Prueba
			
			Candidato candidatoToRetrieve = new Candidato();
			candidatoToRetrieve = candidatoService.findById(candidato.getId());
			
			//Ejecutar Prueba
			Assert.assertEquals(candidatoToRetrieve.getId(), candidato.getId());	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	Assert.assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

//	@Test
	public void c_editar() {
		try {
			
			System.out.println("Met. Editar");

			//Datos de Entrada
			//Ejecutar Prueba
			
			String newNombre = "PEDRO";
			String newApellido = "KUCZYNSKI";
			
			candidatoService.update(candidato.getId(), newNombre, newApellido);
			
			
			String errorStr = "";
			if(!newNombre.equals(candidatoService.findById(candidato.getId()).getNombre())) {
				errorStr += "expected: " + newNombre + ", actual: " + candidatoService.findById(candidato.getId()).getNombre() + "\n";
			}
			if(!newApellido.equals(candidatoService.findById(candidato.getId()).getApellido())) {
				errorStr += "expected: " + newApellido + ", actual: " + candidatoService.findById(candidato.getId()).getApellido() + "\n";
			}
			
			Assert.assertEquals("", errorStr);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
//	@Test
	public void d_eliminar() {
		try {
			System.out.println("Met. Eliminar");
			
			//Datos de Entrada
			//Ejecutar Prueba
			candidatoService.delete(candidato.getId());
			
			//Validar prueba
			Assert.assertTrue(true);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
