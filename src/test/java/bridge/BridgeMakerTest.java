package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("사용자가 입력한 다리 길이 만큼, 다리의 정답을 담은 리스트가 생성되는지 테스트")
    @Test
    void makeBridge() {
        //given
        int size = 3;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        //when
        List<String> bridgeAnswers = bridgeMaker.makeBridge(size);
        //then
        Assertions.assertThat(bridgeAnswers.size())
                  .isEqualTo(size);
    }
}