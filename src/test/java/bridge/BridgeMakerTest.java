package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리를 만드는것을 확인한다.")
    @Test
    void testMakeBridge() {
        int bridgeSize = 5;
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(bridge.stream().allMatch(s -> s.matches("^[UD]{1}$"))).isTrue();
    }

    @DisplayName("1이면 U, 0이면 D를 출력한다.")
    @ParameterizedTest
    @CsvSource({"1,U", "0,D"})
    void testSettingValue(int randomNum, String expected) {
        assertThat(bridgeMaker.settingValue(randomNum)).isEqualTo(expected);
    }

    @DisplayName("랜덤숫자가 범위 안에 없을시 예외를 발생시킨다.")
    @Test
    void testSettingValue() {
        assertThatThrownBy(() -> {
            bridgeMaker.settingValue(2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}