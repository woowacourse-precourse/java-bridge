package bridge;

import bridge.inputview.InputView;
import bridge.outputview.OutputView;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeGameTest {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> bridge = List.of("U", "D", "U");

    BridgeGame bridgeGame;

    @BeforeEach
    void initTest() {
        bridgeGame = new BridgeGame(inputView, outputView, bridge);
    }

    @Test
    void 다리_한칸_움직임이_성공() {
        String input = "U";
        boolean isMove = bridgeGame.isMove(input);
        assertThat(isMove).isTrue();
    }

    @Test
    void 다리_한칸_움직임이_실패() {
        String input = "D";
        boolean isMove = bridgeGame.isMove(input);
        assertThat(isMove).isFalse();
    }


}
