package Suporte;

import Pages.loginFormPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRule {
   private static WebDriver navegador;

    @Before
    public void setUp() throws InterruptedException {
        navegador = Web.abreNavegador();
        new loginFormPage(navegador)
                .acessoCliente()
                .digitarLogin("jordan")
                .digitarSenha("finnet10@")
                .clicarEntrar();
        try{
            navegador.findElement(By.id("BtnSimConfirmAttention")).click();
        }catch (Exception e){}
        WebDriverWait wait = new WebDriverWait(navegador, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("DescricaoModulo")));
        Thread.sleep(1000);
    }

    public static WebDriver getDriver() {
        return navegador;
    }


    @After(order = 0)
    public void tearDown() {
        navegador.close();
    }

}
