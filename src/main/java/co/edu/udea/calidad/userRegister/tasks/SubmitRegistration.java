package co.edu.udea.calidad.userRegister.tasks;

import co.edu.udea.calidad.userRegister.interactions.SendForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SubmitRegistration implements Task {
    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(SendForm.register());
    }

    public static SubmitRegistration form(){
        return Tasks.instrumented(SubmitRegistration.class);
    }
}
