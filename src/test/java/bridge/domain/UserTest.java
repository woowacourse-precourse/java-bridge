package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.utils.BridgeState;
import bridge.domain.utils.GameState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class UserTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
    }

    @ParameterizedTest
    @CsvSource(value = {"U,D:U:true", "U,D:D:false"}, delimiter = ':')
    void 유저가_간곳이_저장되는지_확인(String bridgePosition, String input, Boolean isAlive) {
        List<String> bridgeData = new ArrayList<>(Arrays.stream(bridgePosition.split(",")).collect(Collectors.toList()));
        Bridge bridge = new Bridge(bridgeData);
        User user = new User();
        bridgeGame.move(user, bridge, input);

        Assertions.assertThat(user.getBridgeGames().get(0)).isEqualTo(BridgeState.convertToBridgeState(input, isAlive));
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U:true", "D:D:true"}, delimiter = ':')
    void 유저가_끝까지_건넜는지_확인(String bridgePosition, String input, Boolean isAlive) {
        List<String> bridgeData = new ArrayList<>(Arrays.stream(bridgePosition.split(",")).collect(Collectors.toList()));
        Bridge bridge = new Bridge(bridgeData);
        User user = new User();
        bridgeGame.move(user, bridge, input);

        Assertions.assertThat(bridgeGame.isGameEnd(user,bridge,isAlive)).isEqualTo(GameState.END);
    }
}