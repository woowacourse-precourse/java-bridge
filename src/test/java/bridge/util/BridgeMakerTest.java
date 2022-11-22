package bridge.util;

import bridge.BridgeMaker;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void makeBridge_minSize_true() {
        int size = 3;
        String pattern = "^[UD]{1}$";

        List<String> expect = List.of("U","D","U");
        List<String> real = bridgeMaker.makeBridge(size);

        assertThat(real.size())
                .as("size와 동일한 길이의 다리인지 테스트")
                .isEqualTo(expect.size());
        assertThat(real.stream().allMatch(value -> Pattern.matches(pattern,value)))
                .as("U와 D로만 이루어져 있는지 테스트")
                .isTrue();
    }
}