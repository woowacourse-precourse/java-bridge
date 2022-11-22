package bridge.exception;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeHandlerTest {

    @DisplayName("다리 생성 - 다리에 U, D 외 다른 문자가 있을 경우, 예외가 발생한다.")
    @Test
    void handleNotOnlyUOrDExceptionTest() {
        TotalExceptionHandler notOnlyUOrDHandler = overrideToNotOnlyUOrDException();

        List<String> notOnlyUD = new ArrayList<>(List.of("U", "A", "D"));

        ExceptionTestHelper.testIllegalStateException(notOnlyUOrDHandler, notOnlyUD);
    }

    TotalExceptionHandler overrideToNotOnlyUOrDException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(List<String> input) {
                BridgeExceptionHandler.handleNotOnlyUOrDException(input);
            }
        };
    }

    @DisplayName("건너기 가능 여부 확인, 다리 길이 반환 - 다리가 아직 생성되지 않았을 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(booleans = {false})
    void handleBridgeNotCreatedExceptionTest(boolean bridgeCreated) {
        TotalExceptionHandler bridgeNotCreatedHandler = overrideToBridgeNotCreatedException();

        ExceptionTestHelper.testIllegalStateException(bridgeNotCreatedHandler, bridgeCreated);
    }

    TotalExceptionHandler overrideToBridgeNotCreatedException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(boolean input) {
                BridgeExceptionHandler.handleBridgeNotCreatedException(input);
            }
        };
    }

    @DisplayName("건너기 가능 여부 확인 - 마지막 인덱스보다 큰 값이나 0보다 작은 값이 전달될 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void handleCheckSpaceOutOfRangeExceptionTest(int space) {
        TotalExceptionHandler checkOutOfRangeHandler = overrideToCheckSpaceOutOfRangeException();

        ExceptionTestHelper.testIllegalStateException(checkOutOfRangeHandler, space);
    }

    TotalExceptionHandler overrideToCheckSpaceOutOfRangeException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(int input) {
                BridgeExceptionHandler.handleCheckSpaceOutOfRangeException(input);
            }
        };
    }
}
