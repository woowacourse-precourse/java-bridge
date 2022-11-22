package bridge;

import bridge.game.BridgeGame;
import bridge.view.GameMapMaker;
import bridge.status.PassOrNot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@DisplayName("현재까지 이동한 다리의 상태를 형식에 맞게 위/아래 각각 저장하는 기능 테스트")
class GameMapMakerTest {

    GameMapMaker gameMapMaker;

    @BeforeEach
    void setUp() {
        gameMapMaker = new GameMapMaker();
        BridgeGame.up.clear();
        BridgeGame.down.clear();
    }

    @ParameterizedTest
    @CsvSource({"D,D,U"})
    void case1(String input1, String input2, String input3) {
        List<String> Answer = List.of("[   |   | O ]", "[ X | O |   ]");
        List<String> result;

        gameMapMaker.makeMap(PassOrNot.NO_PASS, input1, 0);
        gameMapMaker.makeMap(PassOrNot.PASS, input2, 1);
        result = gameMapMaker.makeMap(PassOrNot.PASS, input3, 2);
        Assertions.assertThat(result).isEqualTo(Answer);
    }

    @ParameterizedTest
    @CsvSource({"U,D,D"})
    void case2(String input1, String input2, String input3) {
        List<String> Answer = List.of("[ O |   |   ]", "[   | O | X ]");
        List<String> result;

        gameMapMaker.makeMap(PassOrNot.PASS, input1, 0);
        gameMapMaker.makeMap(PassOrNot.PASS, input2, 1);
        result = gameMapMaker.makeMap(PassOrNot.NO_PASS, input3, 2);
        Assertions.assertThat(result).isEqualTo(Answer);
    }

    @ParameterizedTest
    @CsvSource({"U,D,U"})
    void case3(String input1, String input2, String input3) {
        List<String> Answer = List.of("[ X |   | X ]", "[   | O |   ]");
        List<String> result;

        gameMapMaker.makeMap(PassOrNot.NO_PASS, input1, 0);
        gameMapMaker.makeMap(PassOrNot.PASS, input2, 1);
        result = gameMapMaker.makeMap(PassOrNot.NO_PASS, input3, 2);
        Assertions.assertThat(result).isEqualTo(Answer);
    }
}