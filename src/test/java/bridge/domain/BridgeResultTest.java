package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeResultTest {

    private BridgeResult bridgeResult;

    @BeforeEach
    void setUp() {
        bridgeResult = new BridgeResult(new Bridge(List.of("U", "D", "D")));
    }

    @Test
    @DisplayName("다리를 건널 수 있다면 SUCCESS가 나와야 한다.")
    void moveResult_Success() {
        assertThat(bridgeResult.move("U")).isEqualTo(ResultSymbol.SUCCESS);
    }

    @Test
    @DisplayName("다리를 건널 수 없다면 FAIL이 나와야 한다.")
    void moveResult_Fail() {
        assertThat(bridgeResult.move("D")).isEqualTo(ResultSymbol.FAIL);
    }

    @Test
    @DisplayName("윗 칸의 이동 결과가 일치해야 한다.")
    void printMoveResult_UpLine() {
        bridgeResult.move("U");
        bridgeResult.move("D");
        assertThat(bridgeResult.getUpLine()).isEqualTo("[ O |   ]");
    }

    @Test
    @DisplayName("아래 칸의 이동 결과가 일치해야 한다.")
    void printMoveResult_DownLine() {
        bridgeResult.move("D");
        assertThat(bridgeResult.getDownLine()).isEqualTo("[ X ]");
    }

    @Test
    @DisplayName("이동을 2번하면 결과는 2가 나와야 한다.")
    void printCrossingCount() {
        bridgeResult.move("U");
        bridgeResult.move("D");
        assertThat(bridgeResult.getCrossingCount()).isEqualTo(2);
    }
}
