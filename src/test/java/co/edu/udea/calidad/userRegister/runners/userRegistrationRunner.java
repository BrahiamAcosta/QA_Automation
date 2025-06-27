package co.edu.udea.calidad.userRegister.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/user_registration.feature",
        glue = "co.edu.udea.calidad.userRegister.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class userRegistrationRunner {}