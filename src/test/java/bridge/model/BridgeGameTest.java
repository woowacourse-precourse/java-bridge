package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class BridgeGameTest extends NsTest{
    private static final int UP_DOWN_MODE = 1;
    private static final int RETRY_MODE = 2;

    @DisplayName("U, D, R, Q 에 대한 적절한 예외 처리를 할 수 있는가 - U,D 케이스")
    @ValueSource(strings = {"R", "Q", "UU", "UD", "", "DU", "u", "d", "1"})
    @ParameterizedTest
    void checkBridgeGameExceptionUD(String input ) {
        assertThatThrownBy(()-> BridgeGame.from(input, UP_DOWN_MODE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U, D, R, Q 에 대한 적절한 예외 처리를 할 수 있는가 - R,Q 케이스")
    @ValueSource(strings = {"U", "D", "RR", "RQ", "", "QR", "q", "r", "1"})
    @ParameterizedTest
    void checkBridgeGameExceptionRQ(String input ) {
        assertThatThrownBy(()-> BridgeGame.from(input, RETRY_MODE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}