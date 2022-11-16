package bridge.view;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    @Test
    @DisplayName("현재까지 이동한 다리의 상태를 출력한다.")
    void 현재까지_이동한_다리의_상태를_출력한다() {
        // given
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // when
        int[] accessibleSpots = {1, 0, 0};
        List<String> bridge = bridgeMaker.makeBridge(accessibleSpots);

        // then
        Map<String, List<String>> firstCorrect = Map.of("upper", Arrays.asList("O"), "lower", Arrays.asList(" "));
        Map<String, List<String>> secondCorrect = Map.of("upper", Arrays.asList("O", "X"), "lower", Arrays.asList(" ", " "));
        Map<String, List<String>> secondWrong = Map.of("upper", Arrays.asList("O", " "), "lower", Arrays.asList(" ", "O"));
        Map<String, List<String>> thirdCorrect = Map.of("upper", Arrays.asList("O", " ", " "), "lower", Arrays.asList(" ", "O", "O"));
        Map<String, List<String>> temp = outputView.convertToMap(bridge, 1, true);

        assertThat(outputView.convertToMap(bridge, 0, true)).isEqualTo(firstCorrect);
        assertThat(outputView.convertToMap(bridge, 1, false)).isEqualTo(secondCorrect);
        assertThat(outputView.convertToMap(bridge, 1, true)).isEqualTo(secondWrong);
        assertThat(outputView.convertToMap(bridge, 2, true)).isEqualTo(thirdCorrect);
    }
}
