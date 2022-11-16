package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest(name = "{0}을 입력받으면 길이가 {0}인 List<String>을 반환한다.")
    @ValueSource(ints = {3, 9, 20})
    void createBridgeSuccess(int size) {
        List<String> stringList = bridgeMaker.makeBridge(size);
        assertThat(stringList).hasSize(size);
    }

    @ParameterizedTest(name = "값이 3 이상 20 이하가 아닌 숫자를 입력받으면 예외를 발생시킨다. (입력 : {0})")
    @ValueSource(ints = {0, 1, 25, 50})
    void createBridgeFail(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 3 이상 20 이하여야 합니다.");
    }
}