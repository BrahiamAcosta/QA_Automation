package co.edu.udea.calidad.userRegister.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class RegistrationStepDefinition {

    @Managed
    public WebDriver driver;
    private Actor user = new Actor("user");

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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("envio el formulario")
    public void envioElFormulario() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("debo ver un mensaje {string}")
    public void deboVerUnMensaje(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Ingreso una contraseña {string}")
    public void ingresoUnaContraseña(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario 1: Registro exitoso
    @When("Ingreso mis datos de usuario válidos")
    public void ingresoMisDatosDeUsuarioVálidos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario 2: Registro fallido por usuario ya existente
    @When("Ingreso un correo electrónico ya registrado")
    public void ingresoUnCorreoElectrónicoYaRegistrado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario 3: Validación de contraseñas diferentes
    @When("ingreso una confirmación de contraseña diferente")
    public void ingresoUnaConfirmaciónDeContraseñaDiferente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //Scenario 4: Validación de reglas de contraseña
    @When("ingreso el mismo valor en la confirmación de contraseña")
    public void ingresoElMismoValorEnLaConfirmaciónDeContraseña() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
