package com.onpe.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.onpe.OnpeApplication;


@WebAppConfiguration
@ContextConfiguration("file:src/test/java/testng.xml")
public class DistritoWebDriverTest extends AbstractTestNGSpringContextTests {
	
	private WebDriver driver;
	private String urlInicial = "http://localhost:8080/";
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\ProgramasInstalados\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	private void insertarDistrito_FlujoBasico() throws Exception {
		try {
			String mensajeEsperado = "Success";
			String mensajeObtenido;
			
			
			driver.get(urlInicial);
			
			driver.findElement(By.id("user")).clear();
			driver.findElement(By.id("user")).sendKeys("user");
			
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("password");
			
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("aDistrito")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("hNuevoDistrito")).click();
			Thread.sleep(2000);
			
			

			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}

}
