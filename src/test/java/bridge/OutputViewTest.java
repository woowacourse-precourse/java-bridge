package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class OutputViewTest {

    OutputView outputView;
    BridgeGame bridgeGame;

    @BeforeEach
    void init(){
        outputView = new OutputView();
        bridgeGame = new BridgeGame(new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0)), 3);
    }

    @Test
    void printMapTest1(){
        assertSimpleTest(() -> {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(outputView.printMap(bridgeGame))
                    .containsExactly("[   | O ]", "[ O |   ]");
        });
    }

    @Test
    void printMapTest2(){
        assertSimpleTest(() -> {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(outputView.printMap(bridgeGame))
                    .containsExactly("[   | X ]", "[ O |   ]");
        });
    }
}