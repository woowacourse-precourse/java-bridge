package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeIndexTest {

    BridgeIndex bridgeIndex = new BridgeIndex();

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void 인덱스_값을_메서드_호출만큼_올려준다(int numberOfCall) {
        //when
        for (int i = 0; i < numberOfCall; i++) {
            bridgeIndex.moveForward();
        }

        //then
        Assertions.assertThat(bridgeIndex.getBridgeIndex()).isEqualTo(numberOfCall);
    }

    @Test
    void 다리의_길이와_인덱스의_값이_같아지면_true값_도출() {
        //given
        int bridgeSize = 3;
        for (int i = 0; i < bridgeSize; i++) {
            bridgeIndex.moveForward();
        }

        //when
        boolean endGameResult = bridgeIndex.endGame(bridgeSize);

        //then
        Assertions.assertThat(endGameResult).isTrue();
    }
}
