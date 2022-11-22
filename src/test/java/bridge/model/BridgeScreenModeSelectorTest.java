package bridge.model;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeScreenModeSelectorTest extends NsTest {

    @DisplayName("출력물 generator selector에 잘못된 인자가 들어갔을 때 올바른 예외를 발생시키는가? - printCase가 이상한 경우")
    @ValueSource(ints = {5, -3, 0, 4})
    @ParameterizedTest
    void checkScreenModeSelectorException1() {
        List<String> tmp = null;
        Assertions.assertThat(new BridgeScreenModeSelector(tmp, 3, 5).generateOutputScreen()).isEqualTo(null);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}