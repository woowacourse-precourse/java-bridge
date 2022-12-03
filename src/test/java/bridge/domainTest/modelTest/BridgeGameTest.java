package bridge.domainTest.modelTest;

import bridge.BridgeNumberGenerator;
import bridge.domain.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    static BridgeGame bridgeGame;
    static Player player;
    static GameState gameState;
    static GameProgress gameProgress;

    @BeforeAll
    public static void initialize() {
        BridgeNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1));
        bridgeGame = new BridgeGame(testNumberGenerator);
        bridgeGame.constructBridge(3);
    }

    @BeforeAll
    public static void initializeOther() {
        player = new Player();
        gameState = new GameState();
        gameState.initialize();
        gameProgress = new GameProgress();
        gameProgress.initialize();
    }

    private static Stream<Arguments> provideDirectionForMakeRecord() {
        return Stream.of(
                Arguments.of(0, "U", true, "[ O ]\n[   ]\n"),
                Arguments.of(1, "D", true, "[ O |   ]\n[   | O ]\n")
        );
    }

    @ParameterizedTest
    @DisplayName("플레이어의 입력에 대해 다리 횡단 상태를 확인한다.")
    @CsvSource(value = {"0:U: true", "1:D: true", "2:U: true"}, delimiter = ':')
    public void moveTest(int trial, String playerWantToGo, boolean result) {
        boolean currentState = bridgeGame.move(playerWantToGo, trial);
        gameState.updateGameState(currentState);
        assertThat(gameState.getGameState()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionForMakeRecord")
    @DisplayName("플레이어의 입력에 대해 다리 횡단 결과를 확인한다.")
    public void makeReportTest(int trial, String playerWantToGo, boolean result) {
        boolean currentState = bridgeGame.move(playerWantToGo, trial);
        gameState.updateGameState(currentState);
        player.saveDirection(playerWantToGo);
        bridgeGame.makeReport(gameState.getGameState(), player.getCurrentDirection(), gameProgress.isFirstTrial());
        assertThat(gameState.getGameState()).isEqualTo(result);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

}
