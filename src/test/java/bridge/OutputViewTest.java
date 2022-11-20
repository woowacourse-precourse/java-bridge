package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView= new OutputView();
    List<String> answer=List.of("U","D","U","D");
    List<String> input=List.of("U","D","D","D");

    @DisplayName("전체 출력이 잘 되는지 테스트")
    @Test
    void printMapTest() {
        String check=outputView.printLine(answer,answer, "U");
        assertThat(check).isEqualTo("[ O |   | O |   ]\n[   | O |   | O ]");
    }

    @DisplayName("한 줄이 잘 출력 되는지 테스트")
    @Test
    void printLineTest() {
        String check=outputView.printLine(answer,answer, "U");
        assertThat(check).isEqualTo("[ O |   | O |   ]");
    }

    @DisplayName("다리의 해당 위치가 U인지 D인지 테스트")
    @Test
    void checkSameLocationTest() {
        boolean check=outputView.checkSameLocation(answer,2, "U");
        assertThat(check).isEqualTo(true);
        check=outputView.checkSameLocation(input, 2, "U");
        assertThat(check).isEqualTo(false);
    }

    @DisplayName("입력과 정답이 같은지 테스트")
    @Test
    void checkSameMoveTest() {
        boolean check=outputView.checkSameMove(answer,answer, 2);
        assertThat(check).isEqualTo(true);
        check=outputView.checkSameMove(input,answer, 2);
        assertThat(check).isEqualTo(false);
    }

    @Test
    void printResultTest() {
    }
}