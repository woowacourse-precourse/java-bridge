package bridge.model;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeAnswerTest extends NsTest {

    @DisplayName("올바른 Bridge Answer 가 생성되는지 테스트 ")
    @Test
    void checkGeneratedBridgeAnswerException() {
        for (int i = 0; i < 100; i++) {
            BridgeAnswer bridgeAnswer = BridgeAnswer.using(new BridgeMaker(new BridgeRandomNumberGenerator()),
                    BridgeLength.from(5));
            int result = bridgeAnswer.compareWithUserMove(3, "U");
            if (result != 1 && result != 2 && result != 3) {
                throw new IllegalArgumentException("generated result is not valid.");
            }
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}