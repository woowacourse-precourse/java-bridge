package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.*;
import java.util.stream.*;

public class BridgeMakerTest {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    
    @Test
    void 다리_생성_시_예외(){
        int length = 8;
        List<String> newBridge = bridgeMaker.makeBridge(length);
        List<String> splitBridge = newBridge.stream()
                .filter(str -> (!(str.equals("U") && str.equals("D"))))
                .collect(Collectors.toList());
        assertThat(splitBridge.size()).isEqualTo(8);
    }
}