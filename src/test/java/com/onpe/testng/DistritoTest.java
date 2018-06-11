package com.onpe.testng;

import org.testng.annotations.Test;

import com.onpe.OnpeApplication;
import com.onpe.bean.DistritoBean;
import com.onpe.entity.Distrito;
import com.onpe.service.DistritoService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;

@SpringBootTest(classes = OnpeApplication.class)
public class DistritoTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private DistritoService distritoService;
	public Distrito distrito = new Distrito();
	List<Integer> ids = new ArrayList<>();
	
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
  
  //DATA
  @DataProvider(name= "datosDeDistrito")
  public Object[][] datosLlenarDistritos(){
	  return new Object[][] {
		  {"MAGDALENA", "ACT"}
		  
	  };
  }
   
  //Insert method
  @Test(dataProvider = "datosDeDistrito")
  public void addDistrito(String nombre, String estado) {
  try {
		System.out.println("Met. Insertar");
		
		//Datos de Entrada
		distrito = new Distrito();
		distrito.setNombre(nombre);
		distrito.setEstado(estado);
					
		//Ejecutar Prueba
		distritoService.save(distrito);
		
		//Validar la prueba
		Assert.assertTrue(distritoService.exists(distrito.getId()));
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail("Mensaje: " + e.getMessage());
	}
  }
  
  //Read method
  @Test (dependsOnMethods = {"addDistrito"})
  public void readDistrito() {
	  try {
		  System.out.println("Met. leer");
		  
		  Distrito distritoRetrieve = new Distrito();
		  distritoRetrieve = distritoService.findById(distrito.getId());
		  
		  Assert.assertEquals(distritoRetrieve.getId(), distrito.getId());
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail();
	}
  }
  
  
  //Update method
  @Test (dependsOnMethods = {"addDistrito"})
  public void updateDistrito() {
	  try {
		  System.out.println("Met. Editar");
		  String newName= "LIMA";
		  distritoService.update(distrito.getId(), newName);
		  Assert.assertEquals(distritoService.findById(distrito.getId()).getNombre(), newName);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		Assert.fail();
	}
  }
  
  
  //Delete method
  @Test (dependsOnMethods = {"updateDistrito"})
  public void deleteDistrito() {
	  try {
		  System.out.println("Met. Eliminar");
		  distritoService.delete(distrito.getId());
		  Assert.assertTrue(true);
		  		
	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail();
	}
  }
  
  

}
