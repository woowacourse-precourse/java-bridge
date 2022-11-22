package bridge.util;

import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_SUCCESS;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_SUCCESS;
import static bridge.constant.InputKeyConstant.DOWN;
import static bridge.constant.InputKeyConstant.RETRY;
import static bridge.constant.InputKeyConstant.UP;
import static bridge.constant.NumberConstant.FIRST_ROW;
import static bridge.constant.NumberConstant.SECOND_ROW;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.CompareResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnalyzeTest {

    List<String> testStoredMap;

    @BeforeEach
    void init() {
        testStoredMap = new ArrayList<>();
    }

    @DisplayName("정상 시나리오 | 처음 입력한 값이 'U' 이고 정확한 방향일 때 ' O ' 가 첫번째 줄에 담겨있다.")
    @Test
    void analyzePrintType() {
        testStoredMap.add("");
        testStoredMap.add("");

        CompareResult compareResult = new CompareResult(UP.getFirstLetter(), true, false);

        assertThat(Analyze.analyzePrintType(testStoredMap, compareResult).get(FIRST_ROW.getCode())).contains(
                FIRST_TYPE_SUCCESS.getBridgeMaterial());
    }

    @DisplayName("정상 시나리오 | 처음 입력한 값이 'D' 이고 틀린 방향일 때 ' X ' 가 두번째 줄에 담겨있다.")
    @Test
    void analyzePrintType2() {
        testStoredMap.add("");
        testStoredMap.add("");

        CompareResult compareResult = new CompareResult(DOWN.getFirstLetter(), false, false);

        assertThat(Analyze.analyzePrintType(testStoredMap, compareResult)).contains(
                FIRST_TYPE_FAIL.getBridgeMaterial());
    }

    @DisplayName("정상 시나리오 | 첫번째 입력값은 'U' 이고 두번째 입력한 값이 'U' 이고 틀린 방향일 때 ' O | X ' 가 첫번째 줄에 담겨있다.")
    @Test
    void analyzePrintType3() {
        testStoredMap.add(" O ");
        testStoredMap.add("   ");

        CompareResult compareResult = new CompareResult(UP.getFirstLetter(), false, false);

        assertThat(Analyze.analyzePrintType(testStoredMap, compareResult).get(FIRST_ROW.getCode())).contains(
                FIRST_TYPE_SUCCESS.getBridgeMaterial() + SECOND_TYPE_FAIL.getBridgeMaterial());
    }

    @DisplayName("정상 시나리오 | 첫번째 입력값은 'U' 이고 두번째 입력한 값이 'U' 이고 정확한 방향일 때 ' O | O ' 가 첫번째 줄에 담겨있다.")
    @Test
    void analyzePrintType4() {
        testStoredMap.add(" O ");
        testStoredMap.add("   ");

        CompareResult compareResult = new CompareResult(UP.getFirstLetter(), true, false);

        assertThat(Analyze.analyzePrintType(testStoredMap, compareResult).get(FIRST_ROW.getCode())).contains(
                FIRST_TYPE_SUCCESS.getBridgeMaterial() + SECOND_TYPE_SUCCESS.getBridgeMaterial());
    }

    @DisplayName("정상 시나리오 | 첫번째 입력값은 'D' dl고 두번째 입력한 값이 'D' 이고 정확한 방향일 때 ' O | O ' 가 두번째 줄에 담겨있다.")
    @Test
    void analyzePrintType5() {
        testStoredMap.add("   ");
        testStoredMap.add(" O ");

        CompareResult compareResult = new CompareResult(DOWN.getFirstLetter(), true, false);

        assertThat(Analyze.analyzePrintType(testStoredMap, compareResult).get(SECOND_ROW.getCode())).contains(
                FIRST_TYPE_SUCCESS.getBridgeMaterial() + SECOND_TYPE_SUCCESS.getBridgeMaterial());
    }

    @DisplayName("정상 시나리오 | 재시도 입력시 'R' 을 입력하면 true 를 반환 함.")
    @Test
    void analyzeIsRetry() {
        assertThat(Analyze.analyzeIsRetry(RETRY.getFirstLetter())).isTrue();
    }

}