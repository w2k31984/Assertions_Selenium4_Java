package assertionsExample;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.qameta.allure.Description;

public class TestNGAssertionsExample {

	private WebDriver driver;


	@BeforeTest
	public void setup() {
		// Set up WebDriver
		System.setProperty("webdriver.geckodriver.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");

		driver = new FirefoxDriver();
		

	}
	
	@Test(description = "Validar la creacion de usuario en el Ecommerce")
	@Description("Test para validar la creacion de cuenta nueva de usuario en el Ecommerce")
	
	  public void testLCOCrearCuenta() {
		//Abriendo la URL de login
		String urlBase = "https://mcstaging.lacuracaonline.com/elsalvador/customer/account/login/";
		driver.get(urlBase);
		driver.manage().window().maximize();
		
		
		//Dando click al boton para crear una nueva cuenta
		WebElement buttonCrearNuevaCuenta = driver.findElement(By.xpath("//a[@class='action create primary']"));
		buttonCrearNuevaCuenta.click();
		
		//Creando parametros tipo cadena de caracteres 
		String nombre = "Porfirio";
		String apellido = "Mendoza";
		String correoElectronico = "pmendoza89@gmail.com";
		String contrasena = "Unicomer2023";
		String confirmarContrasena = "Unicomer2028";
		
		//Pasando parametros en los campos
		
		WebElement campoNombre = driver.findElement(By.xpath("//input[@id='firstname']"));
		campoNombre.sendKeys(nombre);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement campoApellido = driver.findElement(By.xpath("//input[@id='lastname']"));
		campoApellido.sendKeys(apellido);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Check a Registrate para recibir noticias
		WebElement  checkBoxRN = driver.findElement(By.xpath("//input[@id='is_subscribed']"));
		checkBoxRN.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement campoCorreoElectronico = driver.findElement(By.xpath("//input[@id='email_address']"));
		campoCorreoElectronico.sendKeys(correoElectronico);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement campoContrasena= driver.findElement(By.xpath("//input[@id='password']"));
		campoContrasena.sendKeys(contrasena);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement campoConfirmarContrasena= driver.findElement(By.xpath("//input[@id='password-confirmation']"));
		campoConfirmarContrasena.sendKeys(confirmarContrasena);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//Dando click a boton de Enviar
			
		WebElement botonEnviar = driver.findElement(By.xpath("//span[normalize-space()='Enviar']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", botonEnviar);
        
     
		
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://mcstaging.lacuracaonline.com/elsalvador/customer/account/create/");
		
		
	}
	
	@AfterMethod
    public void teardown1() {

        driver.quit();
    }
	   
	

	@Test(description = "Validacion de ingreso correcto al sitio de Ecommerce")
	@Description("Test para validar la carga correcta del sitio de Ecommerce")

	public void testLCOTitle() {

		// Open LCO Ecommerce

		String urlBase = "https://mcstaging.lacuracaonline.com/elsalvador/";

		driver.get(urlBase);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Get the title of the page
		String actualTitle = driver.getTitle();

		// Expected title
		String expectedTitle = "Electrónica, Muebles, Camas y Electrodomésticos | La Curacao";

		// Assert that the actual title is equal to the expected title
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	
	@AfterMethod
    public void teardown2() {

        driver.quit();
    }

	@Test(description = "Verificacion de acceso del usuario con credenciales")
	@Description("Test para validacion de Ingreso correcto de usuario con correo y contraseña")

	public void testLCOLogin() {
		String email = "cmpmendoza12@gmail.com";
		String pass = "Unicomer2026";

		WebDriver driver = new FirefoxDriver();
		String urlBase = "https://mcstaging.lacuracaonline.com/elsalvador/customer/account/login/";

		driver.get(urlBase);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Ingresando datos de usuario y password en los campos.
		// Enter email address
		WebElement campoEmail = driver.findElement(By.cssSelector("#email"));
		campoEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter password
		WebElement campoPassword = driver
				.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));
		campoPassword.sendKeys(pass);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on the Sign In button
		WebElement btnStartButton = driver
				.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Iniciar sesión')]"));
		btnStartButton.click();

		// Get the title of the page
		String actualTitle = driver.getTitle();

		// Expected title
		String expectedTitle = "Mi Cuenta";

		// Assert that the actual title is equal to the expected title
		Assert.assertEquals(actualTitle, expectedTitle);

	}
	@AfterMethod
    public void teardown3() {

        driver.quit();
    }

	@Test(description = "Cierre de la sesion activa del cliente")
	@Description("Test para validar el cierre de la sesion activa del cliente")
	public void testLCOEndSessionUser() {
		String email = "cmpmendoza12@gmail.com";
		String pass = "Unicomer2026";

		WebDriver driver = new FirefoxDriver();
		String urlBase = "https://mcstaging.lacuracaonline.com/elsalvador/customer/account/login/";

		driver.get(urlBase);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Ingresando datos de usuario y password en los campos.
		// Enter email address
		WebElement campoEmail = driver.findElement(By.name("login[username]"));
		campoEmail.sendKeys(email);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter password
		WebElement campoPassword = driver.findElement(By.name("login[password]"));
		campoPassword.sendKeys(pass);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on the Sign In button
		WebElement btnStartButton = driver
				.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Iniciar sesión')]"));
		btnStartButton.click();

		// Cerrando la ventana emergente
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element = driver.findElement(By.className("action-close"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();


		// Dando click en imagen
		// Localizamos el elemento sobre el que queremos colocarnos
        WebElement elementToHover = driver.findElement(By.cssSelector("div[class='account-image'] span[class='image-deferred img']"));
		
		// Creamos una instancia de Actions
        Actions actions = new Actions(driver);

        
		// Colocamos el cursor sobre el elemento
        actions.moveToElement(elementToHover).perform();

        // Esperamos a que el elemento sea visible
        wait.until(ExpectedConditions.visibilityOf(elementToHover));

        // Seleccionamos la opción "Imágenes" del menú desplegable
        WebElement dropdownList = driver.findElement(By.cssSelector("div[class='account-image'] span[class='image-deferred img']"));
        dropdownList.findElement(By.xpath("//a[normalize-space()='Cerrar sesión']"));
        dropdownList.click();


		// Get the title of the page
		String actualTitle = driver.getTitle();
		

		// Expected title
		String expectedTitle = "Mi Cuenta";

		// Assert that the actual title is equal to the expected title
		Assert.assertEquals(actualTitle, expectedTitle);		
		
	}
	
	@AfterMethod
    public void teardown4() {

        driver.quit();
    }
}
