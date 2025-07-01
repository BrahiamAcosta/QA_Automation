package co.edu.udea.calidad.userRegister.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.CONFIRM_PASSWORD_FIELD;

public class EnterConfirmation implements Interaction {
    private final String confirmation;

    public EnterConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(confirmation).into(CONFIRM_PASSWORD_FIELD));
    }

    public static EnterConfirmation with(String confirmation) {
        return new EnterConfirmation(confirmation);
    }
}