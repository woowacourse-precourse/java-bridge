package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.Utils.Verification;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class VerificationTest {

    @ParameterizedTest
    @CsvSource(value = {"U:R", "D:Q"}, delimiter = ':')
    void 다리이동과_재시작여부_정상입력_테스트(String input, String input1) {
        assertThat(Verification.isMoveKey(input)).isTrue();
        assertThat(Verification.isRestartKey(input1)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"u:r", "d:q", "UD:RQ"}, delimiter = ':')
    void 다리이동과_재시작여부_비정상입력_테스트(String input, String input1) {
        assertThat(Verification.isMoveKey(input)).isFalse();
        assertThat(Verification.isRestartKey(input1)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void 다리_사이즈_정상입력_테스트(String input) {
        assertThat(Verification.isBridgeNum(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "d", ""})
    void 다리_사이즈_비정상입력_테스트(String input) {
        assertThat(Verification.isBridgeNum(input)).isFalse();
    }
}
