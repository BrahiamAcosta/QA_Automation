package co.edu.udea.calidad.userRegister.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.NAME_FIELD;
import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.LAST_NAME_FIELD;

public class EnterFullName implements Interaction {
    private final String firstName;
    private final String lastName;

    public EnterFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Enter.theValue(firstName).into(NAME_FIELD));
        t.attemptsTo(Enter.theValue(lastName).into(LAST_NAME_FIELD));
    }

    public static EnterFullName with(String firstName, String lastName) {
        return Tasks.instrumented(EnterFullName.class, firstName, lastName);
    }
}
