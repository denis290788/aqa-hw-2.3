import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryAppTest {

    @BeforeEach
    void SetUpAll() {
        String name = DataGenerator.CardDeliveryRequest.generateByUserInfo().getName();
        String date = DataGenerator.CardDeliveryRequest.generateByUserInfo().getDate();
        String city = DataGenerator.CardDeliveryRequest.generateByUserInfo().getCity();
        String phone = DataGenerator.CardDeliveryRequest.generateByUserInfo().getPhone();
    }

    @Test
    void shouldConfirmCardDelivery() {

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue(DataGenerator.CardDeliveryRequest.generateByUserInfo().getCity());
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(date);
        $("[data-test-id=name] input").setValue(name);
        $("[data-test-id=phone] input").setValue(phone);
        $("[data-test-id=agreement]").click();
        $(byText("Запланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);

        $("[data-test-id=city] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=city] input").setValue(city);
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(date);
        $("[data-test-id=name] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=name] input").setValue(name);
        $("[data-test-id=phone] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=phone] input").setValue(phone);
        $(byText("Запланировать")).click();
        $(byText("Перепланировать")).click();
        $("[data-test-id=success-notification]").shouldBe(visible);
    }
}
