package bridge;

import bridge.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    List<String> bridge = List.of("U", "U", "D", "U", "D");

    @DisplayName("틀렸을 때 현재까지 이동 결과를 프린트한다.")
    @Test
    void printMapWrong() {
        int position = 3;
        boolean correct = false;
        OutputView outputView = new OutputView();
        String output = outputView.buildMap(bridge, position, correct);
        String answer = "[ O | O | X ]\n" + "[   |   |   ]\n";
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("맞았을 때 현재까지 이동 결과를 프린트한다.")
    @Test
    void printMapCorrect() {
        int position = 4;
        boolean correct = true;
        OutputView outputView = new OutputView();
        String output = outputView.buildMap(bridge, position, correct);
        String answer = "[ O | O |   | O ]\n" + "[   |   | O |   ]\n";
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("틀렸을 때 결과를 프린트한다.")
    @Test
    void printResultWrong() {
        int position = 4;
        boolean correct = false;
        OutputView outputView = new OutputView();
        String output = outputView.buildResult(bridge, position, correct);
        String answer = "최종 결과\n" + "[ O | O |   |   ]\n" + "[   |   | O | X ]\n";
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("끝까지 건넜을 때 결과를 프린트한다.")
    @Test
    void printResultCorrect() {
        int position = 5;
        boolean correct = true;
        OutputView outputView = new OutputView();
        String output = outputView.buildResult(bridge, position, correct);
        String answer = "최종 결과\n" + "[ O | O |   | O |   ]\n" + "[   |   | O |   | O ]\n";
        assertThat(output).isEqualTo(answer);
    }

    @DisplayName("성공/실패 시 결과를 프린트한다.")
    @CsvSource({"false, 2, 게임 성공 여부: 실패, ", "true, 3, 게임 성공 여부: 성공, 총 시도한 횟수: 3"})
    @ParameterizedTest
    void printSuccessOrFail(boolean success, int trial, String successFail, String trialPrint) {
        OutputView outputView = new OutputView();
        String output = outputView.buildSuccessOrFail(success, trial);
        assertThat(output).contains(successFail);
        if (trialPrint != null) {
            assertThat(output).contains(trialPrint);
        }
    }
}
