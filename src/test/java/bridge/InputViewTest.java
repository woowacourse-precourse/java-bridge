package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    private InputView inputView = new InputView();

    @DisplayName("다리 길이가 숫자 타입이 아닐 경우 오류가 발생한다.")
    @Test
    void wrongBridgeSize() {
        List<String> testInput = List.of("1", "21", "aa");

        for (String input : testInput) {
            assertThat(Integer.toString(inputView.readBridgeSize(input))).isNotEqualTo(input);
        }
    }

    @DisplayName("다리 길이가 3~20 사이의 숫자인 경우 오류가 발생하지 않는다.")
    @Test
    void correctBridgeSize() {
        List<String> testInput = List.of("3", "15", "20");

        for (String input : testInput) {
            assertThat(Integer.toString(inputView.readBridgeSize(input))).isEqualTo(input);
        }
    }

    @DisplayName("이동 방향이 U 혹은 D이 아닌 경우 오류가 발생한다.")
    @Test
    void wrongDirection() {
        List<String> testInput = List.of("1", "Q", "d", "-");

        for (String input : testInput) {
            assertThat(inputView.readMoving(input)).isNotEqualTo(input);
        }
    }

    @DisplayName("이동 방향이 U 혹은 D인 경우 정상적으로 작동한다.")
    @Test
    void correctDirection() {
        List<String> testInput = List.of("U", "D");

        for (String input : testInput) {
            assertThat(inputView.readMoving(input)).isEqualTo(input);
        }
    }

    @DisplayName("게임 종료 여부가 R 혹은 Q이 아닌 경우 오류가 발생한다.")
    @Test
    void wrongGameCommand() {
        List<String> testInput = List.of("1", "U", "q", "-");

        for (String input : testInput) {
            assertThat(inputView.readGameCommand(input)).isNotEqualTo(input);
        }
    }

    @DisplayName("게임 종료 여부가 R 혹은 Q인 경우 정상적으로 작동한다.")
    @Test
    void correctGameCommand() {
        List<String> testInput = List.of("R", "Q");

        for (String input : testInput) {
            assertThat(inputView.readGameCommand(input)).isEqualTo(input);
        }
    }
}
