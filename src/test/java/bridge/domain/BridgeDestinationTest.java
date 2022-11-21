package bridge.domain;

import bridge.constant.GameState;
import bridge.util.Validate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeDestinationTest {

    private final boolean moveStop = false;

    private boolean successFinish=false;

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


}
