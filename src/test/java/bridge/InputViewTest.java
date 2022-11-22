package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends CustomNsTest {

    public static final InputView inputView = new InputView();
    public static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 사이즈를 입력됐는지 테스트(실패 케이스)")
    @ValueSource(strings = {"21", "0", "+1", "-1", "05"})
    @ParameterizedTest
    void readBridegeSizeFailTest(String input) {

        command(input);
        inputView.readBridgeSize();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("다리의 사이즈를 입력됐는지 테스트(성공 케이스)")
    @ValueSource(strings = {"1", "2", "3", "4", "18", "19", "20"})
    @ParameterizedTest
    void readBridegeSizeSuccessTest(String input) {

        command(input);
        int number = inputView.readBridgeSize();
        boolean isTrue = (number <= 1 && number >= 20);
        assertThat(isTrue);
    }

    ///////////////////////////////////////////////

    @DisplayName("사용자가 이동할 칸을 입력받는지 테스트(실패 케이스)")
    @ValueSource(strings = {"A", "UU", "DD"})
    @ParameterizedTest
    void readMovingFailTest(String input) {

        command(input);
        inputView.readMoving();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("사용자가 이동할 칸을 입력받는지 테스트(성공 케이스)")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMovingSuccessTest(String input) {

        command(input);
        String move = inputView.readMoving();
        boolean isTrue = move.equals("U") || move.equals("D");
        assertThat(isTrue);
    }

    ////////////////////////////////////////////////////////////////

    @DisplayName("사용자가 리트라이 여부를 입력받는지 테스트(실패 케이스)")
    @ValueSource(strings = {"A", "RR", "QQ"})
    @ParameterizedTest
    void readGameCommandFailTest(String input) {

        command(input);
        inputView.readGameCommand();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @DisplayName("사용자가 리트라이 여부를 입력받는지 테스트(성공 케이스)")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void readGameCommandSuccessTest(String input) {

        command(input);
        String command = inputView.readGameCommand();
        boolean isTrue = command.equals("U") || command.equals("D");
        assertThat(isTrue);
    }
}