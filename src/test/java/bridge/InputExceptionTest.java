package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.InputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputExceptionTest extends NsTest {

    @DisplayName("다리 길이 공백 입력 테스트")
    @ValueSource(strings = {" ", "\n"})
    @ParameterizedTest
    void createBlankBridgeSize(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(InputException.BLANK_BRIDGE_LENGTH.getExceptionMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
