package bridge;

import static bridge.BridgeGame.*;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static utils.Constant.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
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
    }
}
//
//    @ParameterizedTest
//    @ValueSource(strings = {"A", "B", "u"})
//    void 올바르지_않은_이동_예외_테스트(String input) {
//        //given
//        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
//        //then
//        assertThatThrownBy(() -> bridgeGame.move(input)).
//                isInstanceOf(IllegalArgumentException.class);
//    }
//}
//    @ParameterizedTest
//    @ValueSource(strings = {"A", "B", "u"})
//    void 올바르지_않은_커맨드_예외_테스트(String input) {
//        //given
//        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
//        //then
//        assertThatThrownBy(() -> bridgeGame.retry(input)).
//                isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {50, 51, 52})
//    void 올바르지_않은_커맨드_예외_테스트(int tryNumbers) {
//        //given
//        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
//        //when
//        for (int time = 1; time < tryNumbers; time++) {
//            bridgeGame.retry("R");
//        }
//        //then
//        int tryTimes = bridgeGame.getTryNumber();
//        assertThat(tryTimes).isEqualTo(tryNumbers);
//    }
//
//    @Test
//    void 성공시_다리_출력_테스트() {
//        //given
//        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
//        bridgeGame.move("U");
//        String result = "[ O ]\n[   ]\n";
//        //when
//        String testResult = bridgeGame.toString();
//        //then
//        assertThat(testResult).isEqualTo(result);
//    }
//
//    @Test
//    void 실패시_다리_출력_테스트() {
//        //given
//        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
//        bridgeGame.move("D");
//        String result = "[   ]\n[ X ]\n";
//        //when
//        String testResult = bridgeGame.toString();
//        //then
//        assertThat(testResult).isEqualTo(result);
//    }
//}