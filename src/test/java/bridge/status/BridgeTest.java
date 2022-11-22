package bridge.status;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10", "20"})
    void 입력값이_다리_범위_안이라면_true_리턴(String size) {
        boolean result = Bridge.isInRange(size);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "22", "23"})
    void 입력값이_다리_범위_밖이라면_false_리턴(String size) {
        boolean result = Bridge.isInRange(size);

        assertThat(result).isFalse();
    }

    @Test
    void 비교값이_일치하다면_true_리턴() {
        boolean result = Bridge.isAvailable("U", "U");

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 21, 22, 23})
    void 비교값이_다르다면_false_리턴(int size) {
        boolean result = Bridge.isAvailable("U", "D");

        assertThat(result).isFalse();
    }

}

