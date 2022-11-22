package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.bridgemaker.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker;
    @BeforeEach
    void setUp() {
        TestNumberGenerator numberGenerator = new TestNumberGenerator(
                newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0)
        );
        bridgeMaker = new BridgeMaker(numberGenerator);
    }

    @DisplayName("size가 주어지면 반환되는 list의 사이즈는 size와 같다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 8, 9, 18, 19, 20})
    void makeBridgeBySizes(int size) {
        List<String> result = bridgeMaker.makeBridge(size);
        assertThat(result.size()).isEqualTo(size);
    }
    @DisplayName("다리는 오직 U와 D로만 이루어져 있다.")
    @Test
    void bridgeIsMadeOfOnlyUAndD() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        boolean isOnlyUAndD = true;
        for (String bridgeCell : bridge) {
            isOnlyUAndD &= bridgeCell.equals("D") || bridgeCell.equals("U");
        }
        assertThat(isOnlyUAndD).isTrue();
    }
    @DisplayName("다리 번호로 10101가 주어지면 다리는 UDUDU가 된다.")
    @Test
    void bridgeMakingTest() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "U", "D", "U");
    }
}
