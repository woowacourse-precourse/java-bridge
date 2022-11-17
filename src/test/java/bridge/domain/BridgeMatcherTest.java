package bridge.domain;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMatcherTest {

    private BridgeMatcher bridgeMatcher;
    private List<Boolean> boolBridge;

    @BeforeEach
    void setUp() {
        boolBridge = newArrayList(true, true, false);
        bridgeMatcher = new BridgeMatcher(boolBridge);
    }

    @Test
    @DisplayName("입력값의 일치여부를 모아둔 Collection의 길이 기능 테스트")
    void calculateSize() {
        int expected = 3;

        int actual = bridgeMatcher.calculateSize();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값의 일치여부를 추가하는 기능 테스트")
    void addTrueOrFalse() {
        List<Boolean> expected = newArrayList(true, true, false, true);

        bridgeMatcher.addTrueOrFalse(true);
        Assertions.assertThat(boolBridge).isEqualTo(expected);
    }
}