package com.onpe.selenium;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onpe.seleniumwd.fuenteDatos.Excel;
import com.onpe.seleniumwd.page.CandidatoPage;
import com.onpe.seleniumwd.page.IniciarSesionPage;
import com.onpe.seleniumwd.util.Utilitario;

public class CandidatoWebDriverTest {

	private String urlInicial = "http://localhost:8080/OnpeWeb";
	private CandidatoPage candidatoPage;
	private IniciarSesionPage iniciarSesionPage;
	private String rutaCarpetaError = "C:\\CapturasPantallas\\Onpe\\Candidato";

	@BeforeTest
	@Parameters({ "navegador", "remoto" })
	public void inicioClase(String navegador, int remoto) throws Exception {
		this.iniciarSesionPage = new IniciarSesionPage(navegador, this.urlInicial, remoto == 1);
		this.candidatoPage = new CandidatoPage(this.iniciarSesionPage.getWebDriver());
	}

	@DataProvider(name = "datosInsertarEntrada")
	public static Object[][] datosInsertarPoblados(ITestContext context) {
		Object[][] datos = null;
		
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaInsertarArchivo");
		datos = Excel.leerExcel(rutaArchivo);
		return datos;
	}
	@DataProvider(name = "datosEditarEntrada")
	public static Object[][] datosEditarPoblados(ITestContext context) {
		Object[][] datos = null;
		
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaEditarArchivo");
		datos = Excel.leerExcel(rutaArchivo);
		return datos;
	}
	@DataProvider(name = "datosEliminarEntrada")
	public static Object[][] datosEliminarPoblados(ITestContext context) {
		Object[][] datos = null;
		
		String rutaArchivo = context.getCurrentXmlTest().getParameter("rutaEliminarrArchivo");
		datos = Excel.leerExcel(rutaArchivo);
		return datos;
	}
	@Test(dataProvider = "datosInsertarEntrada")
	public void insertarDistrito(String usuario, String clave, String nombre, String apellido, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = candidatoPage.insertarCandidato(nombre.trim(), apellido.trim());
			Assert.assertEquals(valorEsperado, valorEsperado);
		}catch(AssertionError e){
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), candidatoPage.getWebDriver());
			Assert.fail(e.getMessage());}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(dataProvider = "datosEditarEntrada", dependsOnMethods= {"insertarDistrito"})
	public void editarDistrito(String usuario, String clave, String nuevoNombre, String nuevoApellido, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = candidatoPage.editarCandidato(nuevoNombre.trim(), nuevoApellido.trim());
			Assert.assertEquals(valorEsperado, valorEsperado);
		} catch(AssertionError e){
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), candidatoPage.getWebDriver());
			Assert.fail(e.getMessage());}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@Test(dataProvider = "datosEliminarEntrada", dependsOnMethods= {"editarDistrito"})
	public void eliminarDistrito(String usuario, String clave, String valorEsperado) throws Exception {
		try {
			iniciarSesionPage.iniciarSesion(usuario, clave);
			String valorObtenido = candidatoPage.eliminarCandidato();
			Assert.assertEquals(valorEsperado, valorEsperado);
		} catch(AssertionError e){
			Utilitario.caputarPantallarError(rutaCarpetaError, e.getMessage(), candidatoPage.getWebDriver());
			Assert.fail(e.getMessage());}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	@AfterTest
	public void tearDown() throws Exception {
		candidatoPage.cerrarPagina();
	}

}
