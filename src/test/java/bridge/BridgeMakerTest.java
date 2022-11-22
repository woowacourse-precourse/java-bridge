package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker bm;

    @BeforeEach
    void beforeEach() throws Exception {
        BridgeRandomNumberGenerator bg = new BridgeRandomNumberGenerator();
        bm = new BridgeMaker(bg);
    }

    @DisplayName("정상적인 숫자 입력")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 30, 100})
    @ParameterizedTest
    void makeBridge(int n) {
        List<String> bridge = bm.makeBridge(n);
        System.out.println(bridge.toString());
        assertThat(bridge.size()).isEqualTo(n);
    }

    @DisplayName("비정상적인 숫자 입력")
    @ValueSource(ints = {0, -1, -100, -200, -300})
    @ParameterizedTest
    void makeBridgeIgnore(int n) {
        assertThrows(IllegalArgumentException.class, () -> {
            List<String> bridge = bm.makeBridge(n);
            System.out.println(bridge.toString());
            assertThat(bridge.size()).isEqualTo(n);
        });

    }
}