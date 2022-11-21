package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("잘못된 다리길이 입력 테스트")
    @ValueSource(strings = {"-1", "sdg", "30"})
    @ParameterizedTest
    void 다리_길이입력_테스트(String str) {
        assertSimpleTest(() -> {
            InputView.bridgeSizeErrorHandling(str);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
