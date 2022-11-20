package bridge.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ValidationTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"", "123z", "zdzd", "a*a*1", "1", "2", "21", "50"})
    void 다리길이_유효하지_않은_입력(String bridgeLength) {
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    Validation.verifyUserInputBridgeLength(bridgeLength);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }

}