package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeResult;
import bridge.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.stream.Stream;

public class UserTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Bridge bridge = new Bridge(List.of("U", "U", "D", "D"));
    private BridgeResult bridgeResult = new BridgeResult();
    User user = new User(bridge, bridgeResult);

    private int movingCount = 0;

    @DisplayName("유저가 건넌다리에 대한 건널수 있는지 여부 테스트")
    @ParameterizedTest
    @MethodSource("getResultOfUserMoving")
    void checkRankOfLotto(List<String> userMovings, boolean expected, int expectedMovingCount) {

        for (String userMoving : userMovings) {
            user.move(userMoving);
            movingCount++;
            if (!user.getMoveStatus()) { break; }
        }
        assertThat(user.getMoveStatus()).isEqualTo(expected);
        assertThat(movingCount).isEqualTo(expectedMovingCount);
    }

    private static Stream<Arguments> getResultOfUserMoving() {
        return Stream.of(
                Arguments.of(List.of("U"), true,1),
                Arguments.of(List.of("U", "U", "D", "D"), true,4),
                Arguments.of(List.of("U", "U", "U", "D"), false,3)
        );
    }

}
