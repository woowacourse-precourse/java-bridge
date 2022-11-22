package bridge.View;

import bridge.Entity.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class InputView {

    @DisplayName("다리의 길이가 숫자가 아닌 경우 예외 발생")
    @Test
    void createBridgeLengthByNotNumber() {
        assertThatThrownBy(() -> new BridgeSize("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이 입력이 없는 경우 예외 발생")
    @Test
    void createBridgeLengthByNone() {
        assertThatThrownBy(() -> new BridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이 입력이 3~20 범위 외의 숫자일 경우 예외 발생")
    @Test
    void createBridgeLengthByIncorrectRange() {
        assertThatThrownBy(() -> new BridgeSize("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("이동할 칸의 입력 값이 U, D가 아닌 경우 예외 발생")
//    @Test
//    void createMovementByNotRange() {
//        assertThatThrownBy(() -> new B(List.of("U", "D", "O")))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("이동할 칸의 입력 값이 비어있을 경우")
//    @Test
//    void createMovementByNumber() {
//        assertThatThrownBy(() -> new UserBridge(List.of("U", "", "D")))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
