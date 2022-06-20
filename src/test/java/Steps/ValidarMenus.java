package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Metodos.driverFactory;

public class ValidarMenus extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validarLinksMenu() {
		
		ValidarLinks(7);
		

	}
	
	@Test
	public void validarTextosMenu() {
		
		validarTextoMenu(7);
	}
	
	@Test
	public void validarImagemMenu() {
		
		validarImagensMenu(7);
	}

}
