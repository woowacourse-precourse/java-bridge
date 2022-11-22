package bridge.domain.code;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RestartCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", " ", "", "#", "1"})
    void 재시작명령어는_Q혹은_R만_입력_가능합니다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RestartCommand.generateCommand(input))
                .withMessageContaining(RestartCommand.ERROR_DID_NOT_FOUND_RESTART_CODE);
    }

}