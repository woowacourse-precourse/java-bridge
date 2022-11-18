package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;


class BridgeMakerTest {
    @DisplayName("1(U)또는 0(D)이 아닌 값을 갖는 경우")
    @Test
    void createBridgeByWrongValue(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 2, 3));
        assertThatThrownBy(() -> new BridgeMaker(numberGenerator).makeBridge(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}