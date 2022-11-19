package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.generator.AreaStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;


public class MapMakerTest {
    private final MapMaker mapMaker = new MapMaker();

    @DisplayName("다리 상태를 출력할 수 있게 변환")
    @Test
    void makeMap() {
        //given
        Progress upTrue = new Progress("U", true);
        Progress upFalse = new Progress("U", false);
        Progress downTrue = new Progress("D", true);
        Progress downFalse = new Progress("D", false);
        List<Progress> progresses = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        String map = mapMaker.makeMap(progresses);
        //then
        assertThat(map).isEqualTo("[ O | X |   |   ]\n" + "[   |   | O | X ]\n");
    }

    @DisplayName("원하는 칸 기준의 현재까지의 모든 진행 결과 저장")
    @Test
    void makeResults() {
        //given
        Progress upTrue = new Progress("U", true);
        Progress upFalse = new Progress("U", false);
        Progress downTrue = new Progress("D", true);
        Progress downFalse = new Progress("D", false);
        List<Progress> progresses = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        List<Result> upperBridgeResult = mapMaker.makeUpperBridgeResult(progresses);
        List<Result> lowerBridgeResult = mapMaker.makeLowerBridgeResult(progresses);
        //then
        assertThat(upperBridgeResult.size()).isEqualTo(progresses.size());
        assertThat(lowerBridgeResult.size()).isEqualTo(progresses.size());
        assertThat(upperBridgeResult).containsExactly(Result.SUCCESS, Result.FAIL, Result.NONE, Result.NONE);
        assertThat(lowerBridgeResult).containsExactly(Result.NONE, Result.NONE, Result.SUCCESS, Result.FAIL);
    }

    @DisplayName("윗칸 기준 진행 저장")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void saveUpperMapResult(String area) {
        //given
        Progress progress = new Progress(area, true);
        List<Result> results = new ArrayList<>();
        //when
        mapMaker.saveUpperMapResult(progress, results);
        //then
        assertThat(results.size()).isEqualTo(1);
        if (area.equals(AreaStatus.UP.symbol)) {
            assertThat(results).contains(Result.SUCCESS);
            return;
        }
        assertThat(results).contains(Result.NONE);
    }

    @DisplayName("아래칸 기준 진행 저장")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void saveLowerMapResult(String area) {
        //given
        Progress progress = new Progress(area, true);
        List<Result> results = new ArrayList<>();
        //when
        mapMaker.saveLowerMapResult(progress, results);
        //then
        assertThat(results.size()).isEqualTo(1);
        if (area.equals(AreaStatus.DOWN.symbol)) {
            assertThat(results).contains(Result.SUCCESS);
            return;
        }
        assertThat(results).contains(Result.NONE);
    }
}
