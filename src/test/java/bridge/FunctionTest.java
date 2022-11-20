package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;
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
    class GenerateBridge {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        @ParameterizedTest
        @DisplayName("다리의 길이가 입력받은 숫자와 같은지 확인")
        @ValueSource(ints = {3, 9, 15})
        void isBridgeLengthSame(int length) {
            Assertions.assertThat(bridgeMaker.makeBridge(length).size()).isEqualTo(length);
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
}
