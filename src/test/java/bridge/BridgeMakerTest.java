package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리의 길이가 정수가 아니라면 예외가 발생한다.")
    @Test
    void makeBridgeByNotInteger() {
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate("a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate(" ")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate("hello world1")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이가 3이상 20이하의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void makeBridgeByExtraRange() {
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate("1")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate("21")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMakerValidate("0")).isInstanceOf(IllegalArgumentException.class);
    }
}
