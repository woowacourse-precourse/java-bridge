package bridge;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("입력받은 다리 길이에 맞게 다리 생성")
    @Test
    public void makeBridgeLengthTest() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertEquals(bridgeMaker.makeBridge(3).size(), 3);
    }

    @DisplayName("범위를 벗어난 숫자에 대한 예외처리")
    @Test
    public void makeIllegalArgumentByOutRange() {
        int overNum = 30;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputView.checkInRange(overNum);
        });
    }

    @DisplayName("다리의 다음 칸을 확인")
    @Test
    public void moveBridgeTest() {
        BridgeGame bridgeGame = new BridgeGame(inputView, bridgeMaker, outputView);
        List<String> testInput = new ArrayList<>() {{
                add("U");
                add("D");
                add("U");
            }};
        bridgeGame.setBridge(testInput);
        bridgeGame.setBridgeStepCnt(2);
        assertThat(bridgeGame.move("U")).isTrue();
    }





}
