package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setup(){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    void 다리생성_테스트(){
        assertRandomNumberInRangeTest(()->{
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge).isEqualTo(List.of("U","D","D"));
        },1, 0, 0);
    }
}