package bridge;

import static bridge.view.InputView.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static java.lang.System.in;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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

    @Test
    void 다리길이_숫자_범위_테스트() {
        int input = 21;
        assertThatThrownBy(() -> {
            InputView.bridgeLenRangeCheck(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }


    @Test
    void 이동칸_예외_테스트() {
        String input = "a";
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
           moveCheck(input);
        });
        assertThat(exception.getMessage()).contains("[ERROR]");

    }

    @Test
    void 재시작_및_종료_예외_테스트() {
        String input = "r";
        System.setIn(in);
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            replayCheck(input);
        });
        assertThat(exception.getMessage()).contains("[ERROR]");

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

    /*
    @Test
    void 다리_이동_결과_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "U",
                    "[ O ]",
                    "[   ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "D",
                    "[ O |   ]",
                    "[   | O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "D",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

     */

}
