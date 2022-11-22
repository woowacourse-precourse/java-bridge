package bridge.ui.output.dto;

import bridge.domain.bridge.BridgeDirection;
import bridge.domain.game.BridgeGame;
import bridge.domain.bridge.BridgeMap;
import bridge.domain.game.GamePlayer;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameMapStateTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        List<String> bridge = Lists.newArrayList("U", "D", "D", "U");
        BridgeMap bridgeMap = BridgeMap.from(bridge);
        GamePlayer gamePlayer = GamePlayer.withDefaultValue();

        this.bridgeGame = BridgeGame.of(bridgeMap, gamePlayer);
    }

    @Test
    public void 출력_형식_테스트() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.UP);
        bridgeGame.move(BridgeDirection.DOWN);
        bridgeGame.move(BridgeDirection.UP);

        Assertions.assertThat(bridgeGame.toBridgeGameMapState().toConsolePrintFormat())
                .isEqualTo(
                        "[ O |   | X ]\n"
                        + "[   | O |   ]"
                );
    }

    @Test
    public void 출력_형식_테스트_2() {
        // 다리 정보 {"U", "D", "D", "U"}
        bridgeGame.move(BridgeDirection.DOWN);

        Assertions.assertThat(bridgeGame.toBridgeGameMapState().toConsolePrintFormat())
                .isEqualTo(
                        "[   ]\n"
                                + "[ X ]"
                );
    }


}