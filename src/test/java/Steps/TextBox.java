package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Metodos.driverFactory;

public class TextBox extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(0);
	}

	@After
	public void tearDown() throws Exception {
		
		encerrarTeste();
	}

	@Test
	public void ValidandoTextBox() {
		
		preencherFormulario("Josivaldo Silva", "teste@gmail.com", "Rua silva 1", "Rua silva 1");
		validarFormulario(5, "Name:Josivaldo Silva", "Email:teste@gmail.com", "Current Address :Rua silva 1", "Permanent Address :Rua silva 1");
		
	}

}
