package bridge.view;

import bridge.game.Progress;
import bridge.game.Result;
import bridge.generator.AreaStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final OutputView outputView = new OutputView();

    @DisplayName("결과를 문자열로 변환하여 저장")
    @Test
    void saveContent() {
        //given
        Progress upTrue = new Progress("U", true);
        Progress upFalse = new Progress("U", false);
        Progress downTrue = new Progress("D", true);
        Progress downFalse = new Progress("D", false);
        List<Progress> progresses = List.of(upTrue, upFalse, downTrue, downFalse);
        List<Result> upResults = outputView.makeResults(progresses, AreaStatus.UP);
        List<Result> downResults = outputView.makeResults(progresses, AreaStatus.DOWN);
        StringBuilder map = new StringBuilder();
        //when
        outputView.saveContent(upResults, map);
        outputView.saveContent(downResults, map);
        //then
        assertThat(map.toString()).isEqualTo("[ O | X |   |   ]\n" + "[   |   | O | X ]\n");
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
        List<Result> upResults = outputView.makeResults(progresses, AreaStatus.UP);
        List<Result> downResults = outputView.makeResults(progresses, AreaStatus.DOWN);
        //then
        assertThat(upResults.size()).isEqualTo(progresses.size());
        assertThat(downResults.size()).isEqualTo(progresses.size());
        assertThat(upResults).containsExactly(Result.SUCCESS, Result.FAIL, Result.NONE, Result.NONE);
        assertThat(downResults).containsExactly(Result.NONE, Result.NONE, Result.SUCCESS, Result.FAIL);
    }

    @DisplayName("윗칸 기준 진행 저장")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void saveUpperMapResult(String area) {
        //given
        Progress progress = new Progress(area, true);
        List<Result> results = new ArrayList<>();
        //when
        outputView.saveUpperMapResult(progress, results);
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
        outputView.saveLowerMapResult(progress, results);
        //then
        assertThat(results.size()).isEqualTo(1);
        if (area.equals(AreaStatus.DOWN.symbol)) {
            assertThat(results).contains(Result.SUCCESS);
            return;
        }
        assertThat(results).contains(Result.NONE);
    }
}