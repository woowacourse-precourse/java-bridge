package bridge.domainTest.modelTest;
import bridge.domain.model.GameRecordMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
public class GameRecordMakerTest {
    static GameRecordMaker gameRecordMaker;
    @BeforeAll
    public static void initialize(){
        gameRecordMaker= new GameRecordMaker();
    }
    @ParameterizedTest
    @MethodSource("provideGameRecordForMakeRecordFormat")
    @DisplayName("게임 기록 형식에 따라 변환된 게임 기록을 반환하는지 확인한다.")
    public void makeMapFormat(List<String> crossedState, String transformedFormat){
        assertThat(gameRecordMaker.makeMapFormat(crossedState)).isEqualTo(transformedFormat);
    }

    private static Stream<Arguments> provideGameRecordForMakeRecordFormat() {
        return Stream.of(
                Arguments.of(List.of("O", " |  "), "[ O |   ]\n"),
                Arguments.of(List.of(" ", " | O"), "[   | O ]\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideGameRecordForMakeTotalRecord")
    @DisplayName("입력된 횡단 결과에 맞게 모든 게임 기록을 반환하는지 확인한다.")
    public void createResult(List<String> gameRecord, String expectedResult){
        gameRecordMaker.updateCurrentRecord(gameRecord);
        gameRecordMaker.updateResult();

        assertThat(gameRecordMaker.getRecord()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideGameRecordForMakeTotalRecord() {
        return Stream.of(
                Arguments.of(List.of("O", " "), "[ O ]\n[   ]\n"),
                Arguments.of(List.of(" ", "O"), "[ O |   ]\n[   | O ]\n")
        );
    }
}
