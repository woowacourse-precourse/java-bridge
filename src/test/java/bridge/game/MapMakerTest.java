package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.generator.Answer;
import bridge.generator.MapMaker;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
[X] 출력할 전체 맵 생성
[X] 다리의 윗칸들의 맵 생성
[X] 다리의 윗칸들의 결과 생성
[X] 윗칸 기준의 결과 저장
[X] 다리의 아래칸들의 맵 생성
[X] 다리의 아래칸들의 결과 생성
[X] 아래칸 기준의 결과 저장
[X] 결과들을 알맞은 문자열로 변환
[X] 마지막 결과 반환
 */

public class MapMakerTest {
    private final MapMaker mapMaker = new MapMaker();

    @DisplayName("마지막 결과 반환")
    @Test
    void getLastResult() {
        //given
        List<Result> results = List.of(Result.CONTINUE, Result.SUCCESS, Result.FAIL);
        //when
        Result lastResult = mapMaker.getLastResult(results);
        //then
        assertThat(lastResult).isEqualTo(Result.FAIL);
    }

    @DisplayName("결과들을 알맞은 문자열로 변환")
    @Test
    void changeResultsToString() {
        //given
        List<Result> results = List.of(Result.CONTINUE, Result.SUCCESS, Result.FAIL);
        //when
        String lowerBridgeResultMap = mapMaker.changeResultsToString(results);
        //then
        assertThat(lowerBridgeResultMap).isEqualTo("   | O | X ");
    }

    @DisplayName("출력할 전체 맵 생성 기능 테스트")
    @Test
    void makeMap() {
        //given
        Move upTrue = new Move("U", true);
        Move upFalse = new Move("U", false);
        Move downTrue = new Move("D", true);
        Move downFalse = new Move("D", false);
        List<Move> moves = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        String map = mapMaker.makeMap(moves);
        //then
        assertThat(map).isEqualTo("[ O | X |   |   ]\n" + "[   |   | O | X ]\n");
    }

    @DisplayName("다리의 윗칸들의 맵 생성 기능 테스트")
    @Test
    void getUpperBridgeMap() {
        //given
        Move upTrue = new Move("U", true);
        Move upFalse = new Move("U", false);
        Move downTrue = new Move("D", true);
        Move downFalse = new Move("D", false);
        List<Move> moves = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        String upperBridgeMap = mapMaker.getUpperBridgeMap(moves);
        //then
        assertThat(upperBridgeMap).isEqualTo("[ O | X |   |   ]\n");
    }

    @DisplayName("다리의 아래칸들의 맵 생성 기능 테스트")
    @Test
    void getLowerBridge() {
        //given
        Move upTrue = new Move("U", true);
        Move upFalse = new Move("U", false);
        Move downTrue = new Move("D", true);
        Move downFalse = new Move("D", false);
        List<Move> moves = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        String lowerBridgeMap = mapMaker.getLowerBridge(moves);
        //then
        assertThat(lowerBridgeMap).isEqualTo("[   |   | O | X ]\n");
    }

    @DisplayName("다리의 위칸들의 결과 생성 기능 테스트")
    @Test
    void makeUpperBridgeResult() {
        //given
        Move upTrue = new Move("U", true);
        Move upFalse = new Move("U", false);
        Move downTrue = new Move("D", true);
        Move downFalse = new Move("D", false);
        List<Move> moves = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        List<Result> upperBridgeResult = mapMaker.makeUpperBridgeResult(moves);
        //then
        assertThat(upperBridgeResult.size()).isEqualTo(moves.size());
        assertThat(upperBridgeResult).containsExactly(Result.SUCCESS, Result.FAIL, Result.NONE, Result.NONE);
    }

    @DisplayName("다리의 아래칸들의 결과 생성 기능 테스트")
    @Test
    void makeLowerBridgeResult() {
        //given
        Move upTrue = new Move("U", true);
        Move upFalse = new Move("U", false);
        Move downTrue = new Move("D", true);
        Move downFalse = new Move("D", false);
        List<Move> moves = List.of(upTrue, upFalse, downTrue, downFalse);
        //when
        List<Result> lowerBridgeResult = mapMaker.makeLowerBridgeResult(moves);
        //then
        assertThat(lowerBridgeResult.size()).isEqualTo(moves.size());
        assertThat(lowerBridgeResult).containsExactly(Result.NONE, Result.NONE, Result.SUCCESS, Result.FAIL);
    }

    @DisplayName("윗칸 기준의 결과 저장 기능 테스트")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void saveUpperMapResult(String area) {
        //given
        Move move = new Move(area, true);
        List<Result> results = new ArrayList<>();
        //when
        mapMaker.saveUpperMapResult(move, results);
        //then
        assertThat(results.size()).isEqualTo(1);
        if (area.equals(Answer.UP.getLetter())) {
            assertThat(results).contains(Result.SUCCESS);
        }
        if (area.equals(Answer.DOWN.getLetter())) {
            assertThat(results).contains(Result.NONE);
        }
    }

    @DisplayName("아래칸 기준의 결과 저장 기능 테스트")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void saveLowerMapResult(String area) {
        //given
        Move move = new Move(area, true);
        List<Result> results = new ArrayList<>();
        //when
        mapMaker.saveLowerMapResult(move, results);
        //then
        assertThat(results.size()).isEqualTo(1);
        if (area.equals(Answer.UP.getLetter())) {
            assertThat(results).contains(Result.NONE);
        }
        if (area.equals(Answer.DOWN.getLetter())) {
            assertThat(results).contains(Result.SUCCESS);
        }
    }
}
