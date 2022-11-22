package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 생성기는 입력된 숫자의 크기만큼 다리생성번호를 만들어낸다.")
    void makeBridgeTest() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = 4;

        //when
        List<String> bridgeShapeNumbers = bridgeMaker.makeBridge(4);

        //then
        Assertions.assertThat(bridgeShapeNumbers.size()).isEqualTo(bridgeSize);

    }

}
