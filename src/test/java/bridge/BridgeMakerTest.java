package bridge;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("주어진 길이 만큼의 다리 생성")
    @Test
    void 사이즈다리생성(){
        final int size = 3;
        List<String> combinations = List.of("UUU", "UUD", "UDU", "UDD", "DUU", "DUD", "DDU", "DDD");

        Assertions.assertSimpleTest(()->{
            List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size); // ["U","D","U"]
            assertThat(String.join(",", bridge).replace(",","")).isIn(combinations);
        });
    }

    @DisplayName("해당 숫자에 맞는 U 또는 D 반환")
    @Test
    void U또는D반환(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Assertions.assertSimpleTest(()-> assertThat(bridgeMaker.convertNumberToUpAndDown(1)).isEqualTo("U"));
    }


}