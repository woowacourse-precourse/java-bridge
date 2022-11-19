package bridge;

import bridge.domain.BridgeLocation;
import bridge.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @DisplayName("현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력")
    @Test
    void printMap() {
        String result = "[ O | X ]\n[   |   ]";
        assertThat(outputView.printMap(List.of(BridgeLocation.UP_TRUE, BridgeLocation.UP_FALSE))).isEqualTo(result);
    }

    @DisplayName("게임의 최종 결과를 정해진 형식에 맞춰 출력")
    @Test
    void printResult() {
        String result = "\n최종 게임 결과\n[ O |   |   ]\n[   | O | O ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 2";
        List<BridgeLocation> bridgeLocations = List
                .of(BridgeLocation.UP_TRUE, BridgeLocation.DOWN_TRUE, BridgeLocation.DOWN_TRUE);
        assertThat(outputView.printResult(bridgeLocations, 2)).isEqualTo(result);
    }

}
