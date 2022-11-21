package bridge;

import bridge.Setting.BridgeSideIndex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private final InputView inputView;

    public InputViewTest() {
        this.inputView = new InputView();
    }

    @Test
    @DisplayName(value = "입력이 잘 변환되는지 확인")
    void readBridgeSizeTest1() {
        assertSimpleTest(() -> assertThat(inputView.readBridgeSize("15"))
                .isEqualTo(15));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "2a", ""})
    @DisplayName(value = "입력이 에러를 잘 뱉는지 확인")
    void readBridgeSizeExceptionTest1(String line) {
        assertSimpleTest(() -> assertThatThrownBy(() -> inputView.readBridgeSize(line))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName(value = "입력의 유효성 검사가 잘되는지 확인")
    void readMovingTest1() {
        assertSimpleTest(() -> assertThat(inputView.readMoving("D"))
                .isEqualTo("D"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", " ", "DU", "D U", "123"})
    @DisplayName(value = "입력의 오류가 잘되는지 확인")
    void readMovingExceptionTest1(String line) {
        assertSimpleTest(() -> assertThatThrownBy(() -> inputView.readMoving(line))
                .isInstanceOf(IllegalArgumentException.class));
    }
}