package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeLengthTest extends NsTest {

    @DisplayName("사용자의 입력이 숫자 범위가 맞는가 - 범위를 만족하지 않는 다리 길이 입력")
    @ValueSource(ints = {2,25,0,21,1, -3})
    @ParameterizedTest
    void checkBriValueSourcedgeLengthException1(int input) {
        assertThatThrownBy(() -> BridgeLength.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 입력값과 같은 값을 GetLength가 리턴해 주는가?")
    @ValueSource(ints = {3,4,5,6,7,8,9,10,18,19,20})
    @ParameterizedTest
    void checkBriValueSourcedgeLengthException2(int input) {
        BridgeLength bridgeLength = BridgeLength.from(input);
        Assertions.assertThat(bridgeLength.getLength()).isEqualTo(input);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}