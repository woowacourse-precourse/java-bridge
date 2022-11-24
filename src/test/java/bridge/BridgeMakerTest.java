package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("Bridge는 size가")
    @ParameterizedTest(name = "3이상 20이하의 다리를 생성한다.")
    @CsvSource(value = {"3", "20"})
    void makeBridgeSize(int size) {
        List<String> strings = bridgeMaker.makeBridge(size);

        assertThat(strings.size()).isEqualTo(size);
    }

    @DisplayName("Bridge는 size가")
    @ParameterizedTest(name = "2이하 21이상이면 예외가 발생한다.")
    @CsvSource(value = {"2", "21"})
    void bridgeSizeTest(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

}