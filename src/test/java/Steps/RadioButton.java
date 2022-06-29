package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Metodos.driverFactory;

public class RadioButton extends driverFactory {

	@Before
	public void setUp() throws Exception {

		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(2);
	}

	@After
	public void tearDown() throws Exception {

		encerrarTeste();
	}

	@Test
	public void ValidarRadioButton_Yes() {

		SelecionarRadioButton(By.xpath("//label[@for='yesRadio']"));
		ValidarRadioButton(By.id("yesRadio"));
		ValidarResponseRadioButton("Yes", By.xpath("(//span[@class='text-success'])"));
		

	}
	
	@Test
	public void ValidarRadioButton_Impressive() {

		SelecionarRadioButton(By.xpath("(//label[@for='impressiveRadio'])"));
		ValidarRadioButton(By.id("impressiveRadio"));
		ValidarResponseRadioButton("Impressive", By.xpath("(//span[@class='text-success'])"));

	}
	
	@Test
	public void ValidarRadioButton_No() {
		
		SelecionarRadioButton(By.xpath("(//label[@for='noRadio'])"));
		ValidarRadioButton(By.id("noRadio"));
		ValidarResponseRadioButton("No", By.xpath("(//span[@class='text-success'])"));
		
		
	}

}
