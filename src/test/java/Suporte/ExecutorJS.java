package Suporte;

import org.openqa.selenium.JavascriptExecutor;

public class ExecutorJS {

    public static void comandoJS(String script, String arguments) {

        JavascriptExecutor js = (JavascriptExecutor) TestRule.getDriver();
        js.executeScript(script);
        System.out.println("Campo ativado para input");

    }
}
