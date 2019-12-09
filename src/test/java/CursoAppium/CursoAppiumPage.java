package CursoAppium;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class CursoAppiumPage {

    private By formulario = MobileBy.xpath("//*[@text='Formulário']");
    private By nome = MobileBy.AccessibilityId("nome");//content-desc é igual a accessibilityId
    private By select = MobileBy.AccessibilityId("console");//content-desc é igual a accessibilityId
    private By selectPS4 = MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']");
    private By virifySelect = MobileBy.xpath("//android.widget.Spinner/android.widget.TextView");
    private By checkbox = MobileBy.className("android.widget.CheckBox");
    private By switc = MobileBy.className("android.widget.Switch");

    public By getFormulario() {return formulario;}

    public By getNome() {return nome;}

    public By getSelect() {return select;}

    public By getSelectPS4() {return selectPS4;}

    public By getVirifySelect() {return virifySelect;}

    public By getCheckbox() {return checkbox;}

    public By getSwitc() {return switc;}
}
