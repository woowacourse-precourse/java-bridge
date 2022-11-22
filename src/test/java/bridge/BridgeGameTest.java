package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.BridgeGame;
import bridge.Map;
import bridge.Player;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {
    private static Stream<Arguments> provideRetryTestArguments() {
        return Stream.of(
                Arguments.of("R", true, "재시작"),
                Arguments.of("Q", false, "종료")
        );
    }

    @DisplayName("오답 입력 시 재시작/종료 커맨드 정상 작동 여부 테스트")
    @MethodSource("provideRetryTestArguments")
    @ParameterizedTest(name = "{index}: {3}")
    void testRetryAndQuit(String command, boolean expectedIsRetry, String message) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"), new Player(new Map()));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        boolean isRetry = bridgeGame.retry(command);
        assertThat(isRetry).isEqualTo(expectedIsRetry);
    }

    @Test
    void testValidate() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"), new Player(new Map()));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        assertThatThrownBy(() -> bridgeGame.retry("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testErrorMessage() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"), new Player(new Map()));
        assertThat(bridgeGame.getTrial()).isEqualTo(1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> bridgeGame.retry("q"));
        assertThat(e.getMessage()).isEqualTo("[ERROR] R(재시작) 또는 Q(종료)만 입력할 수 있습니다.");
    }
}