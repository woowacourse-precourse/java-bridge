package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeStateTest {

    private Round round = new Round();
    private BridgeState result = new BridgeState(round);

    @DisplayName("첫 라운드에 맞춘 경우에는 첫번째 칸이 O가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:[[   ], [ O ]]", "D:[[ O ], [   ]]"}, delimiter = ':')
    void correctFirstRound(String userInput, String output) {
        result.convertCorrectResultFirstRound(userInput);
        assertThat(result.getMap().toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드에 틀린 경우에는 첫번째 칸이 X가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:[[   ], [ X ]]", "D:[[ X ], [   ]]"}, delimiter = ':')
    void wrongFirstRound(String userInput, String output) {
        result.convertWrongResultFirstRound(userInput);
        assertThat(result.getMap().toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드 이후에 맞춘 경우에는 다음칸이 O가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:[[ |   ], [ | O ]]", "D:[[ | O ], [ |   ]]"}, delimiter = ':')
    void correctOtherRound(String userInput, String output) {
        result.convertCorrectResultAfterFirstRound(userInput);
        assertThat(result.getMap().toString()).isEqualTo(output);
    }

    @DisplayName("첫 라운드 이후에 틀린 경우에는 다음칸이 X가 된다.")
    @ParameterizedTest
    @CsvSource(value = {"U:[[ |   ], [ | X ]]", "D:[[ | X ], [ |   ]]"}, delimiter = ':')
    void wrongOtherRound(String userInput, String output) {
        result.convertWrongResultAfterFirstRound(userInput);
        assertThat(result.getMap().toString()).isEqualTo(output);
    }
}