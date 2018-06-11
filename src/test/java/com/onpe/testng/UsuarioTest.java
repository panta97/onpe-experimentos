package com.onpe.testng;

import org.testng.annotations.Test;

import com.onpe.OnpeApplication;
import com.onpe.entity.Usuario;
import com.onpe.service.UsuarioService;

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
public class UsuarioTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private UsuarioService usuarioService;
	public Usuario usuario = new Usuario();
  
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
  

  @DataProvider(name = "datosDeUsuario")
  public Object[][] dataUsuario() {
    return new Object[][] {
    	{"Kevin", "Tito", "CS02", "123", "ACT", "ADMIN"}
    };
  }
  
  //Insert method
  @Test(dataProvider = "datosDeUsuario")
  public void addUsuario(String nombre, String apellido, String codigo, String pass, String estado, String rol) {
	  try {
			System.out.println("Met. Insertar");
			
			//Datos de Entrada
			usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setCodigo(codigo);
			usuario.setPassword(pass);
			usuario.setEstado(estado);
			usuario.setRol(rol);
						
			//Ejecutar Prueba
			usuarioService.save(usuario);
			
			//Validar la prueba
			Assert.assertTrue(usuarioService.exists(usuario.getId()));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail("Mensaje: " + e.getMessage());
		}
  }
  //Read method
  @Test (dependsOnMethods = {"addUsuario"})
	public void readUsuario() {
		try {
			
			System.out.println("Met. Leer");
			//Datos de Entrada
			Usuario usuarioToRetrieve = new Usuario();
			//Ejecutar Prueba
			usuarioToRetrieve = usuarioService.findById(usuario.getId());
			//Validar la prueba
			Assert.assertEquals(usuarioToRetrieve.getId(), usuario.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
  
  //Update method
  @Test (dependsOnMethods = {"addUsuario"})
	public void updateUsuario() {
		try {
			
			System.out.println("Met. Editar");

			//Datos de Entrada
			String newNombre = "Json";
			String newApellido = "Suarez";
			//Ejecutar Prueba
			usuarioService.update(usuario.getId(), newNombre, newApellido);
			
			
			String errorStr = "";
			
			if(!newNombre.equals(usuarioService.findById(usuario.getId()).getNombre())) {
				errorStr += "expected: " + newNombre + ", actual: " + usuarioService.findById(usuario.getId()).getNombre() + "\n";
			}
			
			if(!newNombre.equals(usuarioService.findById(usuario.getId()).getNombre())) {
				errorStr += "expected: " + newNombre + ", actual: " + usuarioService.findById(usuario.getId()).getNombre() + "\n";
			}
			//Validar la prueba
			Assert.assertEquals("", errorStr);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}
  
//Delete method
  @Test (dependsOnMethods = {"updateUsuario"})
	public void deleteUsuario() {
		try {
			
			System.out.println("Met. Eliminar");
			//Ejecutar Prueba
			usuarioService.delete(usuario.getId());
			//Validar la prueba
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail();
		}
	}

}
