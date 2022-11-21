package bridge.exception;

import java.util.List;

public interface TotalExceptionHandler {

    default void handleException(String input) {
        System.out.println("handleException 메소드 재정의가 필요합니다.");
    }

    default void handleException(List<String> input) {
        System.out.println("handleException 메소드 재정의가 필요합니다.");
    }

    default void handleException(boolean input) {
        System.out.println("handleException 메소드 재정의가 필요합니다.");
    }

    default void handleException(int input) {
        System.out.println("handleException 메소드 재정의가 필요합니다.");
    }
}
