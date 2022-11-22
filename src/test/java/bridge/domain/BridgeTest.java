package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {
    @DisplayName("다리 길이가 3보다 작으면 예외가 발생한다.")
    @Test
    void inputLengthByUnderRange() {
        assertThatThrownBy(() -> new Bridge(2, new BridgeMaker(new BridgeRandomNumberGenerator())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
