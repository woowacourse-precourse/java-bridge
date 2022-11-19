package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.Validator;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final Validator validator = new Validator();

    @ParameterizedTest
    @CsvSource({"3", "5", "19", "20"})
    void 다리_사이즈_입력_정답_테스트(String userInput) {
        assertThat(validator.validateBridgeSizeInput(userInput)).isEqualTo(Integer.parseInt(userInput));
    }

    @ParameterizedTest
    @CsvSource({"rraa", "abc", "'2,3'", "100", "1", "일", "이", "-15", "10-", "1+4", "21", "2"})
    void 다리_사이즈_입력_예외처리_테스트(String userInput) {
        assertThatThrownBy(() -> validator.validateBridgeSizeInput(userInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage(Validator.BRIDGE_SIZE_INPUT_ERROR);
    }

    @ParameterizedTest
    @CsvSource({"U", "D"})
    void 유저_이동_입력_정답_테스트(String userInput) {
        assertThat(validator.validateMovingInput(userInput)).isEqualTo(userInput);
    }

    @ParameterizedTest
    @CsvSource({"rraa", "abc", "'2,3'", "u", "d", "UU", "다운", "업", "DD", "-15", "10-", "1+4", "21", "2"})
    void 유저_이동_입력_예외처리_테스트(String userInput) {
        assertThatThrownBy(() -> validator.validateMovingInput(userInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage(Validator.MOVING_INPUT_ERROR);
    }

    @ParameterizedTest
    @CsvSource({"R", "Q"})
    void 유저_게임_커맨드_입력_정답_테스트(String userInput) {
        assertThat(validator.validateGameCommandInput(userInput)).isEqualTo(userInput);
    }

    @ParameterizedTest
    @CsvSource({"rraa", "abc", "'2,3'", "u", "d", "UU", "재시작", "종료", "DD", "-15", "10-", "1+4", "21", "2"})
    void 유저_게임_커맨드_입력_예외처리_테스트(String userInput) {
        assertThatThrownBy(() -> validator.validateGameCommandInput(userInput)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage(Validator.GAME_COMMAND_INPUT_ERROR);
    }

    @Test
    void BridgeRandomNumberGenerator_출력_테스트() {
        BridgeRandomNumberGenerator bridgeRandomNumGen = new BridgeRandomNumberGenerator();
        for (int i = 0; i < 20; i++) {
            int tempValue = bridgeRandomNumGen.generate();
            assertThat(tempValue).isIn(List.of(0, 1));
        }
    }

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
