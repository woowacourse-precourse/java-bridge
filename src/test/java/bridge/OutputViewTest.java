package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {


    @Test
    void testPreBridge(){
        assertRandomNumberInRangeTest(() -> {
            OutputView view = new OutputView();
            BridgeGameInfo gameInfo = new BridgeGameInfo(5);
            BridgeGame game = new BridgeGame(gameInfo);
            game.move("U");
            game.move("D");
            game.move("D");
            game.move("D");
            assertThat(view.preBridge(gameInfo)[1]).isEqualTo(" O |   |   |");
            assertThat(view.preBridge(gameInfo)[0]).isEqualTo("   | O | O |");
        }, 1, 0, 0,1,1);
    }

    @Test
    void testNowBridge_When_GoodBridge(){

        assertRandomNumberInRangeTest(() -> {
            OutputView view = new OutputView();
            BridgeGameInfo gameInfo = new BridgeGameInfo(5);
            BridgeGame game = new BridgeGame(gameInfo);
            game.move("U");
            game.move("D");
            game.move("D");
            game.move("D");
            assertThat(view.nowBridge(gameInfo)[1]).isEqualTo("   ");
            assertThat(view.nowBridge(gameInfo)[0]).isEqualTo(" X ");
        }, 1, 0, 0,1,1);
    }

    @Test
    void testNowBridge_When_BadBridge(){

        assertRandomNumberInRangeTest(() -> {
            OutputView view = new OutputView();
            BridgeGameInfo gameInfo = new BridgeGameInfo(5);
            BridgeGame game = new BridgeGame(gameInfo);
            game.move("U");
            game.move("D");
            game.move("D");
            game.move("U");
            assertThat(view.nowBridge(gameInfo)[1]).isEqualTo(" O ");
            assertThat(view.nowBridge(gameInfo)[0]).isEqualTo("   ");
        }, 1, 0, 0,1,1);
    }


}
