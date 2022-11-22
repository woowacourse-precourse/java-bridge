package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.domain.Command;
import bridge.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ValidatorTest {

    @DisplayName("입력된 리스트의 길이가 주어진 범위에 속하는지 검증 (정상 처리)")
    @ParameterizedTest
    @MethodSource("rangeAndNormalList")
    void 입력된_리스트의_길이가_주어진_범위에_속하는지_검증하는_기능_정상_처리_테스트(int start, int end, List<Integer> list){
        //when
        Throwable result = catchThrowable(()->{
            Validator.validateListLengthInRange(list, start, end);
        });

        //then
        assertThat(result).doesNotThrowAnyException();
    }

    @DisplayName("입력된 리스트의 길이가 주어진 범위에 속하는지 검증 (예외 처리)")
    @ParameterizedTest
    @MethodSource("rangeAndExceptionalList")
    void 입력된_리스트의_길이가_주어진_범위에_속하는지_검증하는_기능_예외_처리_테스트(int start, int end, List<Integer> list){
        //when
        Throwable result = catchThrowable(()->{
            Validator.validateListLengthInRange(list, start, end);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 문자열이 둘 중 하나의 커맨드와 일치하는지 검증 (정상 처리)")
    @ParameterizedTest
    @MethodSource("normalInputAndCommands")
    void 입력된_문자열이_주어진_커맨드인지_검증하는_기능_정상_처리_테스트(String input, Command command1, Command command2){
        //when
        Throwable result = catchThrowable(()->{
            Validator.validateIsStringCommand(input, command1, command2);
        });

        //then
        assertThat(result).doesNotThrowAnyException();
    }

    @DisplayName("입력된 문자열이 둘 중 하나의 커맨드와 일치하는지 검증(예외 처리)")
    @ParameterizedTest
    @MethodSource("exceptionalInputAndCommands")
    void 입력된_문자열이_주어진_커맨드인지_검증하는_기능_예외_처리_테스트(String input, Command command1, Command command2){
        //when
        Throwable result = catchThrowable(()->{
            Validator.validateIsStringCommand(input, command1, command2);
        });

        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> rangeAndNormalList(){
        return Stream.of(
                Arguments.of(3, 5, Arrays.asList(1,2,3)),
                Arguments.of(3, 5, Arrays.asList(1,2,3,4)),
                Arguments.of(3, 5, Arrays.asList(1,2,3,4,5))
        );
    }

    static Stream<Arguments> rangeAndExceptionalList(){
        return Stream.of(
                Arguments.of(3, 5, Arrays.asList()),
                Arguments.of(3, 5, Arrays.asList(1,2)),
                Arguments.of(3, 5, Arrays.asList(1,2,3,4,5,6))
        );
    }

    static Stream<Arguments> normalInputAndCommands(){
        return Stream.of(
                Arguments.of("U", Command.MOVE_UP, Command.MOVE_DOWN),
                Arguments.of("D", Command.MOVE_UP, Command.MOVE_DOWN),
                Arguments.of("R", Command.RETRY_GAME, Command.QUIT_GAME),
                Arguments.of("Q", Command.RETRY_GAME, Command.QUIT_GAME)
        );
    }

    static Stream<Arguments> exceptionalInputAndCommands(){
        return Stream.of(
                Arguments.of(" ", Command.MOVE_UP, Command.MOVE_DOWN),
                Arguments.of("UDASDFHO", Command.MOVE_UP, Command.MOVE_DOWN),
                Arguments.of(" R Q", Command.RETRY_GAME, Command.QUIT_GAME),
                Arguments.of(" Q", Command.RETRY_GAME, Command.QUIT_GAME)
        );
    }
}