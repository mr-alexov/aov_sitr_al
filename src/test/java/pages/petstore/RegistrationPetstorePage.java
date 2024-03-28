package pages.petstore;

import com.codeborne.selenide.SelenideElement;
import models.UserModel;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPetstorePage {

    SelenideElement userId = $("[name='username']"),
            newPassword = $("[name='password']"),
            repeatPassword = $("[name='repeatedPassword']"),
            firstName = $("[name='account.firstName']"),
            lastName = $("[name='account.lastName']"),
            email = $("[name='account.email']"),
            phone = $("[name='account.phone']"),
            address1 = $("[name='account.address1']"),
            address2 = $("[name='account.address2']"),
            city = $("[name='account.city']"),
            state = $("[name='account.state']"),
            zip = $("[name='account.zip']"),
            country = $("[name='account.country']");

    public RegistrationPetstorePage openPage(){
        open("/actions/Account.action?editAccountForm=");
        return this;
    }


    public RegistrationPetstorePage setUserID(String value){
        userId.setValue(value);
        return this;
    }

    public RegistrationPetstorePage setNewPassword(String value){
        newPassword.setValue(value);
        return this;
    }

    public RegistrationPetstorePage setRepeatPassword(String value){
        repeatPassword.setValue(value);
        return this;
    }

    public void registerUserWithUserModel(UserModel model){
        setUserID(model.getUserID())
                .setNewPassword(model.getPassword())
                .setRepeatPassword(model.getPassword());
    }


}
