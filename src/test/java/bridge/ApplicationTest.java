package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.handler.InputBridgeLengthHandler;
import bridge.handler.InputMoveStepHandler;
import bridge.handler.InputRestartHandler;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    InputMoveStepHandler inputMoveStepHandler = new InputMoveStepHandler();
    InputRestartHandler inputRestartHandler = new InputRestartHandler();
    InputBridgeLengthHandler inputBridgeLengthHandler = new InputBridgeLengthHandler();

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
    void 다리길이_범위_입력_예외테스트() {
        String test = "1";
        assertThatThrownBy(() -> {
            inputBridgeLengthHandler.checkInRange(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리길이_입력_숫자인지_예외테스트() {
        String test = "a";
        assertThatThrownBy(() -> {
            inputBridgeLengthHandler.checkIsNumber(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리길이_입력_아무것도_입력하지않는_예외테스트() {
        String test = "";
        assertThatThrownBy(() -> {
            inputBridgeLengthHandler.checkNonInput(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리길이_입력_정수초과_예외테스트() {
        String test_1 = "2221111111";
        long test_long = Long.parseLong(test_1);
        assertThatThrownBy(() -> {
            if(test_long > Integer.MAX_VALUE) {
                inputBridgeLengthHandler.checkOverIntegerRange(test_1);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_랜덤_위아래_입력하지_않았을떄_예외테스트() {
        String test = "";
        assertThatThrownBy(() -> {
            inputMoveStepHandler.checkNonInput(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_랜덤_D아니면U를_입력하지_않았을때_예외테스트() {
        String test = "qwe";
        assertThatThrownBy(() -> {
            inputMoveStepHandler.checkIsUpDown(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_Q아니면R_입력_예외테스트() {
        String test = "qwe";
        assertThatThrownBy(() -> {
            inputRestartHandler.checkQuitOrRestart(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_아무것도_없을때_예외테스트() {
        String test = "";
        assertThatThrownBy(() -> {
            inputRestartHandler.checkNonInput(test);
        }).isInstanceOf(IllegalArgumentException.class);
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
