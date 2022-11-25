package bridge.service;

import bridge.constant.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("다리 길이를 입력하면 다리 생성 함수를 호출해 완성된 다리를 반환받는다.")
    @Test
    void createSetBridge() {
        List<String> bridge = new ArrayList<>();
        for (int size = Bridge.MIN.getNumber(); size <= Bridge.MAX.getNumber(); size++) {
            bridge = bridgeGame.setBridge(size);

            assertThat(bridge.size()).isEqualTo(size);
        }
    }

    @DisplayName("새로운 라운드가 시작되면 값을 변경한다.")
    @Test
    void createSetRound() {
        bridgeGame.setRound();
        List<String> map = bridgeGame.getMap();
        List<String> result = bridgeGame.getResult();

        assertThat(map.get(0).toString()).isEqualTo("]");
        assertThat(map.get(1).toString()).isEqualTo("]");
        assertThat(result.get(0)).isEqualTo("성공");
        assertThat(result.get(1)).isEqualTo("1");
    }

    @DisplayName("정답 U를 맞췄을 경우 위쪽 다리가 O로 표기된 다리를 반환한다.")
    @Test
    void correctUpBridge() {
        String user = "U";
        String answer = "U";

        List<String> bridge = bridgeGame.move(user, answer);

        assertThat(bridge.get(0).contains("O")).isTrue();
    }

    @DisplayName("정답 D를 맞췄을 경우 아래쪽 다리가 O로 표기된 다리를 반환한다.")
    @Test
    void correctDownBridge() {
        String user = "D";
        String answer = "D";

        List<String> bridge = bridgeGame.move(user, answer);

        assertThat(bridge.get(1).contains("O")).isTrue();
    }

    @DisplayName("정답 U를 틀렸을 경우 아래쪽 다리가 X로 표기된 다리를 반환한다.")
    @Test
    void incorrectUpBridge() {
        String user = "D";
        String answer = "U";

        List<String> bridge = bridgeGame.move(user, answer);

        assertThat(bridge.get(1).contains("X")).isTrue();
    }

    @DisplayName("정답 D를 틀렸을 경우 위쪽 다리가 X로 표기된 다리를 반환한다.")
    @Test
    void incorrectDownBridge() {
        String user = "U";
        String answer = "D";

        List<String> bridge = bridgeGame.move(user, answer);

        assertThat(bridge.get(0).contains("X")).isTrue();
    }

    @DisplayName("플레이어가 R을 입력시 true를 반환한다.")
    @Test
    void checkRetry() {
        String command = "R";
        assertThat(bridgeGame.retry(command)).isTrue();
    }

    @DisplayName("플레이어가 Q을 입력시 false를 반환한다.")
    @Test
    void checkQuit() {
        String command = "Q";
        assertThat(bridgeGame.retry(command)).isFalse();
    }

    @DisplayName("성공 여부를 실패로 바꾼다.")
    @Test
    void changeFail() {
        bridgeGame.changeToFail();
        String result = bridgeGame.getResult().get(0);
        assertThat(result).isEqualTo("실패");
    }
}
