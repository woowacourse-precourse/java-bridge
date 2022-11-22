package bridge.view;

import bridge.BridgeMaker;
import bridge.model.BridgeGame;
import bridge.utill.TestBridgeGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {
    OutputView outputView = new OutputView();

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 0, 1, 0), List.of("D", "U", "D", "D"),
                        List.of("[   | O |   |   ]", "[ O |   | O | X ]")),
                Arguments.of(List.of(0, 1, 0, 1, 0), List.of("D", "D"),
                        List.of("[   |   ]", "[ O | X ]"))
        );
    }

    public BridgeGame makeBridge(List<Integer> bridgeInfo) {
        TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator(bridgeInfo);
        BridgeMaker bridgeMaker = new BridgeMaker(testBridgeGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeInfo.size());

        return new BridgeGame(bridge);
    }

    @DisplayName("이동 결과 테스트")
    @MethodSource("testCases")
    @ParameterizedTest()
    public void printMove(List<Integer> bridgeInfo, List<String> directions, List<String> output) {
        assertSimpleTest(() -> {
            BridgeGame game = makeBridge(bridgeInfo);
            for (String direction : directions)
                game.move(direction);
            outputView.printMap(game);
            assertThat(output()).contains(output);
        });
    }

    @Override
    protected void runMain() {
    }
}