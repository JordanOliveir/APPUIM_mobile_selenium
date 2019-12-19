package Suporte;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Screenshots {
    private  WebDriver navegador;

    public Screenshots (WebDriver navegador){
        this.navegador = navegador;
    }


    public void gerarScreenshot(String cenario) {

        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(navegador);
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File("target/screenshots/" + cenario+ ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirScreenshot(){
        File folder = new File("target/screenshots/");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }

}
