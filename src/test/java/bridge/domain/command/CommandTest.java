package bridge.domain.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {

    @DisplayName("생성자 메소드에 R 혹은 Q를 입력되었을 때 Command 객체가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void constructor_test(String userInput) {
        Command command = new Command(userInput);

        assertThat(command).isInstanceOf(Command.class);
    }

    @DisplayName("생성자 메소드에 R이나 Q가 아닌 다른 문자를 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"RR", "Q ", "r", "D", "알", " R"})
    void constructor_error_test(String userInput) {
        assertThatThrownBy(() -> new Command(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R 혹은 Q만 입력할 수 있습니다.");
    }

    @DisplayName("equals 메소드에 Command 객체가 입력되었을 때 두 객체의 멤버변수로 비교한 결과를 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"R, R, true", "Q, Q, true", "R, Q, false", "Q, R, false"})
    void equals_test(String userInput, String another, boolean expected) {
        Command command = new Command(userInput);

        boolean actual = command.equals(new Command(another));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("isToRetryGame 메소드를 호출하였을 때 Command 객체의 멤버변수가 R과 같은지 비교하여 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"R, true", "Q, false"})
    void isToRetryGame_test(String userInput, boolean expected) {
        Command command = new Command(userInput);

        boolean actual = command.isToRetryGame();

        assertThat(actual).isEqualTo(expected);
    }
}