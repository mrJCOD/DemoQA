package Steps;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Metodos.driverFactory;

public class Button extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(4);
	}

	@After
	public void tearDown() throws Exception {
		
		//encerrarTeste();
	}

	@Test
	public void ValidandoButtonDuploClique() {
		
		duploClique(By.id("doubleClickBtn"));
		String texto = driver.findElement(By.id("doubleClickMessage")).getText();
		assertEquals("You have done a double click", texto);

	}
	
	@Test
	public void ValidandoButtonCliqueDireito() {
		
		rightClique(By.id("rightClickBtn"));
		String texto = driver.findElement(By.id("rightClickMessage")).getText();
		assertEquals("You have done a right click", texto);

	}
	
	

}
