package bridge.model.ScreenGenerator;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeEachRowGeneratorTest extends NsTest {

    private static final int SELECT_FIRST = 1;
    private static final int SELECT_SECOND = 0;

    @DisplayName("정답배열에 대해 올바른 리스트를 반환할 수 있는가")
    @Test
    void checkBridgeRowGeneratorCheck() {
        List<String> answer = List.of("U", "D", "U", "U", "D");
        int current = 3;
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current);
        Assertions.assertThat(bridgeEachRowGenerator.generateRowInList(SELECT_FIRST))
            .isEqualTo(List.of(" O ", "   ", " O ", " O "));
        Assertions.assertThat(bridgeEachRowGenerator.generateRowInList(SELECT_SECOND))
            .isEqualTo(List.of("   ", " O ", "   ", "   "));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}