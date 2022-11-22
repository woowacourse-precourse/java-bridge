package bridge.model;

import bridge.Application;
import bridge.model.ScreenGenerator.BridgeEachRowGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgePieceTest extends NsTest{

    @DisplayName("리턴 되는 값이 1,2,3 이 아닌게 있는가")
    @Test
    void checkCompareAnswerReturnException() {
        List<String> answer = List.of("U", "D", "U", "U", "D");
        int current = 3;
        BridgeEachRowGenerator bridgeEachRowGenerator = new BridgeEachRowGenerator(answer, current);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}