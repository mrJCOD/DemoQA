package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Metodos.driverFactory;

public class CheckBox extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(1);
	}

	@After
	public void tearDown() throws Exception {
		
		//encerrarTeste();
	}

	@Test
	public void validandoCheckBox() {
		
		expandirCheckBox(7);
		clicar(By.xpath("//span[@class='rct-checkbox']"));
		validarCheckBox(18);
		

	}

}
