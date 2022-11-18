package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setup() {
        List<String> arr = new ArrayList<>(List.of("U", "D", "U"));
        bridgeGame = BridgeGame.from(Bridge.from(arr));
    }

    @DisplayName("잘못된 move 명령어를 입력하면 오류를 반환한다.")
    @ValueSource(strings = {"A", "s", "t"})
    @ParameterizedTest
    void throwErrorWhenInputInvalidMoveCommand(String command) {
        assertThatThrownBy(() -> bridgeGame.move(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 move 명령어를 1번 입력하여 결과를 얻는다.")
    @ValueSource(strings = {"U"})
    @ParameterizedTest
    void returnResultWhenInputValidMoveCommand(String command) {
        GameResult gameResult = bridgeGame.move(command);
        List<String> result = gameResult.getResult();
        Assertions.assertThat(result.get(0))
                .isEqualTo(command);
    }

    @DisplayName("올바른 move 명령어를 2번 입력하여 결과를 얻는다.")
    @Test
    void returnResultWhenInputTwoValidMoveCommand() {
        String command = "U";
        bridgeGame.move(command);
        GameResult gameResult = bridgeGame.move("U");

        Assertions.assertThat(gameResult.getResult().size())
                .isEqualTo(2);
    }
}