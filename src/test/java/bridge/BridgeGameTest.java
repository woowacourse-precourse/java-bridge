package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {
    @Test
    void 다리에서_이동가능한_경우() {
        TestNumberGenerator generator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, generator);
        GameResult gameResult = bridgeGame.move("U");
        assertThat(gameResult.getMoveResult().getResult()).isEqualTo("O");
    }

    @Test
    void 다리에서_이동불가능한_경우() {
        TestNumberGenerator generator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame bridgeGame = new BridgeGame(3, generator);
        GameResult gameResult = bridgeGame.move("D");
        assertThat(gameResult.getMoveResult().getResult()).isEqualTo("X");
    }

    @Test
    void 다리_이동가능한지_확인() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
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
