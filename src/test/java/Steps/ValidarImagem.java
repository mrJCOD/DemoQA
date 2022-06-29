package Steps;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Metodos.driverFactory;

public class ValidarImagem extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(6);
	}

	@After
	public void tearDown() throws Exception {
		
		//encerrarTeste();
	}

	@Test
	public void ValidarImagem1() throws IOException {
		
		validarImagemVisivel(By.xpath("((//div)[60]/img)[1]"));

	}
	
	@Test
	public void ValidarImagem2() throws IOException {
		
		validarImagemVisivel(By.xpath("((//div)[60]/img)[2]"));

	}
	
	@Test
	public void ValidarLink1() throws IOException, InterruptedException {
	
		metodoNet();

	}
	
	@Test
	public void ValidarLink2() throws IOException, InterruptedException {


	}

}
