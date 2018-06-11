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

import com.onpe.entity.Distrito;
import com.onpe.service.IDistritoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DistritoTest {
	
	@Autowired
	private IDistritoService distritoService;
	private static Distrito distrito;
	
	
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
			distrito.setNombre("SAN MIGUEL");
			distrito.setEstado("DCT");
						
			//Ejecutar Prueba
			distritoService.save(distrito);
			
			//Validar la prueba
			Assert.assertTrue(distritoService.exists(distrito.getId()));
			
			
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

			
			//Datos de Entrada
			//Ejecutar Prueba
			
			Distrito distritoToRetrieve = new Distrito();
			distritoToRetrieve = distritoService.findById(distrito.getId());
			
			
			//Ejecutar Prueba
//			Assert.assertSame(distrito, distritoToRetrieve);
			Assert.assertEquals(distritoToRetrieve.getId(), distrito.getId());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
	
//	Assert.assertTrue(EqualsBuilder.reflectionEquals(expected,actual));

	@Test
	public void c_editar() {
		try {
			
			System.out.println("Met. Editar");

			//Datos de Entrada
			//Ejecutar Prueba
			
			String newNombre = "CUZCO";
			
			distritoService.update(distrito.getId(), newNombre);
			
			Assert.assertEquals(distritoService.findById(distrito.getId()).getNombre(), newNombre);
			
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
			
			//Datos de Entrada
			//Ejecutar Prueba
			distritoService.delete(distrito.getId());
			
			//Validar prueba
			Assert.assertTrue(true);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}

}
