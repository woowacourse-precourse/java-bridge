package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

public class BridgeMakerTest {
    @DisplayName("요청한 길이 만큼의 다리를 잘 생성하는 지 확인")
    @ValueSource(ints = {3, 5, 6, 7, 9, 11, 20})
    @ParameterizedTest
    void make_bridge_test(int size) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);

        assertThat(maker.makeBridge(size))
                .hasSize(size)
                .isInstanceOf(ArrayList.class)
                .filteredOn(status -> status.equals("U") ||
                        status.equals("D"));
    }
}