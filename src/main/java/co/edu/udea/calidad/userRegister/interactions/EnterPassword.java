package co.edu.udea.calidad.userRegister.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.PASSWORD_FIELD;

public class EnterPassword implements Interaction {
    private final String password;

    public EnterPassword(String password) {
        this.password = password;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(password).into(PASSWORD_FIELD));
    }

    public static EnterPassword with(String password) {
        return new EnterPassword(password);
    }
}
