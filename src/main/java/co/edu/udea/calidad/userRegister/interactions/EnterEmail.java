package co.edu.udea.calidad.userRegister.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.EMAIL_FIELD;

public class EnterEmail implements Interaction {
    private final String email;

    public EnterEmail(String email) {
        this.email = email;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Enter.theValue(email).into(EMAIL_FIELD));
    }
    public static EnterEmail with(String email) {
        return Tasks.instrumented(EnterEmail.class, email);
    }
}
