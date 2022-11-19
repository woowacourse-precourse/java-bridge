package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.game.BridgeResult;
import bridge.domain.move.MoveResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeResultTest {

    private BridgeResult bridgeResult;

    @BeforeEach
    void init() {
        bridgeResult = new BridgeResult();
        bridgeResult.updateResult(new Square("U"), true);
        bridgeResult.updateResult(new Square("U"), true);
        bridgeResult.updateResult(new Square("D"), false);

    }

    @DisplayName("위쪽 다리의 결과만 가져온다.")
    @Test
    void getUpBridge() {
        List<String> upBridgeResult = bridgeResult.getUpBridgeResult();

        assertThat(upBridgeResult.get(0)).isEqualTo(MoveResult.SUCCESS.symbol());
        assertThat(upBridgeResult.get(1)).isEqualTo(MoveResult.SUCCESS.symbol());
        assertThat(upBridgeResult.get(2)).isEqualTo(MoveResult.NOTHING.symbol());
    }

    @DisplayName("아래쪽 다리의 결과만 가져온다.")
    @Test
    void getDownBridge() {
        List<String> downBridgeResult = bridgeResult.getDownBridgeResult();

        assertThat(downBridgeResult.get(0)).isEqualTo(MoveResult.NOTHING.symbol());
        assertThat(downBridgeResult.get(1)).isEqualTo(MoveResult.NOTHING.symbol());
        assertThat(downBridgeResult.get(2)).isEqualTo(MoveResult.FAIL.symbol());
    }
}