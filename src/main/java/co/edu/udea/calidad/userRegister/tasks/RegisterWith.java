package co.edu.udea.calidad.userRegister.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import co.edu.udea.calidad.userRegister.interactions.EnterEmail;
import co.edu.udea.calidad.userRegister.interactions.EnterFullName;
import co.edu.udea.calidad.userRegister.interactions.EnterPassword;
import co.edu.udea.calidad.userRegister.interactions.EnterConfirmation;


public class RegisterWith implements Task {
    private final String login;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String confirmPassword;

    public RegisterWith(String login, String firstName, String lastName, String password, String confirmPassword) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                EnterEmail.with(login),
                EnterFullName.with(firstName, lastName),
                EnterPassword.with(password),
                EnterConfirmation.with(confirmPassword)
        );
    }

    public static RegisterWith data(String login, String firstName, String lastName, String password, String confirmPassword) {
        return Tasks.instrumented(RegisterWith.class, login, firstName, lastName, password, confirmPassword);
    }

}