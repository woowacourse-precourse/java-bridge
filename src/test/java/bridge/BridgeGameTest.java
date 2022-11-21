package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.Constants.Command;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setupBridgeGame() {
        bridgeGame = new BridgeGame();
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        // bridge => "UDD"
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame.setBridge(bridge);
    }

    @DisplayName("성공적으로 움직였으면 true를 실패했으면 false를 리턴한다.")
    @Test
    void moveTest_1() {
        assertThat(bridgeGame.move(Command.DOWN)).isEqualTo(false);
    }

    @DisplayName("성공적으로 움직였으면 true를 실패했으면 false를 리턴한다.")
    @Test
    void moveTest_2() {
        assertThat(bridgeGame.move(Command.UP)).isEqualTo(true);
    }


    //FIXME
    @DisplayName("게임 시도 횟수를 리턴해준다")
    @Test
    void getAttemptCountTest() {
        assertThat(BridgeGame.getAttemptCount()).isEqualTo(1);
    }

    @DisplayName("게임 시도 횟수를 증가시킨다")
    @Test
    void increaseAttemptCountTest() {
        BridgeGame.increaseAttemptCount();
        assertThat(BridgeGame.getAttemptCount()).isEqualTo(1);
    }

//    @DisplayName("이동한 위치에 대한 결과를 저장한다")
//    @Test
//    void addMovementTest() {
//        bridgeGame.addMovement(
//                Arrays.asList(bridgeGame.getUpLineForm().split("|")),
//                Arrays.asList(bridgeGame.getUpLineForm().split("|")),
//                true
//        );
//
//        assertThat(bridgeGame.getUpLineForm()).isEqualTo(" O ");
//        assertThat(bridgeGame.getDownLineForm()).isEqualTo("   ");
//    }

    @DisplayName("입력한 방향과 해당 지점이 같으면 true를 다르면 false를 리턴한다")
    @Test
    void isCorrectDirectionTest_1() {
        assertThat(bridgeGame.isCorrectDirection("U")).isEqualTo(true);
    }

    @DisplayName("입력한 방향과 해당 지점이 같으면 true를 다르면 false를 리턴한다")
    @Test
    void isCorrectDirectionTest_2() {
        assertThat(bridgeGame.isCorrectDirection("D")).isEqualTo(false);
    }


    @DisplayName("Q를 입력하면 false, R을 입력하면 true를 리턴한다.")
    @Test
    void retryTest_1() {
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }


    @DisplayName("Q를 입력하면 false, R을 입력하면 true를 리턴한다.")
    @Test
    void retryTest_2() {
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }
}
