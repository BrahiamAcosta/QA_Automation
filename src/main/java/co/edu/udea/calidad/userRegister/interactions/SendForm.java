package co.edu.udea.calidad.userRegister.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface.REGISTER_BUTTON;

public class SendForm implements Interaction {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Click.on(REGISTER_BUTTON));
    }

    public static SendForm register(){
        return Tasks.instrumented(SendForm.class);
    }
}
