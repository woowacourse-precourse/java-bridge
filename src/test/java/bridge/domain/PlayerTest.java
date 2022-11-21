package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("사용자의 움직임은 건널 수 있다면 O, 없다면 X 상태값을 가진다.")
    @ParameterizedTest
    @CsvSource({"true, O", "false, X"})
    void 이동가능_여부에_따른_상태값_계산(Boolean isMoveble, String expected) {
        assertThat(player.toStatusAfterCrossOver(isMoveble)).isEqualTo(expected);
    }

    @DisplayName("사용자가 다리를 건넌 후의 상태를 테스트한다.")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 사용자가_다리를_건넌_후_움직임_상태(String playerMoves, Boolean isMoveble, String expectedUp, String expectedDown) {
        for (String playerMove : playerMoves.split("")) {
            BridgeMovement playerMovement = BridgeMovement.findByMovement(playerMove);
            player.crossOverBridge(playerMovement, isMoveble);
        }
        Map<BridgeMovement, List<String>> movementStatus = player.getMovementStatus();

        assertThat(movementStatus.get(BridgeMovement.UP).stream().collect(Collectors.joining()))
                .isEqualTo(expectedUp);
        assertThat(movementStatus.get(BridgeMovement.DOWN).stream().collect(Collectors.joining()))
                .isEqualTo(expectedDown);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("UDD", true, "O  ", " OO"),
                arguments("D", false, " ", "X")
        );
    }
}