package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void setUP() {
        List<String> upBridge = List.of("O", " ");
        List<String> downBridge = List.of(" ", "X");
        bridgeGame.getUpBridge().addAll(upBridge);
        bridgeGame.getDownBridge().addAll(downBridge);
    }

    @DisplayName("현재까지 이동한 다리의 상태 출력 테스트")
    @Test
    void printMapTest() {
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge(), 1);
        assertThat(out.toString()).contains(
                "[ O |   ]",
                "[   | X ]"
        );
    }

    @DisplayName("게임의 최종 결과 출력 테스트")
    @Test
    void printResultTest() {
        OutputView outputView = new OutputView();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printResult("X", 2, bridgeGame);
        assertThat(out.toString()).contains(
                "최종 게임 결과",
                "[ O |   ]",
                "[   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2");
    }
}