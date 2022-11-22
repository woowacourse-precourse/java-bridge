package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private final InputView inputView;

    public InputViewTest() {
        this.inputView = new InputView();
    }

    @Test
    @DisplayName(value = "입력이 잘 변환되는지 확인")
    void getBridgeSizeTest1() {
        assertSimpleTest(() -> assertThat(inputView.getBridgeSize("15"))
                .isEqualTo(15));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "2a", ""})
    @DisplayName(value = "입력이 에러를 잘 뱉는지 확인")
    void getBridgeSizeExceptionTest1(String line) {
        assertSimpleTest(() -> assertThatThrownBy(() -> inputView.getBridgeSize(line))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName(value = "입력의 유효성 검사가 잘되는지 확인")
    void getMovingTest1() {
        assertSimpleTest(() -> assertThat(inputView.getMoving("D"))
                .isEqualTo("D"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "DU", "D U", "123"})
    @DisplayName(value = "입력의 오류가 잘되는지 확인")
    void getMovingExceptionTest1(String line) {
        assertSimpleTest(() -> assertThatThrownBy(() -> inputView.getMoving(line))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName(value = "입력의 유효성 검사가 잘되는지 확인")
    void getGameCommandTest1() {
        assertSimpleTest(() -> assertThat(inputView.getGameCommand("R"))
                .isEqualTo("R"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "RQ", "R Q", "123"})
    @DisplayName(value = "입력의 오류가 잘되는지 확인")
    void getGameCommandExceptionTest1(String line) {
        assertSimpleTest(() -> assertThatThrownBy(() -> inputView.getGameCommand(line))
                .isInstanceOf(IllegalArgumentException.class));
    }
}