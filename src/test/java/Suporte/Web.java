package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver abreNavegador() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\jordan.silva\\Documents\\Drivers\\geckodriver.exe");
        WebDriver navegador = new FirefoxDriver();
//        navegador.get("https://www.bankmanager.com.br");
        navegador.get("http://bankmanager2.finnet.hom/");
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return navegador;
    }
}
