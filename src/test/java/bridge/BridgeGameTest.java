package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자가 입력한 값과 무작위로 저장된 다리의 값을 비교한다.")
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","D"));
        assertThat(bridgeGame.move(0,"D")).isEqualTo(false);
    }
}