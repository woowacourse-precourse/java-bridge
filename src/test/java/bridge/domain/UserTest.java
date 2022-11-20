package bridge.domain;

import bridge.controller.BridgeGame;
import bridge.domain.utils.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame(new InputView(), new OutputView());
    }

    @ParameterizedTest
    @CsvSource(value = {"U,D:U:true", "U,D:D:false"}, delimiter = ':')
    void 유저가_간곳이_저장되는지_확인(String bridgePosition, String input, Boolean isAlive) {
        List<String> bridgeData = new ArrayList<>(Arrays.stream(bridgePosition.split(",")).collect(Collectors.toList()));
        Bridge bridge = new Bridge(bridgeData);
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        User user = new User();
        bridgeGame.move(user, bridge);

        Assertions.assertThat(user.getBridgeGames().get(0)).isEqualTo(BridgeState.convertToBridgeState(input, isAlive));
    }
}