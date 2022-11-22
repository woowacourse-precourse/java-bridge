package bridge.ModelTest;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @DisplayName("다리가 만들어질 때 U, D 로만 잘 만들어지는 확인")
    @Test
    void 다리가_생성_예외처리() {
        int size = 15;
        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> test = bridge.stream()
                .filter(str -> (str.equals("U") || str.equals("D")))
                .collect(Collectors.toList());
        assertThat(test.size()).isEqualTo(15);
    }
}
