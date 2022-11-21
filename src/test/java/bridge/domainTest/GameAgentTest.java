package bridge.domainTest;

import bridge.constant.BridgeDirection;
import bridge.domain.GameAgent;
import bridge.exception.IllegalInitializeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class GameAgentTest {

    static GameAgent createGameAgent(List<String> bridge){
        GameAgent gameAgent= new GameAgent();
        gameAgent.initialize(bridge);
        return gameAgent;
    }

    @ParameterizedTest
    @DisplayName("다리를 건널 수 있는지 확인한다.")
    @CsvSource(value = {"0: U: true", "1: D: true", "2: U: true"}, delimiter = ':')
    public void checkProperCrossingState(int currentLocation, String playerWantTogo, boolean result){
        List<String> bridgeMade = List.of("U", "D", "U");
        GameAgent gameAgent= createGameAgent(bridgeMade);
        assertThat(gameAgent.checkPossibleToCross(playerWantTogo, currentLocation)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("다리를 건널 수 없는지 확인한다.")
    @CsvSource(value = {"0: U: true", "1: U: false"}, delimiter = ':')
    public void checkWrongCrossingState(int currentLocation, String playerWantTogo, boolean result){
        List<String> bridgeMade = List.of("U", "D", "U");
        GameAgent gameAgent= createGameAgent(bridgeMade);
        assertThat(gameAgent.checkPossibleToCross(playerWantTogo, currentLocation)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("현재 다리 방향을 반환하는지 검사한다.")
    @CsvSource(value = {"0: U", "1: D", "2: U"}, delimiter = ':')
    public void findCurrentBridgeDirection(int currentLocation, String direction){
        List<String> bridgeMade = List.of("U", "D", "U");
        GameAgent gameAgent= createGameAgent(bridgeMade);
        BridgeDirection currentBridgeDirection = gameAgent.getCurrentDirection(currentLocation);
        BridgeDirection expectedBridgeDirection = BridgeDirection.findByWordBridgeDirection(direction);
        assertThat(currentBridgeDirection).isEqualTo(expectedBridgeDirection);
    }

}
