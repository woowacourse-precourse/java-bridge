package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("사용자가 다리를 건넌 후의 상태를 테스트한다.")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 사용자가_다리를_건넌_후_움직임_상태(String playerMoves, Boolean isMoveble, String expectedUp, String expectedDown) {
        for (String playerMove : playerMoves.split("")) {
            BridgeMovement playerMovement = BridgeMovement.findByMovement(playerMove);
            player.crossBridge(playerMovement, isMoveble);
        }
        String[] result = player.toString().split("\n");

        assertThat(result[0]).isEqualTo(expectedUp);
        assertThat(result[1]).isEqualTo(expectedDown);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("UDD", true, "[ O |   |   ]", "[   | O | O ]"),
                arguments("D", false, "[   ]", "[ X ]")
        );
    }
}