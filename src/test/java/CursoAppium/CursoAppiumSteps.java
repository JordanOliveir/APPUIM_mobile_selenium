package CursoAppium;

import Driver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class CursoAppiumSteps {

    private AndroidDriver<MobileElement> driver;
    CursoAppiumPage curso = new CursoAppiumPage();

    @Before
    public void iniciarDriver(){driver = DriverFactory.getDriver();}

    @After
    public void tearDown(){DriverFactory.killDriver();}

    @Given("^Deve Preencher campo Texto$")
    public void devePreencherCampoTexto() throws InterruptedException {
        driver.findElement(curso.getFormulario()).click();
        driver.findElement(curso.getNome()).sendKeys("Jordan");
        assertEquals("Campo Nome","Jordan",driver.findElement(curso.getNome()).getText());
        driver.findElement(curso.getSelect()).click();
        driver.findElement(curso.getSelectPS4()).click();
        assertEquals("Verify console","PS4",driver.findElement(curso.getVirifySelect()).getText());
    }

    @Given("^Combo$")
    public void combo() throws Throwable {

    }

    @Given("^Switch Checkbox$")
    public void switchCheckbox() throws Throwable {

    }

    @When("^digito tal coisa$")
    public void digitoTalCoisa() throws Throwable {

    }

    @Then("^Quero resultado$")
    public void queroResultado() throws Throwable {

    }
}
