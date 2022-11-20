package bridge;

import bridge.Util.COMMAND_CONSTANTS;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {
    @Test
    void 다리_생성_테스트(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(10)).contains("U").contains("D");
        System.out.println(bridgeMaker.makeBridge(10));
    }

}
