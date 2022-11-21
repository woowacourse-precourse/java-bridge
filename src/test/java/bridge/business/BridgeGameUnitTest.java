package bridge.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameUnitTest {
    private BridgeGame bridgeGame;
    @BeforeEach
    public void setUp(){
        bridgeGame = new BridgeGame();
    }

    @DisplayName("다리 길이 값이 정상적으로 주어진 경우 해당 값을 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"})
    public void validateBridgeSize(int size){
        assertThat(bridgeGame.validateBridgeSize(size)).isEqualTo(size);
    }

    @DisplayName("다리 길이 값으로 숫자가 아닌 값이 주어진 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"삼", "사", "오", "문자", "!5", " 15","15 "})
    public void validateBridgeSizeByNotNumber(String size){
        assertThatThrownBy(()->bridgeGame.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 아닌 값이 입력되었습니다.");
    }

    @DisplayName("다리 길이 값이 허용 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"21", "22", "100", "0", "1", "2","-20"})
    public void validateBridgeSizeByExceedRange(String size){
        assertThatThrownBy(()->bridgeGame.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이가 허용 범위를 벗어났습니다.");
    }

    @DisplayName("이동 키 값이 정상적으로 주어진 경우 해당 값을 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    public void validateMovingKey(String movingKey){
        assertThat(bridgeGame.validateMovingKey(movingKey)).isEqualTo(movingKey);
    }

    @DisplayName("이동 키 값이 정해진 값이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"up", "down", "u", "d", "15"})
    public void validateMovingKeyByNotAllowed(String movingKey){
        assertThatThrownBy(()->bridgeGame.validateMovingKey(movingKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 이동 키 입니다.");
    }

    @DisplayName("재시도 키 값이 정상적으로 주어진 경우 해당 값을 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    public void validateRetryKey(String retryKey){
        assertThat(bridgeGame.validateRetryKey(retryKey)).isEqualTo(retryKey);
    }

    @DisplayName("재시도 키 값이 정해진 값이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"up", "down", "u", "d", "15"})
    public void validateRetryKeyByNotAllowed(String retryKey){
        assertThatThrownBy(()->bridgeGame.validateRetryKey(retryKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 재시도 키 입니다.");
    }

    @DisplayName("다리 이동을 위한 입력 값이 올바른 경우 해당 입력에 대한 결과값이 반환된다.")
    @ParameterizedTest
    @MethodSource("moveByCorrectMovingKeyParameter")
    public void moveByCorrectMovingKey(List<String> movingKeys, List<String> bridge,
                                       List<Boolean> result){
        bridgeGame.setBridge(bridge);

        for(int i=0;i<movingKeys.size();i++){
            assertThat(bridgeGame.move(movingKeys.get(i), i)).isEqualTo(result.get(i));
        }
    }

    @DisplayName("다리 이동을 위한 입력 인덱스 값이 다리 길이 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("moveByOutOfIndexParameter")
    public void moveByOutOfIndex(String movingKey, List<String> bridge,
                                       int index){
        bridgeGame.setBridge(bridge);

        assertThatThrownBy(()->bridgeGame.move(movingKey, index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("다리 이동을 위한 입력 키 값이 틀린 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("moveByInCorrectMovingKeyParameter")
    public void moveByInCorrectMovingKey(String movingKey, List<String> bridge,
                                 int index){
        bridgeGame.setBridge(bridge);

        assertThatThrownBy(()->bridgeGame.move(movingKey, index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 이동 키 입니다.");
    }

    @DisplayName("재시작을 위한 입력 키 올바른 경우 입력값에 대한 결과값이 반환된다.")
    @ParameterizedTest
    @MethodSource("retryByCorrectRetryKeyParameter")
    public void retryByCorrectRetryKey(String retryKey, boolean value){
        assertThat(bridgeGame.retry(retryKey)).isEqualTo(value);
    }

    @DisplayName("재시작을 위한 입력 키 값이 틀린 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"hi", "retry", "1", "$","r","q"})
    public void retryByInCorrectRetryKey(String retryKey){
        assertThatThrownBy(()->bridgeGame.retry(retryKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 재시도 키 입니다.");
    }

    private static Stream<Arguments> moveByCorrectMovingKeyParameter(){
        return Stream.of(
                Arguments.of(
                        List.of("U","U","D"),
                        List.of("U","U","U","D"),
                        List.of(true, true, false)
                        ),
                Arguments.of(
                        List.of("U","D","D"),
                        List.of("U","U","U","D"),
                        List.of(true, false, false)
                ),
                Arguments.of(
                        List.of("U","U","D", "D"),
                        List.of("U","U","U","D"),
                        List.of(true, true, false, true)
                )
        );
    }

    private static Stream<Arguments> moveByOutOfIndexParameter(){
        return Stream.of(
                Arguments.of("U", List.of("U","U","U","D"), 4),
                Arguments.of("U", List.of("U","U","U","D"), 5),
                Arguments.of("U", List.of("U","U","U","D"), -1),
                Arguments.of("U", List.of("U","U","U","D"), -100),
                Arguments.of("U", List.of("U","U","U","D"), 500)
        );
    }

    private static Stream<Arguments> moveByInCorrectMovingKeyParameter(){
        return Stream.of(
                Arguments.of("u", List.of("U","U","U","D"), 3),
                Arguments.of("d", List.of("U","U","U","D"), 3),
                Arguments.of("업", List.of("U","U","U","D"), 3),
                Arguments.of("다운", List.of("U","U","U","D"), 3),
                Arguments.of("UP", List.of("U","U","U","D"), 3),
                Arguments.of("DOWN", List.of("U","U","U","D"), 3)
        );
    }

    private static Stream<Arguments> retryByCorrectRetryKeyParameter(){
        return Stream.of(
                Arguments.of("R", true),
                Arguments.of("Q", false)
        );
    }
}
