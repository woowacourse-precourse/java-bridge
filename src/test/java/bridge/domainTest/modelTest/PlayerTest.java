package bridge.domainTest.modelTest;

import bridge.domain.constant.BridgeDirection;
import bridge.domain.model.Player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static Stream<Arguments> provideWordDirectionForFindBridgeDirectionInstance() {
        return Stream.of(
                Arguments.of("U", BridgeDirection.UP),
                Arguments.of("D", BridgeDirection.DOWN)
        );
    }

    @ParameterizedTest
    @DisplayName("플레이어가 가고자 하는 방향을 반환하는지 검사한다.")
    @MethodSource("provideWordDirectionForFindBridgeDirectionInstance")
    public void findCurrentBridgeDirection(String playerWantToGo, BridgeDirection expectedDirection) {
        Player player = new Player();
        player.saveDirection(playerWantToGo);
        BridgeDirection direction = player.getCurrentDirection();
        assertThat(direction).isEqualTo(expectedDirection);
    }
}
