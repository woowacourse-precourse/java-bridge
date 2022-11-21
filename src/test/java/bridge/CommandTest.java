package bridge;

import bridge.Model.WrappingType.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class CommandTest {
    @DisplayName("유효")
    @ParameterizedTest
    @ValueSource(strings = { "Q", "R" })
    void valid(String input){
        Command actual = new Command(input);
        assertThat(actual).isInstanceOf(Command.class);
    }

    @DisplayName("예외 ")
    @ParameterizedTest
    @ValueSource(strings = { "A", "e", "1", "안녕하세요", "-123" })
    void notValid(String input){
        assertThatThrownBy(()-> { new Command(input); })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
