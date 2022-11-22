package bridge;

import static bridge.BridgeGame.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.Constant.*;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    @DisplayName("다리 길이가 3이고 정답만 입력했을 때 다리 이동 테스트")
    @Test
    void 정답만_입력시_이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame();

        List<String> bridge = asList(UP, DOWN, DOWN);
        List<String> inputList = asList(UP, DOWN, DOWN);

        for(int input = 0; input<inputList.size(); input++) {
            bridgeGame.move(inputList.get(input), bridge, input+1);
            System.out.println(inputList.get(input));
        }

        List<String> testResultUpstairsBridge = asList(RIGHT, SPACE_BRIDGE, SPACE_BRIDGE);
        List<String> testResultDownstairsBridge = asList(SPACE_BRIDGE, RIGHT, RIGHT);

        assertThat(upstairsBridge).isEqualTo(testResultUpstairsBridge);
        assertThat(downstairsBridge).isEqualTo(testResultDownstairsBridge);

        upstairsBridge.clear();
        downstairsBridge.clear();
    }

    @DisplayName("다리 길이가 4이고 세번째 시도에서 오답했을 때 다리 이동 테스트")
    @Test
    void 오답_입력시_이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame();

        List<String> bridge = asList(UP, DOWN, DOWN, DOWN);
        List<String> inputList = asList(UP, DOWN, UP);

        for(int input = 0; input<inputList.size(); input++) {
            bridgeGame.move(inputList.get(input), bridge, input+1);
        }

        List<String> testResultUpstairsBridge = asList(RIGHT, SPACE_BRIDGE, WRONG);
        List<String> testResultDownstairsBridge = asList(SPACE_BRIDGE, RIGHT, SPACE_BRIDGE);

        assertThat(upstairsBridge).isEqualTo(testResultUpstairsBridge);
        assertThat(downstairsBridge).isEqualTo(testResultDownstairsBridge);

        upstairsBridge.clear();
        downstairsBridge.clear();
    }
}