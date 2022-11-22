package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCommandTest {

    @Test
    @DisplayName("존재하는 command 는 GameCommand 타입으로 변환한다.")
    void validCommands() {
        // given
        List<String> validCommands = Arrays.stream(GameCommand.values())
            .map(GameCommand::getCommand)
            .collect(Collectors.toList());
        // then
        validCommands.forEach(
            command -> assertThat(GameCommand.values()).contains(GameCommand.of(command)));
    }

    @Test
    @DisplayName("존재하지 않는 command 를 변환하면 예외가 발생한다.")
    void invalidCommands() {
        // given
        List<String> invalidCommands = List.of("C", "Retry", "F", "1");

        // then
        invalidCommands.forEach(command -> assertThatThrownBy(() -> GameCommand.of(command)));

    }
}