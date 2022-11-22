package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import bridge.ApplicationTest.TestNumberGenerator;
import bridge.utils.Constants.Command;

public class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setupBridgeGame() {
        bridgeGame = new BridgeGame();
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame.setBridge(bridge);
    }

    @DisplayName("게임을 성공으로 끝냈는지에 대한 boolean 값을 리턴한다")
    @Test
    void isSuccessFinishTest(){
        assertThat(bridgeGame.isSuccessFinish()).isEqualTo(false);
    }

    @DisplayName("성공 여부에 대한 문자열을 리턴한다")
    @Test
    void resultToStringTest(){
        assertThat(bridgeGame.resultToString()).isEqualTo("게임 성공 여부: 실패");
    }

    @DisplayName("시도한 횟수를 나타내는 문자열을 리턴한다.")
    @Test
    void attemptCountToStringTest() {
        BridgeGame.increaseAttemptCount();
        BridgeGame.increaseAttemptCount();
        assertThat(BridgeGame.attemptCountToString()).isEqualTo("총 시도한 횟수: 3");
    }

    @DisplayName("첫번째 줄 다리의 출력 포맷을 리턴한다")
    @Test
    void getUpLineFormTest() {
        bridgeGame.move(Command.UP);
        bridgeGame.move(Command.UP);
        assertThat(bridgeGame.uplineToString()).isEqualTo("[ O | X ]");
    }

    @DisplayName("두번째 줄 다리의 출력 포맷을 리턴한다")
    @Test
    void getDonwLineFormTest() {
        bridgeGame.move(Command.DOWN);
        assertThat(bridgeGame.downlineToString()).isEqualTo("[ X ]");
    }

    @DisplayName("성공적으로 움직였으면 true를 실패했으면 false를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"D:false", "U:true"}, delimiter = ':')
    void moveTest_1(String command, boolean isCorrect) {
        assertThat(bridgeGame.move(command)).isEqualTo(isCorrect);
    }


    @DisplayName("게임 시도 횟수를 증가시킨다")
    @Test
    void increaseAttemptCountTest() {
        BridgeGame.increaseAttemptCount();
        assertThat(BridgeGame.attemptCountToString()).isEqualTo("총 시도한 횟수: " + 1);
    }

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
