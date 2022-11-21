package bridge;

import bridge.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @DisplayName("이동 결과를 프린트한다.")
    @Test
    void printMap() {
        List<String> bridge = List.of("U", "U", "D", "U", "D");
        int position = 3;
        boolean correct = false;
        OutputView outputView = new OutputView();
        String output = outputView.buildMap(bridge, position, correct);
        String answer = "[ O | O | X ]\n" + "[   |   |   ]\n";
        assertThat(output).isEqualTo(answer);
    }
}
