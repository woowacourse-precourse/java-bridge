package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgePrinterTest extends NsTest {

    BridgeGame bridgeGame = new BridgeGame();
    BridgePrinter bridgePrinter = new BridgePrinter();


    @Test
    public void bridgePrinterTest() {
        //given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame.setBridge(bridgeMaker.makeBridge(3));
        bridgeGame.setUser();
        bridgeGame.getUser().addUserMoving("U");
        bridgeGame.getUser().addUserMoving("D");

        //when
        bridgePrinter.printLine(bridgeGame.getUser(), bridgeGame.getBridge());

        //then
        assertThat(output()).contains("[ O |   ]");
        assertThat(output()).contains("[   | O ]");

    }

    @Override
    protected void runMain() {

    }


    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}