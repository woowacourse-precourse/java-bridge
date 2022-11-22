package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.models.BridgeBluePrint;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeSizeTest extends NsTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @ValueSource(strings = {"999", "0", "-123"})
    @ParameterizedTest
    void 범위_밖의_값_model(Integer input) {
        assertThatThrownBy(() -> new BridgeBluePrint(input))
                .isInstanceOf(IllegalStateException.class);
    }

    @ValueSource(strings = {"3j", "aaa", "a10"})
    @ParameterizedTest
    void 숫자가_아닌_값_view(String str) {
        System.setIn(new ByteArrayInputStream(str.getBytes()));
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_밖의_값_controller() {
        assertSimpleTest(() -> {
            runException("1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 숫자가_아닌_값_controller() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
