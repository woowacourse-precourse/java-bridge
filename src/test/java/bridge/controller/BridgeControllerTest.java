package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeControllerTest {
    private final BridgeController bridgeController = new BridgeController();

    @DisplayName("유저가 입력한 이동 값이 다리의 값과 일치하는지 isUserAnswerCorrect 테스트")
    @Test
    public void isUserAnswerCorrectTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        String moveDirectionFirst = "U";
        String moveDirectionSecond = "U";
        String moveDirectionThird = "D";
        String moveDirectionNotMatched = "U";

        // when
        boolean firstResult = bridgeController.isUserAnswerCorrect(moveDirectionFirst, bridge);

        bridge.nowIndexUpdate();
        boolean secondResult = bridgeController.isUserAnswerCorrect(moveDirectionSecond, bridge);

        bridge.nowIndexUpdate();
        boolean thirdResult = bridgeController.isUserAnswerCorrect(moveDirectionThird, bridge);
        boolean notMatchedResult = bridgeController.isUserAnswerCorrect(moveDirectionNotMatched, bridge);

        // then
        assertThat(firstResult).isEqualTo(true);
        assertThat(secondResult).isEqualTo(true);
        assertThat(thirdResult).isEqualTo(true);
        assertThat(notMatchedResult).isEqualTo(false);
    }

    @DisplayName("processGame 테스트 (true 경우)")
    @Test
    public void processTrueCaseTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();
        boolean isUserAnswerCorrect = true;

        // when
        bridgeController.processGame(bridge, user, isUserAnswerCorrect);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("doFailCase 테스트 (restart 경우)")
    @Test
    public void doFailCaseWithRestartTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        String gameStatus = "R";

        // when
        bridgeController.doFailCase(bridge, user, gameStatus);

        // then
        assertThat(user.getGameTryCount()).isEqualTo(2);
    }

    @DisplayName("doFailCase 테스트 (Quit 경우)")
    @Test
    public void doFailCaseWithQuitTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        String gameStatus = "Q";

        // when
        bridgeController.doFailCase(bridge, user, gameStatus);

        // then
        assertThat(user.isGameWin()).isEqualTo(false);
        assertThat(user.isGameDoneStatus()).isEqualTo(true);
    }

    @DisplayName("doSuccessCase 테스트")
    @Test
    public void doSuccessCaseTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();

        // when
        bridgeController.doSuccessCase(bridge, user);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }
}
