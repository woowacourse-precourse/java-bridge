package bridge;

import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeResult;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class FeatureTest extends NsTest {

    private static final OutputView outputView = new OutputView();

    List<String> bridgeGenerateTest(List<Integer> numbers){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(numbers));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(numbers.size());
    }

    //region 다리생성 단위 테스트 케이스
    @Test
    void 다리_생성_테스트() {
        List<String> bridge = bridgeGenerateTest(List.of(1, 0, 0));
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_길이30() {
        List<String> bridge = bridgeGenerateTest(List.of(
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0));
        assertThat(bridge).containsExactly(
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D");
    }
    //endregion

    void isCrossableBridge(List<String> _bridge, int index, String command, String expected){
        Bridge bridge = new Bridge(_bridge);
        String result = bridge.movingResult(index, command);
        assertThat(result).isEqualTo(expected);
    }

    //region 다리이동 가능여부 단위 테스트 케이스
    @Test
    void 다리이동가능여부_기능테스트_O(){
        isCrossableBridge(List.of("U", "D", "U"), 0, "U", "O");
    }

    @Test
    void 다리이동가능여부_기능테스트_X(){
        isCrossableBridge(List.of("U", "D", "U"), 1, "U", "X");
    }
    //endregion

    void crossingBridgeTest(List<String> _bridge, String command, String result){
        Bridge bridge = new Bridge(_bridge);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(command, result);
        outputView.printMap(bridgeGame.getBridgeResult());
    }

    void crossingBridgeTest(
            List<String> _bridge,
            LinkedList<String> upperBridge,
            LinkedList<String> lowerBridge,
            String command, String result
    ){
        Bridge bridge = new Bridge(_bridge);
        BridgeGame bridgeGame = new BridgeGame(upperBridge, lowerBridge);
        bridgeGame.move(command, result);
        outputView.printMap(bridgeGame.getBridgeResult());
    }

    //region 다리이동결과 단위 테스트 케이스
    @Test
    void 다리이동결과출력_기능테스트_성공(){
        crossingBridgeTest(List.of("U", "D", "U"), "U", "O");
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }
    @Test
    void 다리이동결과출력_기능테스트_실패1(){
        crossingBridgeTest(
                List.of("U", "D", "U"),
                new LinkedList<>(List.of("O")),
                new LinkedList<>(List.of(" ")),
                "U", "X"
        );
        assertThat(output()).contains(
                "[ O | X ]",
                "[   |   ]"
        );
    }

    @Test
    void 다리이동결과출력_기능테스트_실패2(){
        crossingBridgeTest(
                List.of("U", "D", "U", "U", "D"),
                new LinkedList<>(List.of("O", " ", "O")),
                new LinkedList<>(List.of(" ", "O", " ")),
                "D", "X"
        );
        assertThat(output()).contains(
                "[ O |   | O |   ]",
                "[   | O |   | X ]"
        );
    }

    @Test
    void 다리이동결과출력_기능테스트_실패3(){
        crossingBridgeTest(
                List.of("U", "D", "U", "U", "D"),
                new LinkedList<>(List.of("O", " ")),
                new LinkedList<>(List.of(" ", "O")),
                "D", "X"
        );
        assertThat(output()).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
        );
    }
    //endregion

    void initializeWhenRestartTest(LinkedList<String> upperBridge, LinkedList<String> lowerBridge){
        BridgeGame bridgeGame = new BridgeGame(upperBridge, lowerBridge);
        bridgeGame.retry();
        bridgeGame.move("U", "O");
        outputView.printMap(bridgeGame.getBridgeResult());
    }

    //region 재시작 시 초기화 단위 테스트 케이스
    @Test
    void 재시작시초기화_기능테스트(){
        initializeWhenRestartTest(new LinkedList<>(List.of("O", " ")), new LinkedList<>(List.of(" ", "X")));
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }
    //endregion

    //region 최종 결과 출력 단위 테스트 케이스
    @Test
    void 최종결과출력_기능테스트(){
        BridgeGame bridgeGame = new BridgeGame(
                new LinkedList<>(List.of("O", " ", "O")),
                new LinkedList<>(List.of(" ", "O", " "))
        );
        outputView.printResult(bridgeGame.getBridgeResult(), "성공", 3);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
        );
        int upSideIndex = output().indexOf("[ O |   | O ]");
        int downSideIndex = output().indexOf("[   | O |   ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }
    //endregion

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
