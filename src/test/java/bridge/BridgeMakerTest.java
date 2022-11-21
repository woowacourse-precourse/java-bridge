package bridge;

import static bridge.configuration.AppConfig.bridgeMaker;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    @ParameterizedTest
    @CsvSource({"0","1"," 10","30"})
    void 다리_길이_테스트(int size) {
        BridgeMaker bridgeMaker = bridgeMaker();
        List<String> bridge = bridgeMaker.makeBridge(size);

        int actual = bridge.size();
        int expected = size;

        assertThat(actual).isEqualTo(expected);
    }
}