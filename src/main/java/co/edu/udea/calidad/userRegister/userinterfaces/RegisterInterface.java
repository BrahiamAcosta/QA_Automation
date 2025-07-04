package co.edu.udea.calidad.userRegister.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterInterface extends PageObject {

    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .locatedBy("//button[normalize-space(text())='Register']");

    public static final Target EMAIL_FIELD = Target.the("Email field")
            .locatedBy("//*[@id='username']");
    public static final Target NAME_FIELD = Target.the("Name field")
            .locatedBy("//*[@id='firstName']");
    public static final Target LAST_NAME_FIELD = Target.the("Last Name field")
            .locatedBy("//*[@id='lastName']");
    public static final Target PASSWORD_FIELD = Target.the("Password field")
            .locatedBy("//*[@id='password']");
    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("Password field")
            .locatedBy("//*[@id='confirmPassword']");
    public static final Target PASSWORD_DONT_MATCH = Target.the("Password don't match")
            .locatedBy("//div[normalize-space(text())='Passwords do not match']");
    public static final Target RESPONSE_MESSAGE_ERROR = Target.the("Response message error")
            .locatedBy(".result.alert.alert-danger");
    public static final Target RESPONSE_MESSAGE_SUCCESS = Target.the("Response message success")
            .locatedBy(".result.alert.alert-success");
}