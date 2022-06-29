package Metodos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Metodos {

	public WebDriver driver;

	public void iniciarTeste(String browser, String url) {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.out.println("Iniciando Google Chrome...");
			System.setProperty("webdriver.chrome.driver", "C://driver-navegadores/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			System.out.println("Iniciando Firefox...");
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);

		} else if (browser.equalsIgnoreCase("edge")) {

			System.out.println("Iniciando Microsoft Edge...");
			System.setProperty("webdriver.edge.driver", "./driver/edgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			driver.get(url);

		} else {

			System.out.println("Nenhum navegador Web configurado com este nome.");
		}

	}

	public void scroll(int num1, int num2) {

		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(" + num1 + "," + num2 + ")");
	}

	public void clicar(By elemento) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
		element.click();
	}

	public void type(By elemento, String texto) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
		element.sendKeys(texto);

	}

	public void encerrarTeste() {

		driver.quit();
	}

	public void duploClique(By elemento) {

		Actions acao = new Actions(driver);
		WebElement element = driver.findElement(elemento);
		acao.doubleClick(element).release().perform();

	}

	public void rightClique(By elemento) {

		Actions acao = new Actions(driver);
		WebElement element = driver.findElement(elemento);
		acao.contextClick(element).release().perform();
	}

	public void alternarAba(int aba) {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(aba));
	}

	public void fecharAba() {

		driver.close();
	}

	public void validarImagemVisivel(By elemento) throws IOException {

		WebElement img = driver.findElement(elemento);

		boolean result = img.getAttribute("naturalWidth").equals("0");

		if (result == false) {

			System.out.println("Imagem nao esta quebrada.");
		} else
			System.out.println("Imagem esta quebrada");
		assertTrue(result);

	}

	public void validarLinkVisivel() throws IOException, InterruptedException {

		URL url = new URL("http://demoqa.com");
		// URL url = new URL(texto);
		HttpsURLConnection urlconnection = (HttpsURLConnection) url.openConnection();
		urlconnection.setConnectTimeout(3000);
		urlconnection.connect();

		if (urlconnection.getResponseCode() == 200) {
			System.out.println(url + " - " + urlconnection.getResponseMessage());

		}
		if (urlconnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

			System.out.println(
					url + " - " + urlconnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);

		}

	}

	

	public void veiricarLinkAtivo(String linkUrl) {

		try {

			URL url = new URL(linkUrl);
			HttpURLConnection httpurlconnect = (HttpURLConnection) url.openConnection();
			httpurlconnect.setConnectTimeout(3000);
			httpurlconnect.connect();

			if (httpurlconnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " = " + httpurlconnect.getResponseMessage());

			}
			if (httpurlconnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				System.out.println(
						linkUrl + " - " + httpurlconnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);

			}

		} catch (Exception e) {
			System.out.println("Deu ruim");
		}
	}
	
	public void uploadArquivo(By elemento, String caminho) {
		
		driver.findElement(elemento).sendKeys(caminho);
	}

}
