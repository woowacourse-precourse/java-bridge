package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 모든 칸을 성공적으로 통과한다")
    void runAttemptTest_1() {
        String input = makeConsoleInput("UDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(6);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 두 개 칸을 통과하고 세 번째 칸에서 실패한다")
    void runAttemptTest_2() {
        String input = makeConsoleInput("UDDDDD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(2);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 다섯 개 칸을 통과하고 여섯 번째 칸에서 실패한다")
    void runAttemptTest_3() {
        String input = makeConsoleInput("UDUDUU");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(5);
    }

    @Test
    @DisplayName("칸별 이동 성공 여부 테스트: 아무 칸도 통과하지 못 하고 첫 번째 칸에서 실패한다")
    void runAttemptTest_4() {
        String input = makeConsoleInput("DDUDUD");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(BridgeGame.getBridgeGame().runAttempt(getBridge(), new ArrayList<>())).isEqualTo(0);
    }

    private List<String> getBridge() {
        List<String> bridge = new ArrayList<>();
        String[] correctMoves = new String[]{"U", "D", "U", "D", "U", "D"};
        Collections.addAll(bridge, correctMoves);
        return bridge;
    }

    private String makeConsoleInput(String bareInput) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bareInput.length(); i++) {
            stringBuilder.append(bareInput.charAt(i)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
