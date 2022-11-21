package bridge;

import static bridge.constant.GameStatus.END;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.GameStatus;
import bridge.domain.BridgeMover;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("0과 1 중 랜덤한 숫자를 생성한다.")
    @Test
    void should_ReturnEnd_When_ArriveAtDestination() {
        // given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        // when
        int randomNumber = bridgeRandomNumberGenerator.generate();
        // then
        assertThat(randomNumber).isIn(List.of(0, 1));
    }
}