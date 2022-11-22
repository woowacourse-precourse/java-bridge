package bridge;

import bridge.enums.MoveCommand;
import bridge.enums.RetryCommand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(3);
    BridgeGame bridgeGame = new BridgeGame(3, bridge);

    @Test
    void 이동_테스트() {
        System.out.println(bridgeGame.getCurrentIndex());
        assertThat(bridgeGame.move(MoveCommand.UP.getCommand())).isEqualTo(false);
        assertThat(bridgeGame.move(MoveCommand.DOWN.getCommand())).isEqualTo(false);
        assertThat(bridgeGame.move(MoveCommand.DOWN.getCommand())).isEqualTo(false);
    }

    @Test
    void 게임_종료_테스트() {
        bridgeGame.move(MoveCommand.UP.getCommand());
        bridgeGame.move(MoveCommand.DOWN.getCommand());
        bridgeGame.move(MoveCommand.DOWN.getCommand());
        assertThat(bridgeGame.isEndGame()).isEqualTo(true);
    }

    @Test
    void 재시도_테스트() {
        bridgeGame.move(MoveCommand.UP.getCommand());
        bridgeGame.move(MoveCommand.DOWN.getCommand());
        bridgeGame.retry();
        assertThat(bridgeGame.getCurrentIndex()).isEqualTo(0);
    }

    @Test
    void 재시도_커멘드_테스트() {
        assertThat(bridgeGame.isRetry(RetryCommand.RETRY.getCommand())).isEqualTo(true);
        assertThat(bridgeGame.isRetry(RetryCommand.END.getCommand())).isEqualTo(false);
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