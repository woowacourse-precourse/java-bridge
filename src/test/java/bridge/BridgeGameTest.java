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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("첫번째 줄 다리의 출력 포맷을 리턴한다")
    @Test
    void getUpLineFormTest() {
        bridgeGame.move(Command.UP);
        bridgeGame.move(Command.UP);
        assertThat(bridgeGame.getUpLineForm()).isEqualTo("[ O | X ]");
    }

    @DisplayName("두번째 줄 다리의 출력 포맷을 리턴한다")
    @Test
    void getDonwLineFormTest() {
        bridgeGame.move(Command.DOWN);
        assertThat(bridgeGame.getDownLineForm()).isEqualTo("[ X ]");
    }

    @DisplayName("성공적으로 움직였으면 true를 실패했으면 false를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"D:false", "U:true"}, delimiter = ':')
    void moveTest_1(String command, boolean isCorrect) {
        assertThat(bridgeGame.move(command)).isEqualTo(isCorrect);
    }


    //FIXME
//    @DisplayName("게임 시도 횟수를 리턴해준다")
//    @Test
//    void getAttemptCountTest() {
//        assertThat(BridgeGame.attemptCountToString()).isEqualTo("총 시도한 횟수: " + 0);
//    }

    @DisplayName("게임 시도 횟수를 증가시킨다")
    @Test
    void increaseAttemptCountTest() {
        BridgeGame.increaseAttemptCount();
        assertThat(BridgeGame.attemptCountToString()).isEqualTo("총 시도한 횟수: " + 1);
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
    @ParameterizedTest
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    void isCorrectDirectionTest_1(String command, boolean isCoorrect) {
        assertThat(bridgeGame.isCorrectDirection(command)).isEqualTo(isCoorrect);
    }

    @DisplayName("Q를 입력하면 false, R을 입력하면 true를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"Q:false", "R:true"}, delimiter = ':')
    void retryTest_1(String command, boolean isRetry) {
        assertThat(bridgeGame.retry(command)).isEqualTo(isRetry);
    }
}
