package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeStateTest {

    private Round round = new Round();
    private BridgeState result = new BridgeState(round);

    @DisplayName("첫 라운드에 맞춘 경우에는 첫번째 칸이 O가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:U D U:[[   ], [ O ]]", "D:D U D:[[ O ], [   ]]"}, delimiter = ':')
    void correctFirstRound(String userInput, String map, String output) {
        // given
        List<String> bridge = Arrays.asList(map.split(" "));

        // when
        List<String> answer = result.convertResult(userInput, bridge);

        // then
        assertThat(answer.toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드에 틀린 경우에는 첫번째 칸이 X가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:D U D:[[   ], [ X ]]", "D:U D U:[[ X ], [   ]]"}, delimiter = ':')
    void wrongFirstRound(String userInput, String map, String output) {
        // given
        List<String> bridge = Arrays.asList(map.split(" "));

        // when
        List<String> answer = result.convertResult(userInput, bridge);

        // then
        assertThat(answer.toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드 이후에 맞춘 경우에는 다음칸이 O가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:D U D:[[ |   ], [ | O ]]", "D:U D U:[[ | O ], [ |   ]]"}, delimiter = ':')
    void correctOtherRound(String userInput, String map, String output) {
        // given
        List<String> bridge = Arrays.asList(map.split(" "));
        round.plusRound();

        // when
        List<String> answer = result.convertResult(userInput, bridge);

        // then
        assertThat(answer.toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드 이후에 틀린 경우에는 다음칸이 X가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:U D U:[[ |   ], [ | X ]]", "D:D U D:[[ | X ], [ |   ]]"}, delimiter = ':')
    void wrongOtherRound(String userInput, String map, String output) {
        // given
        List<String> bridge = Arrays.asList(map.split(" "));
        round.plusRound();

        // when
        List<String> answer = result.convertResult(userInput, bridge);

        // then
        assertThat(answer.toString()).isEqualTo(output);
    }

    @DisplayName("맵을 초기화 하면 맵은 [[ ], [ ]]이 된다,")
    @Test
    void initMap() {
        // given
        String userInput = "U";
        List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
        result.convertResult(userInput, bridge);

        // when
        result.init();

        // then
        assertThat(result.getMap().toString()).isEqualTo("[[ ], [ ]]");
    }
}