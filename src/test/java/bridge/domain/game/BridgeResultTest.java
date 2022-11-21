package bridge.domain.game;

import bridge.domain.bridge.Square;
import bridge.domain.move.MoveResult;
import bridge.domain.move.MoveType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeResultTest {

    private BridgeResult bridgeResult;

    @BeforeEach
    void init() {
        bridgeResult = new BridgeResult();
        bridgeResult.updateResult(new SquareResult(new Square(MoveType.UP), MoveResult.SUCCESS));
        bridgeResult.updateResult(new SquareResult(new Square(MoveType.UP), MoveResult.SUCCESS));
        bridgeResult.updateResult(new SquareResult(new Square(MoveType.DOWN), MoveResult.FAIL));

    }

    @DisplayName("위쪽 다리의 결과만 가져온다.")
    @Test
    void getUpBridge() {
        Map<Square, List<String>> result = bridgeResult.getResult();

        List<String> up = result.get(new Square(MoveType.UP));

        assertThat(up.get(0)).isEqualTo(MoveResult.SUCCESS.symbol());
        assertThat(up.get(1)).isEqualTo(MoveResult.SUCCESS.symbol());
        assertThat(up.get(2)).isEqualTo(MoveResult.NOTHING.symbol());
    }

    @DisplayName("아래쪽 다리의 결과만 가져온다.")
    @Test
    void getDownBridge() {
        Map<Square, List<String>> result = bridgeResult.getResult();

        List<String> down = result.get(new Square(MoveType.DOWN));

        assertThat(down.get(0)).isEqualTo(MoveResult.NOTHING.symbol());
        assertThat(down.get(1)).isEqualTo(MoveResult.NOTHING.symbol());
        assertThat(down.get(2)).isEqualTo(MoveResult.FAIL.symbol());
    }

    @DisplayName("게임의 최종 성공 여부를 판별한다.")
    @Test
    void validateFinalSuccess() {
        String finalResult = bridgeResult.getMoveSuccessResult();

        assertThat(finalResult).isEqualTo(MoveResult.FAIL.value());
    }
}