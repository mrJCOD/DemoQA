package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Metodos.driverFactory;

public class Upload extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(7);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		uploadArquivo(By.id("uploadFile"), "C://SQL/sampleFile.jpeg");

		
	}

}
