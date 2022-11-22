package bridge.domainTest.modelTest;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.constant.BridgeDirection;
import bridge.domain.model.BridgeGame;
import bridge.domain.model.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
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
    static BridgeGame bridgeGame;
    static Player player;

    @BeforeAll
    public static void initialize(){
        BridgeNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 1));
        bridgeGame = new BridgeGame(testNumberGenerator);
        bridgeGame.prepare();
        bridgeGame.constructBridge(3);
        player = new Player();
    }

    @ParameterizedTest
    @DisplayName("플레이어의 입력에 대해 다리 횡단 상태를 확인한다.")
    @CsvSource(value = {"U: true", "D: true", "U: true"}, delimiter = ':')
    public void moveTest(String playerWantToGo, boolean result){
        bridgeGame.move(playerWantToGo);
        assertThat(bridgeGame.isCrossSuccess()).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionForMakeRecord")
    @DisplayName("플레이어의 입력에 대해 다리 횡단 결과를 확인한다.")
    public void makeReportTest(String playerWantToGo, boolean result){
        bridgeGame.move(playerWantToGo);

        player.saveDirection(playerWantToGo);
        bridgeGame.makeReport(player.getCurrentDirection());
        assertThat(bridgeGame.isCrossSuccess()).isEqualTo(result);
    }
    private static Stream<Arguments> provideDirectionForMakeRecord() {
        return Stream.of(
                Arguments.of("U", true,  "[ O ]\n[   ]\n"),
                Arguments.of("D", true, "[ O |   ]\n[   | O ]\n")
        );
    }
    
}
