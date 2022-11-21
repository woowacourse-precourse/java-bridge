package bridge.domain;

import bridge.constant.enums.Moving;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private final int ATTEMPTS_COUNT_EXCEPTED = 10;
    private final int ITERATER_INITIALIZATION = 1;
    private final int SUCCESSFUL_MOVING_NUMBERS = 2;
    private final BridgeMap bridgeMap = new BridgeMap();
    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        List<String> bridge = List.of("U", "U");
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
        bridgeGame.move(Moving.UP.getValue());

        boolean inProgressExcepted = true;
        boolean overExcepted = false;
        boolean successExcepted = false;

        게임_상태_확인_기능들_테스트(inProgressExcepted, overExcepted,
                successExcepted);
    }

    @DisplayName("게임이 성공했을 때 상태 확인 기능 테스트")
    @Test
    public void 성공_게임_상태_확인_테스트() {
        boolean inProgressExcepted = false;
        boolean overExcepted = false;
        boolean successExcepted = true;

        for (int i = 0; i < SUCCESSFUL_MOVING_NUMBERS; i++) {
            bridgeGame.move(Moving.UP.getValue());
        }
        게임_상태_확인_기능들_테스트(inProgressExcepted, overExcepted,
                successExcepted);
    }

    @DisplayName("게임이 실패했을 때 상태 확인 기능 테스트")
    @Test
    public void 실패_게임_상태_확인_테스트() {
        boolean inProgressExcepted = false;
        boolean overExcepted = true;
        boolean successExcepted = false;
        bridgeGame.move(Moving.DOWN.getValue());

        게임_상태_확인_기능들_테스트(inProgressExcepted, overExcepted,
                successExcepted);
    }

    private void 게임_상태_확인_기능들_테스트(boolean inProgressExcepted,
            boolean overExcepted, boolean successExcepted) {
        assertThat(bridgeGame.inProgress()).isEqualTo(inProgressExcepted);
        assertThat(bridgeGame.over()).isEqualTo(overExcepted);
        assertThat(bridgeGame.success()).isEqualTo(successExcepted);
    }
}
