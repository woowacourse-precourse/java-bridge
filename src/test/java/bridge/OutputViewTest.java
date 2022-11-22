package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class OutputViewTest {

    @DisplayName("문자열 게임에 맞는 출력으로 변환")
    @Test
    void printMap() {
        Map<String, List<String>> bridgeMap = new LinkedHashMap<>();
        List<String> bridgeUnit = Arrays.asList("O","O"," ");
        bridgeMap.put("U",bridgeUnit);
        List<String> bridgeUnit2 = Arrays.asList(" "," ","X");
        bridgeMap.put("D",bridgeUnit2);
        OutputView.printMap(bridgeMap,2);
    }
}