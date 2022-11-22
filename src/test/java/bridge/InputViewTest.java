package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final InputView inputView = new InputView();

    @DisplayName("다리길이가 정상인 경우")
    @Test
    void goodBridgeSize() {
        int size = inputView.validateSize("3");
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("다리길이가 숫자가 아닌 경우")
    @Test
    void wrongTypeBridgeSize() {
        assertThatThrownBy(() -> inputView.validateSize("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리길이가 3~20 사이가 아닌 경우")
    @Test
    void wrongRangeBridgeSize() {
        assertThatThrownBy(() -> inputView.validateSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.validateSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸의 입력이 정상인 경우 (U,D)")
    @Test
    void goodMovingInput() {
        boolean isGood = inputView.validateMoving("U");
        assertThat(isGood).isEqualTo(true);
        isGood = inputView.validateMoving("D");
        assertThat(isGood).isEqualTo(true);
    }
    @DisplayName("이동할 칸의 입력이 잘못된 경우")
    @Test
    void wrongMovingInput() {
        assertThatThrownBy(() -> inputView.validateMoving("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.validateMoving("ABCD"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부의 입력이 정상인 경우 (R,Q)")
    @Test
    void goodCommandInput() {
        boolean isGood = inputView.validateCommand("R");
        assertThat(isGood).isEqualTo(true);
        isGood = inputView.validateCommand("Q");
        assertThat(isGood).isEqualTo(true);
    }
    @DisplayName("재시도 여부의 입력이 잘못된 경우")
    @Test
    void wrongCommandInput() {
        assertThatThrownBy(() -> inputView.validateCommand("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.validateCommand("ABCD"))
                .isInstanceOf(IllegalArgumentException.class);
    }





}
