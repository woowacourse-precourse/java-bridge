package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import bridge.constant.GameState;
import bridge.util.Validate;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BridgeCoreTest extends NsTest{


    private final boolean moveStop = false;

    private boolean successFinish=false;
    @Test
    @DisplayName("재시도 후 게임을 성공했을 경우")
    void retryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D","R","U", "D", "U");
            assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("재시도 후 중도에 게임을 끝낼 경우")
    void wrongFinishAndQuitTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D","R","U", "U", "Q");
            assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }


    @Test
    @DisplayName("재시도 X 게임을 끝 직전에서 그만뒀을 때")
    void wrongFinishFinal() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U","D","D", "Q");
            assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }


   @Test
   @DisplayName("성공적으로 종료가 됬는지, 다리 끝까지 도착한 경우")
    void isSuccessFinal(){
        int bridgeSize=3;
        int idx =bridgeSize;
        successFinish = bridgeSize == idx && !moveStop;
        String result = GameState.GAME_FAIL;
        if(successFinish){
            result = GameState.GAME_SUCCESS;
        }
       Assertions.assertThat(result).isEqualTo(GameState.GAME_SUCCESS);
    }

    @Test
    @DisplayName("실패되는 종료가 됬는지 확인, 끝에 도달하지 않고 Q 입력시 종료의 경우")
    void isFailFinalCase1(){
        int bridgeSize=2;
        int idx =1;
        successFinish = bridgeSize == idx && !moveStop;
        String result = GameState.GAME_FAIL;
        if(successFinish){
            result = GameState.GAME_SUCCESS;
        }
        Assertions.assertThat(result).isEqualTo(GameState.GAME_FAIL);
    }

    @Test
    @DisplayName("실패되는 종료가 됬는지 확인, 끝에 도달하지 않고 Q 입력시 종료의 경우")
    void isFailFinalCase2(){
        int bridgeSize=2;
        int idx =1;
        successFinish = bridgeSize == idx && moveStop;
        String result = GameState.GAME_FAIL;
        if(successFinish){
            result = GameState.GAME_SUCCESS;
        }
        Assertions.assertThat(result).isEqualTo(GameState.GAME_FAIL);
    }

    @Test
    @DisplayName("실패되는 종료가 됬는지 확인, 끝에 도달했는데 실패하여 종료해야 하는 경우")
    void isFailFinalCase3(){
        int bridgeSize=2;
        int idx =1;
        successFinish = bridgeSize == idx && moveStop;
        String result = GameState.GAME_FAIL;
        if(successFinish){
            result = GameState.GAME_SUCCESS;
        }
        Assertions.assertThat(result).isEqualTo(GameState.GAME_FAIL);
    }


    @ParameterizedTest
    @ValueSource(strings = {"E", "123", "J"})
    @DisplayName("게임 재시작 종료 판별, 종료시 예외 입력시 오류 발생")
    void judgeRestartOrOverException(String input) {
        Validate validate = new Validate();
        Assertions.assertThatThrownBy(() -> {
            validate.validateGameDefinition(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
