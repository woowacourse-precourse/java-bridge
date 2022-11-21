package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.ResultMap;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class BridgeGameTest {
    BridgeGame bridgeGameCase;

    @DisplayName("다리 길이를 입력받을 때 3~20 이외의 입력값은 검증 후 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {0, 21})
    void 다리_길이_입력값이_3에서_20_사이가_아니면_예외처리하는_기능_테스트(int input) {
        //given
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();

        //when
        Throwable result = catchThrowable(()->{new BridgeGame(generator, input);});

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 선택한 방향으로 움직일 수 있게 한다.")
    @ParameterizedTest
    @MethodSource("successMoveCommands")
    void 플레이어가_입력한_방향으로_움직이는_기능_테스트(List<String> moveCommands) {
        //given
        for(String command : moveCommands){
            bridgeGameCase.move(command);
        }

        //when
        List<String> result = bridgeGameCase.getRoundMaps().get(ResultMap.DIRECTION_MAP.index());

        //then
        assertThat(result).isEqualTo(moveCommands);
    }

    @DisplayName("플레이어가 움직이고 난 후 결과 지도를 계산한다.")
    @ParameterizedTest
    @MethodSource("MoveCommandsAndResultSignMap")
    void 플레이어가_움직인_후_결과지도를_계산하는_기능_테스트(List<String> moveCommands, List<String> resultSignMap) {
        //given
        for(String command : moveCommands){
            bridgeGameCase.move(command);
        }

        //when
        List<String> result = bridgeGameCase.getRoundMaps().get(ResultMap.SIGN_MAP.index());

        //then
        assertThat(result).isEqualTo(resultSignMap);
    }

    @DisplayName("게임 오버 여부를 판단한다.")
    @ParameterizedTest
    @MethodSource("MoveCommandsAndExpectedGameOver")
    void 플레이어가_움직인_후_게임오버_여부를_판단하는_기능_테스트(List<String> moveCommands, boolean expected) {
        //given
        for(String command : moveCommands){
            bridgeGameCase.move(command);
        }

        //when
        boolean result = bridgeGameCase.isGameOver();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("게임 성공 여부를 판단한다.")
    @ParameterizedTest
    @MethodSource("MoveCommandsAndExpectedGameCompleted")
    void 플레이어가_다리를_건너는_데_성공했는지_여부를_판단하는_기능_테스트(List<String> moveCommands, boolean expected) {
        //given
        for(String command : moveCommands){
            bridgeGameCase.move(command);
        }

        //when
        boolean result = bridgeGameCase.isGameCompleted();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("미리 설정된 다리를 유지하면서 게임을 재시작한다.")
    @ParameterizedTest
    @MethodSource("MoveCommandsAndResultSignMap")
    void 미리_설정된_다리를_유지하며_게임을_재시작하는_기능_테스트(List<String> moveCommands, List<String> resultSignMap) {
        //given
        bridgeGameCase.retry();
        for(String command : moveCommands){
            bridgeGameCase.move(command);
        }

        //when
        List<String> result = bridgeGameCase.getRoundMaps().get(ResultMap.SIGN_MAP.index());

        //then
        assertThat(result).isEqualTo(resultSignMap);
    }

    @DisplayName("총 시도한 횟수를 계산한다.")
    @Test
    void 총_시도한_횟수를_계산하는_기능_테스트() {
        //given
        bridgeGameCase.retry();
        bridgeGameCase.retry();
        //when
        int result = bridgeGameCase.getTotalAttempt();

        //then
        assertThat(result).isEqualTo(3);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

    @BeforeEach
    void beforeEach(){
        bridgeGameCase = new BridgeGame(new TestNumberGenerator(newArrayList(0,1,1)),3);
    }

    static Stream<Arguments> successMoveCommands(){
        return Stream.of(
                Arguments.of(Arrays.asList("D", "U", "U"))
        );
    }
    static Stream<Arguments> MoveCommandsAndResultSignMap(){
        return Stream.of(
                Arguments.of(Arrays.asList("D", "U", "U"), Arrays.asList("O", "O", "O")),
                Arguments.of(Arrays.asList("D", "U", "D"), Arrays.asList("O", "O", "X"))
        );
    }

    static Stream<Arguments> MoveCommandsAndExpectedGameOver(){
        return Stream.of(
                Arguments.of(Arrays.asList("D", "U", "U"), false),
                Arguments.of(Arrays.asList("D", "D"), true)
        );
    }

    static Stream<Arguments> MoveCommandsAndExpectedGameCompleted(){
        return Stream.of(
                Arguments.of(Arrays.asList("D", "U", "U"), true),
                Arguments.of(Arrays.asList("D", "D"), false)
        );
    }
}