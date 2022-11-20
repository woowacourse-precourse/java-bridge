package bridge.validation;

import bridge.validation.enumeration.Mode;
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

    @ParameterizedTest
    @ValueSource(strings = {"", "u", "d", "123", "****", "1qwer"})
    void 유효하지_않은_이동할칸(String upOrDown){
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    Validation.verifyUserInputIsCharacter(upOrDown, Mode.UpOrDown);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "u", "d", "123", "****", "1qwer", "U", "D", "q", "r"})
    void 유효하지_않은_재시작_혹은_종료_입력(String retryOrQuit){
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    Validation.verifyUserInputIsCharacter(retryOrQuit, Mode.RetryOrQuit);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}