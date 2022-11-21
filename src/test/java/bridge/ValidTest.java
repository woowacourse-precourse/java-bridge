package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @DisplayName("다리 길이 입력에 유요하지 않은 입력이라면 IlligalArgumentExcpetion 발생")
    @Test
    void validBridgeSize() {
        Valid valid = new Valid();
        assertThatThrownBy(() -> valid.validBridgeSize("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validReadMoving() {
    }

    @Test
    void validReadGameCommand() {
    }
}