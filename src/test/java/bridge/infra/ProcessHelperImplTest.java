package bridge.infra;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.ProcessHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThat(processHelper.canItChangeBridgeSize(givenString)).isTrue();
    }

    @Test
    public void isNotDigitStringTest() throws Exception {
        String givenString = "1000j";
        assertThat(processHelper.canItChangeBridgeSize(givenString)).isFalse();
    }

}
