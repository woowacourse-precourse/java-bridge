package bridge.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.ProcessHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProcessHelperImplTest {

    ProcessHelper processHelper = null;

    @BeforeEach
    void setUp() {
        processHelper = new ProcessHelperImpl();
    }

    @DisplayName("입력한 문자열이 숫자면 true 반환")
    @Test
    public void isDigitStringTest() throws Exception {
        processHelper = new ProcessHelperImpl();
        String givenString = "123";
        assertThat(processHelper.checkBridgeSize(givenString)).isTrue();
    }

    @Test
    public void isNotDigitStringTest() throws Exception {
        String givenString = "1000j";
        assertThat(processHelper.checkBridgeSize(givenString)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"D", "U"})
    public void readMovingCorrectTest(String givenString) throws Exception {
        assertThat(processHelper.checkCharIsUOrD(givenString)).isTrue();
    }

    @Test
    public void readMovingIncorrectTest() throws Exception {
        assertThat(processHelper.checkCharIsUOrD("A")).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    public void gameCommandCorrectTest(String givenString) throws Exception {
        assertThat(processHelper.checkCharIsROrQ(givenString)).isTrue();
    }

    @Test
    public void gameCommandIncorrectTest() throws Exception {
        assertThat(processHelper.checkCharIsUOrD("A")).isFalse();
    }

}
