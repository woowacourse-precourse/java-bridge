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

    @DisplayName("다리 길이가 숫자 타입이 아닐 경우 오류가 발생한다.")
    @Test
    void correctBridgeSize() {
        List<String> testInput = List.of("3", "15", "20");

        for (String input : testInput) {
            assertThat(Integer.toString(inputView.readBridgeSize(input))).isEqualTo(input);
        }
    }
}
