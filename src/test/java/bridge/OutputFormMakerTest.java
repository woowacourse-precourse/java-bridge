package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputFormMakerTest {

    OutputFormMaker outputFormMaker = new OutputFormMaker();

    @DisplayName("게임 최종 결과에 출력할 내용의 첫번째 줄 내용을 확인한다.")
    @Test
    void createFirstLineList() {
        List<String> user = List.of("U", "D", "U");
        List<String> bridge = List.of("U", "U", "U");
        assertThat(outputFormMaker.createFirstLineList(user, bridge))
                .isEqualTo(List.of("true", " ", "true"));

    }

    @DisplayName("게임 최종 결과에 출력할 내용의 두번째 줄 내용을 확인한다.")
    @Test
    void createSecondLineList() {
        List<String> user = List.of("U", "D", "U");
        List<String> bridge = List.of("U", "U", "U");
        assertThat(outputFormMaker.createSecondLineList(user, bridge))
                .isEqualTo(List.of(" ", "false", " "));
    }


    @DisplayName("게임 결과가 원하는 출력 형태로 바뀌는지 확인한다.")
    @Test
    void createMapForm() {
        List<String> firstLine = List.of("true", "true", " ");
        List<String> secondLine = List.of(" ", " ", "false");
        assertThat(outputFormMaker.createMapForm(firstLine))
                .isEqualTo("[ O | O |   ]");
        assertThat(outputFormMaker.createMapForm(secondLine))
                .isEqualTo("[   |   | X ]");

    }

    @DisplayName("유저 입력값과 다리의 내용이 같으면 성공이다.")
    @Test
    void createResult() {
        List<String> user = List.of("U", "U", "D", "U", "D");
        List<String> bridge = List.of("U", "U", "D", "U", "D");
        assertThat(outputFormMaker.createResult(user, bridge))
                .isEqualTo("성공");
    }
}