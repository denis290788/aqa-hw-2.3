import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class CardDeliveryRequestByUserInfo {
    private final String name;
    private final String phone;
    private final String city;
    private final String date;
}
