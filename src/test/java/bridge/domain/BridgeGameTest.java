package bridge.domain;

import bridge.domain.BridgeGame;
import bridge.util.BridgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame;

    private static final int BRIDGE_SIZE = 3;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String SPACE = "   ";
    private static final String X = " X ";
    private static final String O = " O ";

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(BRIDGE_SIZE);
    }

    @DisplayName("이동할 칸과 해당 라운드의 다리를 비교하여 이동할 수 있는 칸을 선택한 경우에는 O 표시, 선택하지 않은 칸은 공백으로 표시")
    @Test
    void getMovingResultBySuccess() {
        BridgeType bridgeByMoving = BridgeType.valueOfString(UP);
        String[] result = bridgeGame.compare(UP, UP, bridgeByMoving);

        assertThat(result).isEqualTo(new String[]{SPACE, O});
    }

    @DisplayName("이동할 칸과 해당 라운드의 다리를 비교하여 이동할 수 있는 칸을 선택한 경우에는 X 표시, 선택하지 않은 칸은 공백으로 표시")
    @Test
    void getMovingResultByFail() {
        BridgeType bridgeByMoving = BridgeType.valueOfString(UP);
        String[] result = bridgeGame.compare(DOWN, UP, bridgeByMoving);

        assertThat(result).isEqualTo(new String[]{SPACE, X});
    }
}