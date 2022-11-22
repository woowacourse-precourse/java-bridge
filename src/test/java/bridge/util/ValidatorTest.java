package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    private static final String BRIDGE_SIZE="12";
    private static final String OUT_OF_RANGE_BRIDGE_SIZE="21";
    private static final String WRONG_BRIDGE_SIZE="j1";
    private static final String WRONG_MOVING="K";
    private static final String WRONG_RETRY="P";
    @Test
    @DisplayName("입력이 정수일 때 true를 반환하는지 확인")
    void isDigit(){
        assertThat(Validator.isDigit(BRIDGE_SIZE)).isTrue();
    }
    @Test
    @DisplayName("입력이 정수가 아닌 경우 예외처리 확인")
    void isNotDigit(){
        assertThatThrownBy(()->Validator.isDigit(WRONG_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 정수여야 합니다.");
    }
    @Test
    @DisplayName("입력한 다리 길이가 3~20사이 일때 true 반환하는지 확인")
    void trueCheckBridgeRange(){
        assertThat(Validator.checkRange(BRIDGE_SIZE)).isTrue();
    }
    @Test
    @DisplayName("입력한 다리 길이가 3~20사이 일때 예외처리가 발생하는지 확인")
    void exceptionCheckBridgeRange(){
        assertThatThrownBy(()->Validator.checkRange(OUT_OF_RANGE_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
    @Test
    @DisplayName("입력받은 이동할 칸이 U 또는 D인경우 true 반환하는지 확인")
    void trueCheckMoving(){
        assertThat(Validator.checkMoving(Constants.MOVE_UP)).isTrue();
    }
    @Test
    @DisplayName("입력받은 이동할 칸이 U 또는 D가 아닌 경우 예외처리가 발생하는지 확인")
    void exceptionCheckMoving(){
        assertThatThrownBy(()->Validator.checkMoving(WRONG_MOVING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 U 또는 D를 입력해야 합니다.");
    }
    @Test
    @DisplayName("재시작 R 또는 종료 Q 입력 시 true 반환하는지 확인")
    void trueCheckRetry(){
        assertThat(Validator.checkRetryOrQuit(Constants.RETRY)).isTrue();
        assertThat(Validator.checkRetryOrQuit(Constants.QUIT)).isTrue();
    }
    @Test
    @DisplayName("재시작 R 또는 종료 Q 외의 값 입력 시 예외처리하는지 확인")
    void exceptionCheckRetry(){
        assertThatThrownBy(()->Validator.checkRetryOrQuit(WRONG_RETRY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] R(재시작) 또는 Q(종료)를 입력해야 합니다.");
    }
    @Test
    @DisplayName("다리길이의 범위 밖이거나 또는 정수가 아닌 경우 예외처리하는지 확인")
    void checkBridgeSize(){
        assertThatThrownBy(()->Validator.checkBridgeSize(OUT_OF_RANGE_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다.");
        assertThatThrownBy(()->Validator.checkBridgeSize(WRONG_BRIDGE_SIZE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 정수여야 합니다.");
    }
}