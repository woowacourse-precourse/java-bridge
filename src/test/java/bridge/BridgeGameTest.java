package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeGameTest {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final String ERROR = "[ERROR]";
    private final Bridge bridge = new Bridge(new ArrayList<>());

    @DisplayName("이동 입력이 U또는 D가 아니면 예외가 발생한다.")
    @Test
    void 이동입력으로_올바르지않은_값입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BridgeGame(bridge).validateIsRightMoving("K");
        }).getMessage().contains(ERROR);
    }

    @DisplayName("이동 입력으로 U또는 D를 입력하면 정상 작동한다.")
    @Test
    void 이동입력_정상_입력() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.validateMoving("U"));
    }

    @DisplayName("입력에 대해 move가 정상적으로 작동하는지 확인")
    @Test
    void 정답과_오답을_입력하고_이동() {
        List<String> bridgeAnswer = List.of("U", "D");
        Bridge bridge = new Bridge(bridgeAnswer);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.updateMap(1, true);
        bridgeMap.updateMap(1, false);
        List<String> movements = List.of("U", "U");
        for (String s : movements)
            bridgeGame.move(s);
        assertThat(bridgeGame.getBridgeMap().getMap()).isEqualTo(bridgeMap.getMap());
    }

    @DisplayName("게임 상태 입력이 R 또는 Q가 아니면 예외가 발생한다.")
    @Test
    void 게임상태입력으로_올바르지않은_값입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BridgeGame(bridge).validateIsRightCommand("F");
        }).getMessage().contains(ERROR);
    }

    @DisplayName("게임 상태 입력으로 R 또는 Q를 입력하면 정상 작동한다.")
    @Test
    void 게임상태입력_정상_입력() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertThat(bridgeGame.validateGameCommand("Q"));
    }

    @DisplayName("retry 후 round 수 확인")
    @Test
    void retry_4번_시도() {
        List<String> bridgeAnswer = List.of("U");
        Bridge bridge = new Bridge(bridgeAnswer);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int i = 0; i < 4; i++)
            bridgeGame.isExit("R");
        assertThat(bridgeGame.getRound()).isEqualTo(5);
    }

}
