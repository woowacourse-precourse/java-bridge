package bridge.constantTest;

import bridge.constant.BridgeDirection;
import bridge.constant.GameRecord;
import bridge.constant.GameRecordFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.ls.LSException;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class GameRecordFormatTest {
    private static Stream<Arguments> provideBooleanForFindByGameRecordFormat() {
        return Stream.of(
                Arguments.of(true, GameRecordFormat.NORMAL),
                Arguments.of(false, GameRecordFormat.BACK_SLASHED)
        );
    }
    @ParameterizedTest
    @MethodSource("provideBooleanForFindByGameRecordFormat")
    @DisplayName("첫 회차가 아니라면 BACK_SLASHED 객체를 맞다면 NORMAL 객체를 반환하는지 확인한다.")
    public void findGameRecordFormat(boolean isFirst, GameRecordFormat gameRecordFormat){
        assertThat(GameRecordFormat.findByTrial(isFirst)).isEqualTo(gameRecordFormat);
    }
    @ParameterizedTest
    @MethodSource("provideBooleanForGenerateProperFormat")
    @DisplayName("첫 회차라면 원래의 기록을 반환하고 아니라면 |가 추가된 기록을 반환하는지 확인한다.")
    public void generateProperGameRecordFormat(boolean isFirst, String transformedResult){
        String currentResult = "X";
        GameRecordFormat gameRecordFormat = GameRecordFormat.findByTrial(isFirst);
        assertThat(gameRecordFormat.generate(currentResult)).isEqualTo(transformedResult);
    }
    private static Stream<Arguments> provideBooleanForGenerateProperFormat() {
        return Stream.of(
                Arguments.of(true, "X"),
                Arguments.of(false, " | X")
        );
    }

}
