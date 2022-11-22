package bridge;

import bridge.vallidation.BridgeValidation;
import bridge.vallidation.InputViewValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.ErrorConstant.ERROR_NOT_VALID_LOCATION;
import static bridge.constant.ErrorConstant.ERROR_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BridgeValidationTest {
    @DisplayName("예외 처리 : 유저의 위치가 다리의 길이에 대해서 유요한지 검증")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7, -1})
    void checkRangeOfBridgeSize(int userLocation) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeValidation.isValidUserLocation(userLocation,3))
                .withMessageStartingWith(ERROR_NOT_VALID_LOCATION);
    }
}
