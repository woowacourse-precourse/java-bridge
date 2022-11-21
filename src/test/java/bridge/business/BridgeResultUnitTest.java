package bridge.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.*;


import java.util.List;
import java.util.stream.Stream;

public class BridgeResultUnitTest {
    private BridgeResult bridgeResult;
    @Mock
    private BridgeGame bridgeGame;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        bridgeResult = new BridgeResult(bridgeGame);
    }

    @DisplayName("정상적인 이동 키가 주어진 경우 BridgeResult의 결과 값이 제대로 갱신된다.")
    @ParameterizedTest
    @MethodSource("moveByCorrectMovingKeyParameter")
    public void moveByCorrectMovingKey(String movingKey, boolean success){
        //given
        int beforeResultBridgeSize = bridgeResult.getBridge().size();
        given(bridgeGame.move(movingKey, bridgeResult.getBridge().size())).willReturn(success);
        //when
        bridgeResult.move(movingKey);
        //then
        assertThat(bridgeResult.isSuccess()).isEqualTo(success);
        assertThat(bridgeResult.getBridge().size()).isEqualTo(beforeResultBridgeSize + 1);
    }

    @DisplayName("유효하지 않은 이동 키가 주어진 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"up", "down", "u", "d", "UP", "DOWN"})
    public void moveByCorrectMovingKey(String movingKey){
        assertThatThrownBy(() -> bridgeResult.move(movingKey))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 못한 이동 키 입니다.");
    }

    @DisplayName("refresh를 하면 재시도 횟수는 하나 증가하고 나머지 값들은 초기화된다.")
    @ParameterizedTest
    @MethodSource("refreshParameter")
    public void refresh(List<String> movingKeys, boolean success){
        //given
        int beforeTryCount = bridgeResult.getTryCount();
        int lastIndex = movingKeys.size()-1;

        given(bridgeGame.move(movingKeys.get(lastIndex), lastIndex))
                .willReturn(success);
        for(String movingKey : movingKeys){
            bridgeResult.move(movingKey);
        }
        assertThat(bridgeResult.isSuccess()).isEqualTo(success);
        assertThat(bridgeResult.getBridge().size()).isNotEqualTo(0);
        //when
        bridgeResult.refresh();
        //then
        assertThat(bridgeResult.getTryCount()).isEqualTo(beforeTryCount+1);
        assertThat(bridgeResult.getBridge().size()).isEqualTo(0);
        assertThat(bridgeResult.isSuccess()).isEqualTo(true);
    }

    private static Stream<Arguments> moveByCorrectMovingKeyParameter(){
        return Stream.of(
                Arguments.of("U", true),
                Arguments.of("U", false),
                Arguments.of("D", true),
                Arguments.of("D", false)
        );
    }

    private static Stream<Arguments> refreshParameter(){
        return Stream.of(
                Arguments.of(List.of("U","U","D"), false)
        );
    }
}
