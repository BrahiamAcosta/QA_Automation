package co.edu.udea.calidad.userRegister.stepdefinitions;

import co.edu.udea.calidad.userRegister.questions.ResponseMessage;
import co.edu.udea.calidad.userRegister.tasks.RegisterWith;
import co.edu.udea.calidad.userRegister.tasks.SubmitRegistration;
import co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class RegistrationStepDefinition {

    @Managed
    public WebDriver driver;
    private Actor user = new Actor("user");

    RegisterInterface registerInterface = new RegisterInterface();

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
        user.can(BrowseTheWeb.with(driver));
    }

    private String lastPasswordUsed;

    //Pasos comunes a varios escenarios
    @Given("Estoy en la pagina de registro")
    public void estoyEnLaPaginaDeRegistro() {
        user.wasAbleTo(Open.browserOn(registerInterface));
    }

    @When("Ingreso una contraseña {string}")
    public void ingresoUnaContraseña(String string) {
        this.lastPasswordUsed = string;
    }

    @When("envio el formulario")
    public void envioElFormulario() {
        user.attemptsTo(SubmitRegistration.form());
    }
    @Then("debo ver un mensaje {string}")
    public void deboVerUnMensaje(String string) {
        user.should(
                seeThat(ResponseMessage.responseMessage(), containsString(string))
        );
    }


    //Scenario 1: Registro exitoso
    @When("Ingreso mis datos de usuario válidos")
    public void ingresoMisDatosDeUsuarioVálidos() {
        user.attemptsTo(RegisterWith.data((
                "TestUser"+System.currentTimeMillis()+"@test.com"),
                "John",
                "Doe",
                "Password123.",
                "Password123."));
    }

    //Scenario 2: Registro fallido por usuario ya existente
    @When("Ingreso un correo electrónico ya registrado")
    public void ingresoUnCorreoElectrónicoYaRegistrado() {
        user.attemptsTo(RegisterWith.data(
                "Test@test.com",
                "John",
                "Doe",
                "Password123.",
                "Password123."));
    }

    //Scenario 3: Validación de contraseñas diferentes
    @When("ingreso una confirmación de contraseña diferente")
    public void ingresoUnaConfirmaciónDeContraseñaDiferente() {
        user.attemptsTo(RegisterWith.data((
                        "TestUser"+System.currentTimeMillis()+"@test.com"),
                "John",
                "Doe",
                lastPasswordUsed,
                "Different123."));
    }

    //Scenario 4: Validación de reglas de contraseña
    @When("ingreso el mismo valor en la confirmación de contraseña")
    public void ingresoElMismoValorEnLaConfirmaciónDeContraseña() {
        user.attemptsTo(RegisterWith.data((
                        "TestUser"+System.currentTimeMillis()+"@test.com"),
                "John",
                "Doe",
                lastPasswordUsed,
                lastPasswordUsed));
    }
}
