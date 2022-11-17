package bridge;

import exception.ExceptionHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


public class BridgeTest {
    @DisplayName("사용자로부터 3 ~ 20의 숫자를 입력받는다.")
    @Test
    void readBridgeSizeTest1() {
        ExceptionHandler eh = new ExceptionHandler();
        int num = 3;
        Assertions.assertThat(eh.readBridgeSizeExceptionHandler(num)).isEqualTo(3);
    }

    @DisplayName("사용자로부터 3 ~ 20의 숫자를 입력받는다.")
    @Test
    void readBridgeSizeTest2() {
        ExceptionHandler eh = new ExceptionHandler();
        int num = 20;
        Assertions.assertThat(eh.readBridgeSizeExceptionHandler(num)).isEqualTo(20);
    }

    @DisplayName("3 ~ 20의 숫자가 아니면 IllegalArgumentException 예외를 발생시키고 다시 입력을 받는다")
    @Test
    void readBridgeSizeTest3() {
        ExceptionHandler eh = new ExceptionHandler();
        int num = 2;
        Assertions.assertThatThrownBy(() -> eh.readBridgeSizeExceptionHandler(num))
                        .isInstanceOf(NoSuchElementException.class);
    }
//
//    @DisplayName("3 ~ 20의 숫자가 아니면 IllegalArgumentException 예외를 발생시키고 [ERROR]로 시작하는 메세지를 출력한다.")
//    @Test
//    void readBridgeSizeTest3() {
//        ExceptionHandler eh = new ExceptionHandler();
//        int num = 2;
//        Assertions.assertThatThrownBy(() -> eh.readBridgeSizeExceptionHandler(num))
//                .isInstanceOf(NoSuchElementException.class)
//                .hasMessageContaining("[ERROR] 다시 입력해 주세요");
//
//    }
}
