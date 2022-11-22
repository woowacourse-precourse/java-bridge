package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import bridge.enums.BridgeRange;
import bridge.enums.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 다리_길이_문자일시(String str) {
        assertSimpleTest(() -> {
            runException(str);
            assertThat(output()).contains(ErrorMessage.getMessage("INVALID_BRIDGE_SIZE"));
        });
    }

    @Test
    void 다리_길이_음의정수() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ErrorMessage.getMessage("INVALID_BRIDGE_SIZE"));
        });
    }

    @Test
    void 다리_길이_범위밖_양의정수() {
        assertSimpleTest(() -> {
            runException(String.valueOf(BridgeRange.getMaxValue() + 1));
            assertThat(output()).contains(ErrorMessage.getMessage("OUT_OF_RANGE_BRIDGE_SIZE"));
        });
    }

    @Test
    void 다리_길이_범위안_양의정수() {
        assertSimpleTest(() -> {
            runException(String.valueOf(BridgeRange.getMaxValue()));
            assertThat(output()).contains("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        });
    }

    @Test
    void 잘못된_칸() {
        assertSimpleTest(() -> {
            runException(String.valueOf(BridgeRange.getMaxValue()), "R");
            assertThat(output()).contains(ErrorMessage.getMessage("INVALID_MOVING"));
        });
    }

    @Test
    void 올바른_칸() {
        assertSimpleTest(() -> {
            runException(String.valueOf(BridgeRange.getMaxValue()), "U");
            assertThat(output()).contains("[   ]");
        });
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
