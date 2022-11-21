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

    @DisplayName("한 줄이 잘 출력 되는지 테스트")
    @Test
    void printLineTest() {
        String check=outputView.printLine(answer,answer, "U");
        assertThat(check).isEqualTo("[ O |   | O |   ]");

        check=outputView.printLine(answer,answer, "D");
        assertThat(check).isEqualTo("[   | O |   | O ]");
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

    @DisplayName("게임 성공 여부 테스트")
    @Test
    void checkSuccessTest() {
        boolean check=outputView.checkSuccess(answer,answer);
        assertThat(check).isEqualTo(true);
        check=outputView.checkSuccess(input,answer);
        assertThat(check).isEqualTo(false);
        check=outputView.checkSuccess(List.of("U","D"),answer);
        assertThat(check).isEqualTo(false);
    }
}