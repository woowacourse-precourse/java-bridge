package bridge;

import bridge.BridgeDraw;
import game.BridgeGame;
import game.BridgeGameController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.Valid;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest {

    @Nested
    class BridgeLength {
        @ParameterizedTest
        @DisplayName("다리 길이가 숫자가 아니거나, 공백이거나, 지정된 범위를 넘으면 예외가 발생")
        @ValueSource(strings = {"ab","", "90"})
        void isLengthValid(String size) {
            assertThatThrownBy(() ->
                    Valid.isLengthValid(size))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("[ERROR] 다리 길이는 3~20 중 하나인 숫자입니다.");
        }
    }

    @Nested
    class BridgeGenerate {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        @ParameterizedTest
        @DisplayName("다리의 길이가 입력받은 숫자와 같은지 확인")
        @ValueSource(ints = {3, 9, 15})
        void isBridgeLengthSame(int length) {
            Assertions.assertThat(bridgeMaker.makeBridge(length).size()).isEqualTo(length);
        }

        @ParameterizedTest
        @DisplayName("정답 다리가 U, D만 가지는지 확인")
        @ValueSource(ints = {0,1,2,3,4})
        void isBridgeHasOnlyUAndD(int index) {
            List<String> answerBridge = bridgeMaker.makeBridge(5);
            Assertions.assertThat(Arrays.asList("U", "D").contains(answerBridge.get(index))).isEqualTo(true);
        }
    }

    @Nested
    class BridgeMoving {
        @ParameterizedTest
        @DisplayName("입력받은 문자가 U, D 중 하나와 일치하지 않는 경우 예외가 발생")
        @ValueSource(strings = {"1","L", "UU"})
        void isEnterValid(String moving) {
            assertThatThrownBy(() ->
                    Valid.isEnterValid(moving))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 입력시 U, D 중 하나를 입력해주세요.");
        }
    }

    @Nested
    class BridgeGameFinish {
        @ParameterizedTest
        @DisplayName("입력받은 문자가 R, Q 중 하나와 일치하지 않는 경우 예외가 발생")
        @ValueSource(strings = {"90","L", "RR"})
        void isEnterValid(String finish) {
            assertThatThrownBy(() ->
                    Valid.isEnterFinishValid(finish))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 입력시 Q, R 중 하나를 입력해주세요.");
        }
    }

    @Nested
    class BridgeDraw {
        bridge.BridgeDraw bridgeDraw = new bridge.BridgeDraw();
        @Test
        @DisplayName("사용자의 입력과 정답이 일치할 때 O 표시")
        void isSameWithResult() {
            List<String> answer = new ArrayList<>(Arrays.asList(" O "));
            bridgeDraw.saveSuccessMoving("U");
            Assertions.assertThat(bridgeDraw.getUpMap()).isEqualTo(answer);
        }

        @Test
        @DisplayName("사용자의 입력과 정답이 다를 때 X 표시")
        void isDifferentWithResult() {
            List<String> answer = new ArrayList<>(Arrays.asList(" X "));

            bridgeDraw.saveFailMoving("D");
            Assertions.assertThat(bridgeDraw.getDownMap()).isEqualTo(answer);
        }
    }

    @Nested
    class BridgeGameMethod {
        int size = 4;
        BridgeGame bridgeGame = new BridgeGame(4);
        @Test
        @DisplayName("재시작이 잘 적용되는지 확인")
        void CountRestart() {
            for(int i = 0; i < 5; i++) {
                bridgeGame.retry();
            }
            Assertions.assertThat(bridgeGame.getCountRestart()).isEqualTo(6);
            Assertions.assertThat(bridgeGame.getBridgeCursor()).isEqualTo(0);
        }

        @Test
        @DisplayName("정답 다리의 마지막 인덱스까지 잘 움직이나 확인")
        void moveCursor() {
            for(int i = 0; i < 5; i++) {
                bridgeGame.move();
            }
            Assertions.assertThat(bridgeGame.getBridgeCursor()).isEqualTo(3);
        }
    }
}
