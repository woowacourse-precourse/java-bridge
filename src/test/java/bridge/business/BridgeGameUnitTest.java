package bridge.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameUnitTest {
    private BridgeGame bridgeGame;
    @BeforeEach
    public void setUp(){
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"})
    public void validateBridgeSize(int size){
        assertThat(bridgeGame.validateBridgeSize(size)).isEqualTo(size);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"삼", "사", "오", "문자", "!5", " 15","15 "})
    public void validateBridgeSizeByNotNumber(String size){
        assertThatThrownBy(()->bridgeGame.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 아닌 값이 입력되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "22", "100", "0", "1", "2","-20"})
    public void validateBridgeSizeByExceedRange(String size){
        assertThatThrownBy(()->bridgeGame.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이가 허용 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    public void validateMovingKey(String movingKey){
        assertThat(bridgeGame.validateMovingKey(movingKey)).isEqualTo(movingKey);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"up", "down", "u", "d", "15"})
    public void validateMovingKeyByNotAllowed(String movingKey){
        assertThatThrownBy(()->bridgeGame.validateMovingKey(movingKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 이동 키 입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    public void validateRetryKey(String retryKey){
        assertThat(bridgeGame.validateRetryKey(retryKey)).isEqualTo(retryKey);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"up", "down", "u", "d", "15"})
    public void validateRetryKeyByNotAllowed(String retryKey){
        assertThatThrownBy(()->bridgeGame.validateRetryKey(retryKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 재시도 키 입니다.");
    }
}
