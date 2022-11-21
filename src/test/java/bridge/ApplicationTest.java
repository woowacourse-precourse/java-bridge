package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    List<String> onlyResult(String input) {
        input = input.replace("\r", "");
        List<String> result = new ArrayList<>(List.of(input.split("\n")));
        result.removeAll(List.of(""));
        return result;
    }

    @DisplayName("다리 생성 테스트: 길이가 3일 때")
    @Test
    void buildBridgeLower() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @DisplayName("다리 생성 테스트: 길이가 20일 때")
    @Test
    void buildBridgeUpper() {
        List<Integer> input = newArrayList(1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0);
        String[] answer = {"U", "D", "D", "U", "D", "U", "U", "D", "U", "U", "D", "D", "U", "U", "U", "U", "U", "D",
                "D", "D"};
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(input);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly(answer);
    }

    @DisplayName("기본 기능 테스트")
    @Test
    void basicOperation() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains("최종 게임 결과", "[ O |   | O ]", "[   | O |   ]", "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1");
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("기본 기능 테스트2: 재시작")
    @Test
    void basicOperationRestart() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "U", "D", "R", "U", "U", "D");
            List<String> outputs = onlyResult(output());
            assertThat(outputs).containsOnly("최종 게임 결과", "다리 건너기 게임을 시작합니다.", "다리의 길이를 입력해주세요.", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", "[   ]", "[ X ]", "[ O ]", "[   ]", "[ O |   ]", "[   | X ]", "[ O ]", "[   ]", "[ O | O ]", "[   |   ]", "[ O | O |   ]", "[   |   | O ]", "게임 성공 여부: 성공", "총 시도한 횟수: 3");

            int upSideIndex = output().indexOf("[ O | O |   ]");
            int downSideIndex = output().indexOf("[   |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
    }

    @DisplayName("기본 기능 테스트3: 종료")
    @Test
    void basicOperationTermination() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            List<String> outputs = onlyResult(output());
            assertThat(outputs).containsExactly("다리 건너기 게임을 시작합니다.", "다리의 길이를 입력해주세요.", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "[ O ]", "[   ]", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "[ O | X ]", "[   |   ]", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", "최종 게임 결과", "[ O | X ]", "[   |   ]", "게임 성공 여부: 실패");

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }


    @DisplayName("기본 기능 테스트4: 재시작 및 종료")
    @Test
    void basicOperationRestartTermination() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "D", "U", "Q");
            List<String> outputs = onlyResult(output());
            assertThat(outputs).containsExactly("다리 건너기 게임을 시작합니다.", "다리의 길이를 입력해주세요.", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "[ X ]", "[   ]", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "[   ]", "[ O ]", "이동할 칸을 선택해주세요. (위: U, 아래: D)", "[   | X ]", "[ O |   ]", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)", "최종 게임 결과", "[   | X ]", "[ O |   ]", "게임 성공 여부: 실패");

            int upSideIndex = output().indexOf("[   | X ]");
            int downSideIndex = output().indexOf("[ O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @DisplayName("다리 길이 입력 예외 테스트")
    @Test
    void basicException() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
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
