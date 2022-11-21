package bridge;

import java.util.Objects;

public class Validation {
    public static void validateObjectNull(Object object) {
        if (Objects.isNull(object)) {
            System.out.println("[ERROR] Null 객체는 유효하지 않습니다.");
            throw new NullPointerException();
        }
    }
}
