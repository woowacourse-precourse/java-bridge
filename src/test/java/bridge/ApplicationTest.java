package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("기능 테스트 2: 게임 재시도 시 이동 현황 초기화")
    @Test
    void 기능_테스트_2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "U");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ O ]",
                    "[   ]"
            );

            int firstTrialDownSideIndex = output().indexOf("[ X ]");
            int retryMessageIndex = output().indexOf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            int secondTrialUpSideIndex = output().indexOf("[ O ]");
            assertThat(firstTrialDownSideIndex).isLessThan(retryMessageIndex);
            assertThat(retryMessageIndex).isLessThan(secondTrialUpSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("예외 테스트 2: 2회 이상 잘못된 값을 입력해도 재입력 진행")
    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() -> {
            runException("a", "1", "03", "3");
            assertThat(output().split("\n")).containsSequence(
                    ERROR_MESSAGE + " 사용자 입력 오류: 주어진 값이 정수가 아닙니다.",
                    ERROR_MESSAGE + " 사용자 입력 오류: 3부터 20 사이의 정수를 입력하세요.",
                    ERROR_MESSAGE + " 사용자 입력 오류: 주어진 값이 정수가 아닙니다.",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)"
            );
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
