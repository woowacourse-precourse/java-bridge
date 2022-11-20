package bridge.model;

import bridge.Application;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgePieceTest extends NsTest{

    @DisplayName("리턴 되는 값이 1,2,3 이 아닌게 있는가")
    @ValueSource(strings = {"U", "D", "U", "D"})
    @ParameterizedTest
    void checkCompareAnswerReturnException(String input) {
        BridgePiece bridgePiece = new BridgePiece(input);
        BridgeAnswer bridgeAnswer = BridgeAnswer.using(new BridgeRandomNumberGenerator(), BridgeLength.from(3));
        if (!(bridgePiece.compareWithAnswer(bridgeAnswer) >= 1 && bridgePiece.compareWithAnswer(bridgeAnswer) <= 3)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}