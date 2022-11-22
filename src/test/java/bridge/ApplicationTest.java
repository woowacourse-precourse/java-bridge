package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.constant.message.ErrorMessage;
import bridge.constant.message.InputErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 20})
    void 기능_테스트_다양한_다리_개수(int bridgeSize) {
        String ok = " O ";
        String bin = "   ";
        List<Integer> numbers = new ArrayList<>();
        List<String> commands = new ArrayList<>(List.of(String.valueOf(bridgeSize)));
        List<String> ups = new ArrayList<>();
        List<String> downs = new ArrayList<>();
        for (int size = 0; size < bridgeSize; size++) {
            int number = 0;
            String command = "D";
            String up = bin;
            String down = ok;

            if (size % 2 == 0) {
                number = 1;
                command = "U";
                up = ok;
                down = bin;
            }
            numbers.add(number);
            commands.add(command);
            ups.add(up);
            downs.add(down);
        }
        String upResult = String.format("[%s]", String.join("|", ups));
        String downResult = String.format("[%s]", String.join("|", downs));
        assertRandomNumberInRangeTest(() -> {
            run(commands.toArray(new String[commands.size()]));
            assertThat(output()).contains(
                    "최종 게임 결과",
                    upResult,
                    downResult,
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf(upResult);
            int downSideIndex = output().indexOf(downResult);
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, numbers.get(0), numbers.subList(1, numbers.size()).toArray(new Integer[numbers.size() - 1]));
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,1", "4,1", "0,2", "1,2", "4,2", "0,3", "1,3", "4,3"})
    void 기능_테스트_여러번의_입력_실패(int index, int totalCount) {
        List<String> commands = new ArrayList<>(List.of("3", "U", "D", "D", "R", "U", "D", "U"));
        List<String> errorMessages = new ArrayList<>();
        for (int count = 0; count < totalCount; count++) {
            commands.add(index, "a");
            errorMessages.add(ERROR_MESSAGE);
        }
        assertRandomNumberInRangeTest(() -> {
            run(commands.toArray(new String[commands.size()]));
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            assertThat(output()).contains(errorMessages.toArray(new String[errorMessages.size()]));

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "3j", " ", "-3"})
    void 예외_다리_길이_문자_포함(String command) {
        assertSimpleTest(() -> {
            runException(command);
            assertThat(output()).contains(createErrorMessage(InputErrorMessage.NO_NUMERIC_STRING));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    void 예외_다리_길이_범위(String command) {
        assertSimpleTest(() -> {
            runException(command);
            assertThat(output()).contains(createErrorMessage(InputErrorMessage.NO_RANGE_OF_BRIDGE_SIZE));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "R", "Q", " U", "D "})
    void 예외_칸_방향_외_문자(String command) {
        assertSimpleTest(() -> {
            runException("3", command);
            assertThat(output()).contains(createErrorMessage(InputErrorMessage.NO_VALID_MOVING));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "U", "D", " R", "Q "})
    void 예외_게임_관련_외_문자(String command) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "D", command);
            assertThat(output()).contains(createErrorMessage(InputErrorMessage.NO_VALID_GAME_COMMAND));
        }, 1, 0, 1);
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

    static String createErrorMessage(ErrorMessage errorMessage) {
        return String.format("%s %s", ERROR_MESSAGE, errorMessage.getMessage());
    }
}
