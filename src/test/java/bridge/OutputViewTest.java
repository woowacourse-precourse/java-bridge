package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest  {

    static final OutputView outputView = new OutputView();

    @DisplayName("다른 쪽이 조건이 맞을때")
    @Test
    void storeAnotherMapTest() {
        List<String> bridgeMap = new ArrayList<>();
        List<String> compareMap = new ArrayList<>();
        compareMap.add("[");
        compareMap.add("   |");
        compareMap.add("]");

        assertThat(outputView.storeAnotherMap(bridgeMap,0)).isEqualTo(compareMap);
    }

    @DisplayName("조건에 맞는 쪽일때")
    @Test
    void storeRightMapTest() {
        List<String> bridgeMap = new ArrayList<>();
        List<String> compareMap = new ArrayList<>();
        compareMap.add("[");
        compareMap.add(" O |");
        compareMap.add("]");

        assertThat(outputView.storeRightMap(bridgeMap,0)).isEqualTo(compareMap);
    }

    @DisplayName("다른 쪽이 조건에 안 맞을때")
    @Test
    void storeAnotherWrongMapTest() {
        List<String> bridgeMap = new ArrayList<>();
        List<String> compareMap = new ArrayList<>();
        compareMap.add("[");
        compareMap.add("   ");
        compareMap.add("]");

        assertThat(outputView.storeAnotherWrongMap(bridgeMap,0)).isEqualTo(compareMap);
    }

    @DisplayName("조건이 안 맞을때")
    @Test
    void storeWrongMapTest() {
        List<String> bridgeMap = new ArrayList<>();
        List<String> compareMap = new ArrayList<>();
        compareMap.add("[");
        compareMap.add(" X ");
        compareMap.add("]");

        assertThat(outputView.storeWrongMap(bridgeMap,0)).isEqualTo(compareMap);
    }

}
