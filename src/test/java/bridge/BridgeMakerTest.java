package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    @DisplayName("다리 생성 테스트")
    @Test
    void 생성한_다리_길이_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(3).size())
                .isEqualTo(3);
    }

    @DisplayName("다리 이용 가능한 칸 포함 테스트")
    @Test
    void 다리_위치_포함_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(3).toString())
                .contains("D", "U");
    }

//    @DisplayName("0과 1에 U또는 D가 매핑되는 것 확인")
//    @Test
//    void DOWN_매핑_테스트() {
//        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//        assertThat(bridgeMaker.getMovableSide(0))
//                .isEqualTo("D");
//    }

//    @DisplayName("0과 1에 U또는 D가 매핑되는 것 확인")
//    @Test
//    void UP_매핑_테스트() {
//        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//        assertThat(bridgeMaker.getMovableSide(1))
//                .isEqualTo("U");
//    }
}
