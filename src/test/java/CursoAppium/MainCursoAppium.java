package CursoAppium;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CursoAppium/CursoAppium.feature",
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json","junit:target/cucumber.json"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = true)

public class MainCursoAppium {
    @BeforeClass
    public static void beforeClass() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.setProperty("currentdate", dateFormat.format(new Date()));
    }
}
