package tests.web;

import com.codeborne.selenide.Configuration;
import models.UserModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.petstore.RegistrationPetstorePage;

import static com.codeborne.selenide.Selenide.open;

public class PetstoreTests {

    @BeforeAll
    static void beforAll() {
        Configuration.baseUrl = "https://petstore.octoperf.com";
    }

    @Test
    void registrationFormTest() {

        UserModel userModel = new UserModel();

//        userModel.builder()
//                .userID("moron")
//                .password("moron123")
//                .firstName("moron")
//                .lastName("moron")
//                .email("moron@moron.com")
//                .phone("123456")
//                .address1("address1")
//                .address2("addres2")
//                .city("city")
//                .state("state")
//                .zip("123123")
//                .country("country");

        RegistrationPetstorePage registrationPetstorePage = new RegistrationPetstorePage();

        registrationPetstorePage.openPage()
                .setUserID("moron")
                .setNewPassword("moron123")
                .setRepeatPassword("moron123");

    }
}
