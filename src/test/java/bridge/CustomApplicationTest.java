package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomApplicationTest {

    @DisplayName("다리 길이에 대한 예외처리")
    @ValueSource(strings = {"a", " 3", "100", "bbb", "1"})
    @ParameterizedTest
    void 다리길이_예외처리(String input) {
        assertThatThrownBy(() -> new Bridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 명령에 대한 예외처리")
    @ValueSource(strings = {"a", "    U", "DD", "1"})
    @ParameterizedTest
    void 이동명령_예외처리(String input) {
        assertThatThrownBy(() -> new Move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 명령에 대한 예외처리")
    @ValueSource(strings = {"r", "    Q", "RR", "0"})
    @ParameterizedTest
    void 재시작명령_예외처리(String input) {
        assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리건너기의 정답을 맞췄다면 이동")
    @Test
    void 다리건너기_이동_테스트() {
        // Given
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge("4");
        bridgeGame.setBridgeAnswer(Arrays.asList("U", "D", "U", "U"));

        // When
        bridgeGame.move("U");

        // Then
        assertThat(bridgeGame.getBridgeState()).isEqualTo(Arrays.asList("U"));
        assertThat(bridgeGame.getUserState()).isEqualTo("진행중");
    }

    @DisplayName("다리건너기 성공")
    @Test
    void 다리건너기_성공_테스트() {
        // Given
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge("4");
        bridgeGame.setBridgeAnswer(Arrays.asList("U", "D", "U", "U"));

        // When
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");

        // Then
        assertThat(bridgeGame.getBridgeState()).isEqualTo(Arrays.asList("U", "D", "U", "U"));
        assertThat(bridgeGame.getUserState()).isEqualTo("성공");
    }

    @DisplayName("다리건너기 실패")
    @Test
    void 다리건너기_실패_테스트() {
        // Given
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge("3");
        bridgeGame.setBridgeAnswer(Arrays.asList("U", "D", "U"));

        // When
        bridgeGame.move("U");
        bridgeGame.move("U");

        // Then
        assertThat(bridgeGame.getBridgeState()).isEqualTo(Arrays.asList("U", "UX"));
        assertThat(bridgeGame.getUserState()).isEqualTo("실패");
    }

    @DisplayName("다리건너기 재시도")
    @Test
    void 다리건너기_재시도_테스트() {
        // Given
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge("3");
        bridgeGame.setBridgeAnswer(Arrays.asList("U", "D", "U"));

        // When
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();

        // Then
        assertThat(bridgeGame.getBridgeState()).isEqualTo(Arrays.asList());
        assertThat(bridgeGame.getUserState()).isEqualTo("진행중");
    }
}
