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

    @DisplayName("Bridge Size _ 음수")
    @Test
    void readBridgeSize_NotInTheRightRange_Negative() {
        assertSimpleTest(() -> {
            runException("-4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ 0")
    @Test
    void readBridgeSize_NotInTheRightRange_Zero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Bridge Size _ 20보다 큰 수")
    @Test
    void readBridgeSize_NotInTheRightRange_OutOfBounds() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Moving _ 소문자 u 입력")
    @Test
    void readMoving_smallU() {
        assertSimpleTest(() -> {
            runException("3", "u");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Moving _ 소문자 d 입력")
    @Test
    void readMoving_smallD() {
        assertSimpleTest(() -> {
            runException("3", "d");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Moving _ 숫자 입력")
    @Test
    void readMoving_NUMBER() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("Moving _ 개행 입력")
    @Test
    void readMoving_TAB() {
        assertSimpleTest(() -> {
            runException("3", "\t");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("GameCommend _ 소문자 R 입력")
    @Test
    void readGameCommend_smallR() {
        assertSimpleTest(() -> {
            runException("3", "r");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("GameCommend _ 소문자 Q 입력")
    @Test
    void readGameCommend_smallQ() {
        assertSimpleTest(() -> {
            runException("3", "q");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("GameCommend _ 숫자 입력")
    @Test
    void readGameCommend_NUMBER() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("GameCommend _ 개행 입력")
    @Test
    void readGameCommend_TAB() {
        assertSimpleTest(() -> {
            runException("3", "\t");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
