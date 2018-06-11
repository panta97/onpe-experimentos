package com.onpe.testng;

import org.testng.annotations.Test;

import com.onpe.OnpeApplication;
import com.onpe.entity.Distrito;
import com.onpe.entity.PartidoPolitico;
import com.onpe.service.PartidoPoliticoService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@SpringBootTest(classes = OnpeApplication.class)
public class PartidoPoliticoTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private PartidoPoliticoService partidoPoliticoService;
	public PartidoPolitico partidoPolitico = new PartidoPolitico(); 
	

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Antes de cada P.U.");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Despues de cada P.U.");
  }

  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Al inicio de la clase");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Al final de la clase");
  }
  
  @DataProvider(name = "datosDePartidoPolitico")
  public Object[][] dataPartidoPolitico() {
    return new Object[][] {
    	{"PPK", "ACT"}
    };
  }
  
  //Insert method
  @Test(dataProvider = "datosDePartidoPolitico")
  public void addPartidoPolitico(String nombre, String estado) {  
	  try {
		  
		  System.out.println("Met. Ingresar");
		  //Datos de entrada
		  partidoPolitico = new PartidoPolitico();
		  partidoPolitico.setNombre(nombre);
		  partidoPolitico.setEstado(estado);
		  //Ejecutar prueba
		  partidoPoliticoService.save(partidoPolitico);
		  //Validar prueba
		  Assert.assertTrue(partidoPoliticoService.exists(partidoPolitico.getId()));
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail("Mensaje: " + e.getMessage());
	}
  }
  
//Read method
  @Test (dependsOnMethods = {"addPartidoPolitico"})
  public void readPartidoPolitico() {
	  try {
		  System.out.println("Met. leer");
		  
		  PartidoPolitico partidoPoliticoRetrieve = new PartidoPolitico();
		  partidoPoliticoRetrieve = partidoPoliticoService.findById(partidoPolitico.getId());
		  
		  Assert.assertEquals(partidoPoliticoRetrieve.getId(), partidoPolitico.getId());
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail();
	}
  }
  
  
  //Update method
  @Test (dependsOnMethods = {"addPartidoPolitico"})
  public void updatePartidoPolitico() {
	  try {
		  System.out.println("Met. Editar");
		  String newName= "LIMA";
		  partidoPoliticoService.udpate(partidoPolitico.getId(), newName);
		  Assert.assertEquals(partidoPoliticoService.findById(partidoPolitico.getId()).getNombre(), newName);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail();
	}
  }
  
  
  //Delete method
  @Test (dependsOnMethods = {"updatePartidoPolitico"})
  public void deletePartidoPolitico() {
	  try {
		  System.out.println("Met. Eliminar");
		  partidoPoliticoService.delete(partidoPolitico.getId());
		  Assert.assertTrue(true);
		  		
	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail();
	}
  }

}
