package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @DisplayName("시작문구를 출력합니다.")
    @Test
    void printStartPhrases() {
        OutputView outputView = new OutputView();

        outputView.printStartPhrases();

        assertThat(output()).isEqualTo("다리 건너기 게임을 시작합니다.");
    }

    @DisplayName("다리의 길이를 요구하는 문구를 출력한다.")
    @Test
    void printAskLength() {
        OutputView outputView = new OutputView();

        outputView.printAskLengthPhrases();

        assertThat(output()).isEqualTo("다리의 길이를 입력해주세요.");
    }

    @DisplayName("이동에 대한 입력을 요구하는 문구를 출력한다.")
    @Test
    void printChoice() {
        OutputView outputView = new OutputView();

        outputView.printAskMovingPhrases();

        assertThat(output()).isEqualTo("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    @DisplayName("전부 맞았을 때의 다리의 상태를 출력한다.")
    @Test
    void printMapPerfect() {
        OutputView outputView = new OutputView();
        List<String> bridge = List.of("U", "D", "D", "U", "U", "D");
        List<String> inputs = List.of("U", "D", "D", "U", "U", "D");

        outputView.printMap(bridge, inputs);

        assertThat(output()).contains(
                "[ O |   |   | O | O |   ]",
                "[   | O | O |   |   | O ]"
        );
    }

    @DisplayName("조금 틀렸을 때의 다리의 상태를 출력한다.")
    @Test
    void printMapWrong() {
        OutputView outputView = new OutputView();
        List<String> bridge = List.of("U", "D", "D", "U", "U", "D");
        List<String> inputs = List.of("U", "U", "D", "U", "D", "D");

        outputView.printMap(bridge, inputs);

        assertThat(output()).contains(
                "[ O | X |   | O |   |   ]",
                "[   |   | O |   | X | O ]"
        );
    }

    @DisplayName("결과를 출력한다.")
    @Test
    void printResult() {
        OutputView outputView = new OutputView();
        String gameStatus = "성공";
        Integer numOfTrying = 2;

        outputView.printResult(gameStatus, numOfTrying);

        assertThat(output()).contains(
                "최종 게임 결과",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
        );
    }

    @Override
    protected void runMain() {
    }
}