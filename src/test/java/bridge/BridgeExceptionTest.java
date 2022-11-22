package bridge;

import bridge.exception.BridgeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeExceptionTest {
    private final BridgeException bridgeException = new BridgeException();

    @DisplayName("다리 길이가 3~20이 아니면 예외 발생해주는 테스트")
    @Test
    void checkBridgeLengthInRangeTest() {
        assertThatThrownBy(()-> bridgeException
                .checkBridgeLengthInRange("22"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 아니면 예외 발생해주는 테스트")
    @Test
    void checkBridgeLengthAboutOnlyNumberTest() {
        assertThatThrownBy(()-> bridgeException
                .checkBridgeLengthAboutOnlyNumber("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 이동 방향이 U,D가 아니면 예외 발생해주는 테스트")
    @Test
    void checkBridgeMoveInputAlphabetTest() {
        assertThatThrownBy(()-> bridgeException
                .checkBridgeMoveInputAlphabet("S"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 이동 방향이 영어로만 이루어져 있는지 check 해주는 메서드")
    @Test
    void checkBridgeInputAlphabetOnlyEnglishTest() {
        assertThatThrownBy(()-> bridgeException
                .checkBridgeInputAlphabetOnlyEnglish("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 게임 옵션이 R,Q가 아니면 예외를 발생해주는 테스트")
    @Test
    void checkBridgeGameOptionInputAlphabetTest() {
        assertThatThrownBy(()-> bridgeException
                .checkBridgeGameOptionInputAlphabet("S"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
