package bridge.bridge;

import bridge.BridgeMaker;
import bridge.controller.GameController;
import bridge.utill.TestBridgeGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class RetryTest extends NsTest {
    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of("3", "U", "D", "R", "U", "U", "U"),
                        List.of("[ O | O | O ]", "[   |   |   ]",
                                "최종 게임 결과", "게임 성공 여부: 성공", "총 시도한 횟수: 2")),
                Arguments.of(List.of("3", "U", "D", "Q"), List.of("[ O |   ]", "[   | X ]",
                        "최종 게임 결과", "게임 성공 여부: 실패", "총 시도한 횟수: 1")),
                Arguments.of(List.of("3", "U", "U", "U"), List.of("[ O | O | O ]", "[   |   |   ]",
                        "최종 게임 결과", "게임 성공 여부: 성공", "총 시도한 횟수: 1"))
        );
    }

    public static void main(String[] args) {
        TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator(List.of(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(testBridgeGenerator);
        GameController gameController = new GameController(bridgeMaker, new InputView(), new OutputView());

        gameController.start();
    }

    @DisplayName("재시작 테스트")
    @ParameterizedTest
    @MethodSource("testCases")
    public void retryTest(List<String> command, List<String> output) {
        assertSimpleTest(() -> {
            run(command.toArray(new String[0]));
            Assertions.assertThat(output()).contains(output);
        });
    }

    @Override
    protected void runMain() {
        main(new String[]{});
    }
}
