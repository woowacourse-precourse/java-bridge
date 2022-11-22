package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.exception.BridgeGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameExceptionTest {

    private final BridgeGameException bridgeGameException = new BridgeGameException();

    @DisplayName("다리의 길이 입력 값이 문자인지 확인하는 메서드")
    @Test
    public void inputContainCharExceptionTest() {
        // given
        String input = "abc";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.inputContainCharException(input))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 깅이 입력이 3~20 사이인지 확인하는 메서드")
    @Test
    public void checkNumberRangeExceptionTest() {
        // given
        String input = "44";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.checkNumberRangeException(input))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 입력이 올바른지 확인하는 메서드")
    @Test
    public void checkCorrectUpOrDownExceptionTest() {
        // given
        String input = "T";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.checkCorrectUpOrDownException(input))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력의 길이를 확인하는 메서드")
    @Test
    public void checkInputSizeExceptionTest() {
        // given
        String input = "abc";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.checkInputSizeException(input))
          .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 게임 재시작 여부 입력이 올바른지 확인하는 메서드")
    @Test
    public void checkRestartOrDoneExceptionTest() {
        // given
        String input = "abcd";

        // when, then
        assertThatThrownBy(() -> bridgeGameException.checkRestartOrDoneException(input))
          .isInstanceOf(IllegalArgumentException.class);
    }
}
