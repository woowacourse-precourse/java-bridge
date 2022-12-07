package bridge.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeIndexTest {

    private static BridgeIndex bridgeIndex;

    @BeforeAll
    static void setUp() {
        bridgeIndex = new BridgeIndex();
    }

    @DisplayName("인덱스를 증가시킨다.")
    @RepeatedTest(name = "{displayName} ({currentRepetition} / {totalRepetitions})", value = 5)
    void increaseIndexTest(RepetitionInfo repetitionInfo) {
        bridgeIndex.increase();
        assertThat(bridgeIndex.getIndex()).isEqualTo(repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("인덱스를 초기화한다.")
    @Test
    void resetIndexTest() {
        bridgeIndex.reset();
        assertThat(bridgeIndex.getIndex()).isEqualTo(0);
    }

    @DisplayName("인덱스가 다리길이보다 같거나 크다.")
    @ParameterizedTest
    @CsvSource({"1,3,0", "2,3,0", "3,3,1", "4,3,1"})
    void isGreaterThanTest(int index, int size, boolean expect) {
        TestBridgeIndex testBridgeIndex = new TestBridgeIndex(index);
        BridgeSize bridgeSize = new BridgeSize(size);
        assertThat(testBridgeIndex.isGreaterThan(bridgeSize)).isEqualTo(expect);
    }

    static class TestBridgeIndex extends BridgeIndex {
        private int index;

        TestBridgeIndex(int index) {
            this.index = index;
        }
    }
}
