package bridge.domain;

import bridge.constant.Constant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class BridgeMapGeneratorTest {

    List<List<String>> bridgeMap = new ArrayList<>();

    @BeforeEach
    void init() {
        bridgeMap.clear();
        for (int i = 0; i < 2; i++) {
            bridgeMap.add(new ArrayList<>());
        }
    }

    @Test
    void U를_입력했는데_정답인_경우_위_칸에_O_아래_칸에_공백을_출력한다(){
        List<List<String>> result = BridgeMapGenerator.generateRightAnswerMap(Constant.UP, bridgeMap);

        Assertions.assertThat(result).containsExactly(List.of("O"), List.of(" "));
    }

    @Test
    void D를_입력했는데_정답인_경우_아래_칸에_O_위_칸에_공백을_출력한다(){
        List<List<String>> result = BridgeMapGenerator.generateRightAnswerMap(Constant.DOWN, bridgeMap);
        Assertions.assertThat(result).containsExactly(List.of(" "), List.of("O"));
    }


    @Test
    void U를_입력했는데_오답인_경우_위_칸에_X_아래_칸에_공백을_출력한다(){
        List<List<String>> result = BridgeMapGenerator.generateWrongAnswerMap(Constant.UP, bridgeMap);

        Assertions.assertThat(result).containsExactly(List.of("X"), List.of(" "));
    }

    @Test
    void D를_입력했는데_오답인_경우_아래_칸에_X_위_칸에_공백을_출력한다(){
        List<List<String>> result = BridgeMapGenerator.generateWrongAnswerMap(Constant.DOWN, bridgeMap);
        Assertions.assertThat(result).containsExactly(List.of(" "), List.of("X"));
    }
}