package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    @DisplayName("이동할 칸이 U나 D가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "u", "d", "UU", "UD", "DD", " U", "U ", " U "})
    void ThrowExceptionIfMovingIsIncorrect(String moving) {
        assertThatThrownBy(() -> new BridgeGame(5).move(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 D 또는 U로 입력해야 합니다.");
    }

    @DisplayName("게임 재시작 여부가 R이나 Q가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "r", "q", "RR", "RQ", "QQ", " R", "R ", " R "})
    void ThrowExceptionIfGameCommandIsIncorrect(String gameCommand) {
        assertThatThrownBy(() -> new BridgeGame(5).retry(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 재시작 여부 입력은 R 또는 Q이어야 합니다.");
    }
}
