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

    @Test
    void 한칸_움직임_성공시_출력을_위한_2줄_리스트_만들기() {
        boolean isMove = true;
        List<List<String>> expextMap = new ArrayList<>(
                List.of(
                        List.of("O"),
                        List.of(" ")
                )
        );
        bridgeGame.move("U");
        assertThat(bridgeGame.getMap()).isEqualTo(expextMap);
    }
    @Test
    void 한칸_움직임_실패시_출력을_위한_2줄_리스트_만들기() {
        boolean isMove = true;
        List<List<String>> expextMap = new ArrayList<>(
                List.of(
                        List.of(" "),
                        List.of("X")
                )
        );
        bridgeGame.move("D");
        assertThat(bridgeGame.getMap()).isEqualTo(expextMap);
    }


}
