package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("다리의 개수를 숫자로 입력하지 않으면 오류가 발생한다")
    @Test
    void enterNotNumberBridgeSize() {
        String input = "사다리개수";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> bridgeGame.enterNumberOfBridge())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자로 입력해 주세요.");
    }

    @DisplayName("다리의 개수가 3이상 20이하의 숫자가 아니면 오류가 발생한다.")
    @Test
    void enterInvalidRangeBridgeSize() {
        String input = "30";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> bridgeGame.enterNumberOfBridge())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

}
