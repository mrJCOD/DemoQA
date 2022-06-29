package Metodos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class driverFactory extends Metodos {

	public void ValidarLinks(int size) {

		ArrayList<String> urlEsperada = new ArrayList<String>();
		urlEsperada.add("index0");
		urlEsperada.add("https://demoqa.com/elements");
		urlEsperada.add("https://demoqa.com/forms");
		urlEsperada.add("https://demoqa.com/alertsWindows");
		urlEsperada.add("https://demoqa.com/widgets");
		urlEsperada.add("https://demoqa.com/interaction");
		urlEsperada.add("https://demoqa.com/books");

		for (int i = 1; i < size; i++) {
			WebElement menu = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[" + i + "]"));

			if (menu.isDisplayed()) {
				scroll(0, 300);
				menu.click();
				ArrayList<String> urlRecebida = new ArrayList<String>();

				urlRecebida.add(driver.getCurrentUrl());
				String urlAtual = driver.getCurrentUrl();
				assertEquals(urlEsperada.get(i), urlAtual);
				System.out.println(urlRecebida.toString());
				driver.navigate().back();
			}
		}
	}

	public void validarTextoMenu(int size) {

		ArrayList<String> textoEsperado = new ArrayList<String>();
		textoEsperado.add("index0");
		textoEsperado.add("Elements");
		textoEsperado.add("Forms");
		textoEsperado.add("Alerts, Frame & Windows");
		textoEsperado.add("Widgets");
		textoEsperado.add("Interactions");
		textoEsperado.add("Book Store Application");

		for (int i = 1; i < size; i++) {
			WebElement texto = driver.findElement(By.xpath("(//h5)[" + i + "]"));
			if (texto.isDisplayed()) {

				String textoAtual = texto.getText();
				assertEquals(textoEsperado.get(i), textoAtual);

			}

		}
	}

	public void validarImagensMenu(int size) {

		for (int i = 1; i < size; i++) {
			WebElement elemento = driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[" + i + "]"));
			assertTrue(elemento.isDisplayed());
			System.out.println(elemento.isDisplayed());

		}
	}

	public void preencherFormulario(String nome, String email, String end1, String end2) {

		type(By.id("userName"), nome);
		type(By.id("userEmail"), email);
		type(By.id("currentAddress"), end1);
		type(By.id("permanentAddress"), end2);
		clicar(By.id("submit"));
	}

	public void acessarMenuElement(int num) {

		clicar(By.id("item-" + num));
	}

	public void validarFormulario(int size, String nome, String email, String end1, String end2) {

		ArrayList<String> resultadoEsperado = new ArrayList<String>();
		resultadoEsperado.add("index0");
		resultadoEsperado.add(nome);
		resultadoEsperado.add(email);
		resultadoEsperado.add(end1);
		resultadoEsperado.add(end2);

		for (int i = 1; i < size; i++) {
			WebElement element = driver
					.findElement(By.xpath("(//div[@class='border col-md-12 col-sm-12']/p)[" + i + "]"));
			if (element.isDisplayed()) {

				String resultadoAtual = element.getText();
				assertEquals(resultadoEsperado.get(i), resultadoAtual);

			}

		}

	}

	public void expandirCheckBox(int size) {

		for (int i = 1; i < size; i++) {
			WebElement element = driver.findElement(By.xpath("(//button[@title='Toggle'])[" + i + "]"));
			if (element.isDisplayed()) {

				element.click();

			}

		}

	}

	public void validarCheckBox(int size) {

		for (int i = 1; i < size; i++) {

			WebElement element = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[" + i + "]"));

			if (element.isDisplayed()) {

				assertTrue(element.isSelected());

			}

		}
	}

	public void SelecionarRadioButton(By elemento) {

		WebElement element = driver.findElement(elemento);
		element.click();

	}

	public void ValidarRadioButton(By elemento) {

		WebElement checkboxElemento = driver.findElement(elemento);
		assertTrue(checkboxElemento.isSelected());
	}

	public void ValidarResponseRadioButton(String textoEsperado, By elemento) {

		WebElement element = driver.findElement(elemento);
		assertEquals(textoEsperado, element.getText());

	}

	public void AdicionarFuncionario(String nome, String ultimoNome, String email, String idade, String salario,
			String departamento) throws InterruptedException {

		driver.findElement(By.id("addNewRecordButton")).click();
		Thread.sleep(500);

		if (driver.findElement(By.xpath("//div[@class='modal-content']")).isDisplayed()) {

			type(By.id("firstName"), nome);
			type(By.id("lastName"), ultimoNome);
			type(By.id("userEmail"), email);
			type(By.id("age"), idade);
			type(By.id("salary"), salario);
			type(By.id("department"), departamento);
			clicar(By.id("submit"));

		} else {

			System.out.println("Elemento nao encontrado!");
		}

	}

	public void validarHiperLinks(String textoEsperado, int numero) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("(//div/p/a)[" + numero + "]"));

		if (element.isDisplayed()) {
			element.click();
			Thread.sleep(500);
			String text = driver.findElement(By.id("linkResponse")).getText();
			assertEquals(textoEsperado, text);

		}

	}
	
	public void validarHiperLinksAba(int numero) throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("(//div/p/a)[" + numero + "]"));

		if (element.isDisplayed()) {
			element.click();
			Thread.sleep(500);
			alternarAba(1);
			assertEquals("https://demoqa.com/", driver.getCurrentUrl());
			fecharAba();
			alternarAba(0);
			

		}
		
		
	}
	
public void metodoNet() throws IOException {
		
		

		List<WebElement> links = driver.findElements(By.xpath("(//div)[60]/a"));
		
		
		

		for (int i = 1; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");
			System.out.println("Total de links é: " + links.size());
			URL url1 = new URL(url);
			HttpURLConnection httpurlconnect = (HttpURLConnection) url1.openConnection();
			httpurlconnect.setConnectTimeout(5000);
			httpurlconnect.connect();

			if (httpurlconnect.getResponseCode() == 301) {
				System.out.println(url + " = " + httpurlconnect.getResponseMessage() + "OK");

			}
			if (httpurlconnect.getResponseCode() == 500) {

				System.out.println(
						url + " - " + httpurlconnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
				System.out.println(url + " = " + httpurlconnect.getResponseMessage() + " - BROKEN");

			}else System.out.println("Nenhum dos status encontrado");

		}
	}
}
