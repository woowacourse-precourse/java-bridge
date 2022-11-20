package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.Controller.BridgeSizeValidator;
import bridge.Controller.MovingCommandValidator;
import bridge.Controller.Validator;
import bridge.View.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 입력 가능한 범위를 초과하였습니다.(3 <= N <= 20)";
    private static final String ERROR_NON_EXISTENT_COMMAND = "[ERROR] 올바르지 않은 명령입니다.";
    private static InputStream in;
    private static InputView inputView = new InputView();
    private static Validator validator;

    //region 다리길이입력 단위 테스트 케이스
    @Test
    void 다리길이입력_예외테스트_문자입력(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("a");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_제어문자입력(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("\n");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최소경계값초과(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("2");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최대경계값초과(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("31");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_기능테스트_최소경계값(){
        String input = "3";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(3);
    }

    @Test
    void 다리길이입력_기능테스트_최대경계값(){
        String input = "30";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(30);
    }
    //endregion

    //region 다리생성 단위 테스트 케이스
    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_길이30() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(30);
        assertThat(bridge).containsExactly(
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D");
    }
    //endregion

    //region 이동할 칸 입력 단위 테스트 케이스
    @Test
    void 이동할_칸_입력_예외테스트_지정문자이외입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("B");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_소문자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("u");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_숫자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("5");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_제어문자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("\r");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_기능테스트_U(){
        String input = "U";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readMoving();
        assertThat(movingCommand).isEqualTo("U");
    }

    @Test
    void 이동할_칸_입력_기능테스트_D(){
        String input = "D";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readMoving();
        assertThat(movingCommand).isEqualTo("D");
    }
    //endregion

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
