package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomApplicationTest extends NsTest {
    @DisplayName("다리 생성 테스트 - 길이 3")
    @Test
    void generateBridgeTestCase1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "D", "U");
    }

    @DisplayName("다리 생성 테스트 - 길이 9")
    @Test
    void generateBridgeTestCase2() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 0, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(9);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "D", "U", "U", "U");
    }

    @DisplayName("한번만에 승리하는 시나리오")
    @Test
    void winFirstTry() {
        assertRandomNumberInRangeTest(() -> {
            run("7", "U", "D", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O | O | O | O ]",
                    "[   | O |   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1, 1, 1, 1, 1);
    }

    @DisplayName("세 번의 도전 끝에 승리하는 시나리오")
    @Test
    void winThirdTry() {
        assertRandomNumberInRangeTest(() -> {
            run("7",
                    "D", "R",
                    "U", "U", "R",
                    "U", "D", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "최종 게임 결과",
                    "[ O |   | O | O | O | O | O ]",
                    "[   | O |   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 1, 1, 1, 1, 1);
    }

    @DisplayName("다섯 번의 도전 끝에 실패하는 시나리오")
    @Test
    void loseFifthTry() {
        assertRandomNumberInRangeTest(() -> {
            run("7",
                    "D", "R",
                    "U", "U", "R",
                    "U", "D", "D", "R",
                    "U", "D", "U", "D", "R",
                    "U", "D", "U", "U", "U", "U", "D", "Q");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "[ O |   | O |   ]",
                    "[   | O |   | X ]",
                    "최종 게임 결과",
                    "[ O |   | O | O | O | O |   ]",
                    "[   | O |   |   |   |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 5"
            );
        }, 1, 0, 1, 1, 1, 1, 1);
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
