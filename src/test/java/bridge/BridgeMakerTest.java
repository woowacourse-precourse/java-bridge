package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    static BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeAll() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("기본 기능 확인")
    @Test
    void makeBridge테스트_기능() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).hasSize(5);
        System.out.println(bridge.toString());
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(
                () -> bridgeMaker.makeBridge(-3))
                .isInstanceOf(RuntimeException.class
                );

    }

    @Test
    void 큰수_입력() {
        assertThatThrownBy(
                () -> bridgeMaker.makeBridge(21))
                .isInstanceOf(RuntimeException.class
                );

    }

    @Test
    void 영_입력() {
        assertThatThrownBy(
                () -> bridgeMaker.makeBridge(0))
                .isInstanceOf(IllegalArgumentException.class
                );
    }
}