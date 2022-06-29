package Steps;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Metodos.driverFactory;

public class ValidarTabela extends driverFactory {

	@Before
	public void setUp() throws Exception {

		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(3);
	}

	@After
	public void tearDown() throws Exception {

		// encerrarTeste();
	}

	@Test
	public void ValidarAdicaoFuncionario() throws InterruptedException {
		
		AdicionarFuncionario("Josivaldo", "Silva", "teste@gmail.com", "26", "1000", "Analista");
		List<WebElement> funcionario = driver.findElements(By.xpath("(//div[@class='rt-tr -even'])[2]"));
		assertFalse(funcionario.isEmpty());

		

	}

}
