package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BridgePrintMakerTest {
    BridgePrintMaker bridgePrintMaker;

    @BeforeEach
    public void init() {
        bridgePrintMaker = new BridgePrintMaker();
    }

    @DisplayName("isContinueGame이 true가 나오는지 확인한다.")
    @Test
    void checkIsContinueGameEqualsTrue() {
        // given
        boolean expected = true;

        // when
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);

        boolean actual = bridgePrintMaker.isContinueGame();

        // then
        assertEquals(actual, expected, "[ERROR] isContinueGame 반환값이 예상한 값과 다릅니다.");
    }

    @DisplayName("isContinueGame이 false가 나오는지 확인한다.")
    @Test
    void checkIsContinueGameEqualsFalse() {
        // given
        boolean expected = false;

        // when
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.DOWN);

        boolean actual = bridgePrintMaker.isContinueGame();

        // then
        assertEquals(actual, expected, "[ERROR] isContinueGame 반환값이 예상한 값과 다릅니다.");
    }

    @DisplayName("게임을 성공했을 때 출력값이 제대로 나오는지 확인한다.")
    @Test
    void checkGetBridgePrintWhenSuccess() {
        // given
        String expected = "[ O |   | O |   | O ]\n[   | O |   | O |   ]\n";

        // when
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);

        String actual = bridgePrintMaker.getBridgePrint();

        System.out.println(expected);
        System.out.println(actual);

        // then
        assertEquals(actual, expected, "[ERROR] getBridgePrint 반환값이 예상한 값과 다릅니다.");
    }

    @DisplayName("게임 도중에 실패할 때 출력값이 제대로 나오는지 확인한다.")
    @Test
    void checkGetBridgePrintWhenFail() {
        // given
        String expected = "[ O |   | O |   |   ]\n[   | O |   | O | X ]\n";

        // when
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("U", Direction.UP);
        bridgePrintMaker.addStepBridge("D", Direction.DOWN);
        bridgePrintMaker.addStepBridge("D", Direction.UP);

        String actual = bridgePrintMaker.getBridgePrint();

        // then
        assertEquals(actual, expected, "[ERROR] getBridgePrint 반환값이 예상한 값과 다릅니다.");
    }
}
