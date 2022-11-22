package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동 결과를 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"U,true", "D,false"})
    void move(String direction, boolean expected) {
        Player player = new Player(List.of("U", "D", "U"));
        boolean actual = bridgeGame.move(player, direction);

        assertThat(actual).isEqualTo(expected);
    }

}