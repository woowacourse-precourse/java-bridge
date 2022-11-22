package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @CsvSource({"3", "10", "20"})
    void 사이즈에_맞게_다리가_생성되는_지_test(int size) {
        List<String> bridges = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(bridges.size(), size);
    }

    @ParameterizedTest
    @CsvSource({"1", "21"})
    void 입력값이_범위_밖인_경우_test(int number) {
        assertThatThrownBy(() -> bridgeMaker.validateNumberRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
