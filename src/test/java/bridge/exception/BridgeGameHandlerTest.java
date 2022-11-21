package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameHandlerTest {

    @DisplayName("이동 기능 - space 파라미터 값이 3~20 사이가 아닐 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void handleMoveSpaceOutOfRangeExceptionTest(int space) {
        TotalExceptionHandler moveOutOfRangeHandler = overrideToMoveSpaceOutOfRangeException();

        ExceptionTestHelper.testIllegalStateException(moveOutOfRangeHandler, space);
    }

    TotalExceptionHandler overrideToMoveSpaceOutOfRangeException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(int input) {
                BridgeGameExceptionHandler.handleMoveSpaceOutOfRangeException(input);
            }
        };
    }
}
