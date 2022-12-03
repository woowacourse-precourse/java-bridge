package bridge.domainTest.modelTest;

import bridge.domain.model.RecordFormat;
import bridge.domain.model.GameRecord;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRecordTest {
    static GameRecord gameRecord;
    static RecordFormat recordFormat;

    @BeforeAll
    public static void initialize() {
        gameRecord = new GameRecord();
        recordFormat = new RecordFormat();
    }

    private static Stream<Arguments> provideGameRecordForMakeTotalRecord() {
        return Stream.of(
                Arguments.of(List.of("O", " "), "[ O ]\n[   ]\n"),
                Arguments.of(List.of(" |  ", " | O"), "[ O |   ]\n[   | O ]\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideGameRecordForMakeTotalRecord")
    @DisplayName("입력된 횡단 결과에 맞게 모든 게임 기록을 반환하는지 확인한다.")
    public void createResult(List<String> gameRecord, String expectedResult) {
        GameRecordTest.gameRecord.updateResult(gameRecord);

        assertThat(GameRecordTest.gameRecord.getRecord()).isEqualTo(expectedResult);
    }
}
