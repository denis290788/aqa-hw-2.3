import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {}

    public static class CardDeliveryRequest{
        private CardDeliveryRequest() {}

        public static CardDeliveryRequestByUserInfo generateByUserInfo() {
            Faker faker = new Faker(new Locale("ru"));

            Calendar instance = Calendar.getInstance();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
            instance.setTime(dateNow);
            instance.add(Calendar.DAY_OF_MONTH, 3);
            String confirmedDate = formatForDateNow.format(instance.getTime());
            instance.add(Calendar.DAY_OF_MONTH, 1);
            String anotherDate = formatForDateNow.format(instance.getTime());

            return new CardDeliveryRequestByUserInfo(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().city(),
                    confirmedDate,
                    anotherDate
            );
        }
    }
}
