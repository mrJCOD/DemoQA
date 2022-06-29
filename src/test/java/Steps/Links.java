package Steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Metodos.driverFactory;

public class Links extends driverFactory{

	@Before
	public void setUp() throws Exception {
		
		iniciarTeste("chrome", "https://demoqa.com/elements");
		acessarMenuElement(5);
	}

	@After
	public void tearDown() throws Exception {
		
		//encerrarTeste();
	}

	@Test
	public void validarHiperLinks() throws InterruptedException {

			validarHiperLinks("Link has responded with staus 201 and status text Created", 3);
			validarHiperLinks("Link has responded with staus 204 and status text No Content", 4);
			validarHiperLinks("Link has responded with staus 301 and status text Moved Permanently", 5);
			validarHiperLinks("Link has responded with staus 400 and status text Bad Request", 6);
			validarHiperLinks("Link has responded with staus 401 and status text Unauthorized", 7);
			validarHiperLinks("Link has responded with staus 403 and status text Forbidden", 8);
			validarHiperLinks("Link has responded with staus 404 and status text Not Found", 9);
			
	}
	
	@Test
	public void validarNovaAba() throws InterruptedException {
		
		validarHiperLinksAba(1);
		validarHiperLinksAba(2);
	}

}
