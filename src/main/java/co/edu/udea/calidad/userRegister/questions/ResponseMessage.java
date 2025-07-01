package co.edu.udea.calidad.userRegister.questions;

import co.edu.udea.calidad.userRegister.userinterfaces.RegisterInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class ResponseMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        List<Target> possibleTargets = List.of(
                RegisterInterface.PASSWORD_DONT_MATCH,
                RegisterInterface.RESPONSE_MESSAGE_SUCCESS,
                RegisterInterface.RESPONSE_MESSAGE_ERROR
        );

        for(Target target : possibleTargets){
            try {
                // Verifica si el elemento existe y es visible para el actor
                if (target.resolveFor(actor).isVisible()) {
                    // Devuelve su texto limpio
                    return target.resolveFor(actor).getText().trim();
                }
            } catch (Exception e) {
            }
        }
        throw new AssertionError("No se encontró ningún mensaje visible en pantalla.");
    }

    public static ResponseMessage responseMessage(){
        return new ResponseMessage();
    }
}
