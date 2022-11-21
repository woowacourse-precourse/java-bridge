package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @DisplayName("0과1로 이루어져 있지 않는 구현체에 대해 예외를 발생시킵니다.")
    @Test
    void 구현체_요구사항미충족() {
        bridgeMaker = new BridgeMaker(() -> Randoms.pickNumberInRange(2, 3));

        int SIZE = 10;
        assertThatThrownBy(() ->
                        bridgeMaker.makeBridge(SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("랜덤으로 생성되는 번호는 0 또는 1 입니다.");
    }

    @DisplayName("해당 길이에 맞는 다리를 생성 - 윗다리")
    @Test
    void 윗다리만_다리생성() {
        bridgeMaker = new BridgeMaker(() -> 1);

        int SIZE = 5;
        bridgeMaker.makeBridge(SIZE);
        Assertions.assertThat(bridgeMaker.makeBridge(SIZE))
                .isEqualTo(List.of("U", "U", "U", "U", "U"));
    }

    @DisplayName("해당 길이에 맞는 다리를 생성 - 아랫다리")
    @Test
    void 아랫다리만_다리생성() {
        bridgeMaker = new BridgeMaker(() -> 0);

        int SIZE = 5;
        bridgeMaker.makeBridge(SIZE);
        Assertions.assertThat(bridgeMaker.makeBridge(SIZE))
                .isEqualTo(List.of("D", "D", "D", "D", "D"));
    }
}