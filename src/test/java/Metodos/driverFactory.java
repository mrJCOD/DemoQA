package Metodos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
		
		for(int i = 1; i<size; i++) {
			WebElement element = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[" + i + "]"));
			if (element.isDisplayed()) {

				assertTrue(element.isSelected());
				
			}
			
		}
	}

}
