package bridge.bridge;

import bridge.BridgeMaker;
import bridge.controller.GameController;
import bridge.utill.TestBridgeGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class RetryTest extends NsTest {

    public static void main(String[] args) {
        TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator(List.of(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(testBridgeGenerator);
        GameController gameController = new GameController(bridgeMaker, new InputView(), new OutputView());

        gameController.start();
    }

    @Test
    @DisplayName("재시작 테스트")
    public void retryTest() {
        assertSimpleTest(() -> {
            run("3", "U", "D", "R", "U", "U", "U");
            Assertions.assertThat(output()).contains("[ O | O | O ]", "[   |   |   ]");
        });
    }

    @Test
    @DisplayName("종료 테스트")
    public void quitTest() {
        assertSimpleTest(() -> {
            run("3", "U", "D", "Q");
            Assertions.assertThat(output()).contains("[ O |   ]", "[   | X ]");
        });
    }

    @Test
    @DisplayName("재시작 시 최종 결과 테스트")
    public void retryResultTest() {
        assertSimpleTest(() -> {
            run("3", "U", "D", "R", "U", "U", "U");
            Assertions.assertThat(output()).contains("최종 게임 결과",
                    "게임 성공 여부: 성공", "총 시도한 횟수: 2");
        });
    }

    @Test
    @DisplayName("실패 후 종료 테스트")
    public void quitResultTest() {
        assertSimpleTest(() -> {
            run("3", "U", "D", "R", "U", "U", "D", "Q");
            Assertions.assertThat(output()).contains("최종 게임 결과",
                    "게임 성공 여부: 실패", "총 시도한 횟수: 2");
        });
    }

    @Override
    protected void runMain() {
        main(new String[]{});
    }
}
