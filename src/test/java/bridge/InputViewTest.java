package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest extends NsTest {
    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("Bridge Size _ NOT_NUMBER 숫자 + 알파벳")
    @Test
    void readBridgeSize_HaveToAcceptNumbersOnly_NumberLetter() {
        assertSimpleTest(() -> {
            runException("33A");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ 알파벳")
    @Test
    void readBridgeSize_HaveToAcceptNumbersOnly_Letters() {
        assertSimpleTest(() -> {
            runException("wA");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ NOT_NUMBER 숫자 + 알파벳")
    @Test
    void readBridgeSize_NotInTheRightRange_Negative() {
        assertSimpleTest(() -> {
            runException("-4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ NOT_NUMBER 숫자 + 알파벳")
    @Test
    void readBridgeSize_NotInTheRightRange_Zero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ NOT_NUMBER 숫자 + 알파벳")
    @Test
    void readBridgeSize_NotInTheRightRange_OutOfBounds() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
