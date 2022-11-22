package bridge.domain;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("다리의 길이가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBridgeByNotNumber() {
        InputStream in = generateUserInput("size");
        System.setIn(in);

        assertThatThrownBy(InputView::readBridgeSize)
                .hasMessageContaining("[ERROR] 다리의 길이에 대한 입력이 잘못되었습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 20보다 크면 예외가 발생한다.")
    @Test
    void createBridgeByOverRange() {
        InputStream in = generateUserInput("21");
        System.setIn(in);

        assertThatThrownBy(InputView::readBridgeSize)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3보다 작으면 예외가 발생한다.")
    @Test
    void createBridgeByLowerRange() {
        InputStream in = generateUserInput("1");
        System.setIn(in);

        assertThatThrownBy(InputView::readBridgeSize)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}