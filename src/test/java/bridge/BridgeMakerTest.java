package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    public void init() {
        bridgeNumberGenerator = new BridgeRawNumberGenerator(
                List.of(0, 0, 1, 0, 1)
        );
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("반환할 값을 리스트로 정한 전략을 주입받아 입력받은 사이즈 만큼의 브릿지 생성")
    @Test
    public void createBridgeForInputSize() {
        //given
        int input_size = 5;

        //when & then
        assertThat(bridgeMaker.makeBridge(input_size)).isEqualTo(List.of("D", "D", "U", "D", "U"));
    }

}