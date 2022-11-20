package bridge.view;

import bridge.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {

    @Test
    void printMapTest() {
        List<String> bridge = List.of("U", "D", "D", "U");
        List<String> player = List.of("U", "D", "U");
        new OutputView().printMap(bridge, player);
        assertThat(output()).contains(
                "[ O |   | X ]",
                "[   | O |   ]"
        );
    }

    @Test
    void printResultTest_성공() {
        List<String> bridge = List.of("U", "D", "D", "U");
        List<String> player = List.of("U", "D", "D", "U");
        new OutputView().printResult(bridge, player, 3);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   | O ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
        );
    }

    @Test
    void printResultTest_실패() {
        List<String> bridge = List.of("U", "D", "D", "U");
        List<String> player = List.of("U", "D", "U");
        new OutputView().printResult(bridge, player, 3);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 3"
        );
    }

    @Override
    protected void runMain() {
    }
}