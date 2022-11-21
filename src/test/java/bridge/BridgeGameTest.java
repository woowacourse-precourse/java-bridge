package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;


class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 재시작_패배_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "R", "U", "D", "U", "U", "D", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "[ O |   | O | O |   ]",
                    "[   | O |   |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O |   ]");
            int downSideIndex = output().indexOf("[   | O |   |   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1, 1);
    }

    @Test
    void 사용자_이동_입력_예외_테스트(){
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move();
        assertSimpleTest(() -> {
            runException("!@EAB");
            runException("21");
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

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
