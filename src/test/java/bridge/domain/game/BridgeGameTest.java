package bridge.domain.game;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private final int ATTEMPTS_COUNT_EXCEPTED = 10;
    private final int ITERATER_INITIALIZATION = 1;
    private final BridgeMap bridgeMap = new BridgeMap();
    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        final List<String> bridge = List.of("U", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    public void 게임_시도_횟수_카운트_테스트() {
        for (int i = ITERATER_INITIALIZATION; i < ATTEMPTS_COUNT_EXCEPTED; i++) {
            bridgeGame.retry(bridgeMap);
        }
        assertThat(bridgeGame.getNumberOfAttempts()).isEqualTo(ATTEMPTS_COUNT_EXCEPTED);
    }

    @DisplayName("게임이 진행 중일 때 상태 확인 기능 테스트")
    @Test
     public void 진행_게임_상태_확인_테스트() {
        final boolean inProgressExcepted = true;
        final boolean overExcepted = false;
        final boolean successExcepted = false;

        게임_상태_확인_기능들_테스트(inProgressExcepted, overExcepted,
                successExcepted);
    }

    @DisplayName("게임이 종료됐을 때 상태 확인 기능 테스트")
    @ParameterizedTest
    @CsvSource({"false,false,true,U,U", "false,true,false,U,D"})
    public void 성공_게임_상태_확인_테스트(final boolean inProgressExcepted, final boolean overExcepted,
            final boolean successExcepted, String direction1, String direction2) {
        final List<String> directions = List.of(direction1, direction2);

        for (String direction : directions) {
            bridgeGame.move(direction);
        }
        게임_상태_확인_기능들_테스트(inProgressExcepted, overExcepted,
                successExcepted);
    }

    private void 게임_상태_확인_기능들_테스트(final boolean inProgressExcepted,
            final boolean overExcepted, final boolean successExcepted) {
        assertThat(bridgeGame.inProgress()).isEqualTo(inProgressExcepted);
        assertThat(bridgeGame.over()).isEqualTo(overExcepted);
        assertThat(bridgeGame.success()).isEqualTo(successExcepted);
    }
}
