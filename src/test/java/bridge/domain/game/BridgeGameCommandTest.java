package bridge.domain.game;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.game.BridgeGameCommand;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BridgeGameCommandTest {
    
    @DisplayName("해당 인수가 command에 포함되면 true를 반환한다.")
    @EnumSource(BridgeGameCommand.class)
    @ParameterizedTest
    void isContainByValid(BridgeGameCommand command) {
        assertThat(BridgeGameCommand.isContain(command.getCommand())).isEqualTo(true);
    }
    
    @DisplayName("해당 인수가 command에 포함되지 않으면 false를 반환한다.")
    @Test
    void isContainByInvalid() {
        assertThat(BridgeGameCommand.isContain("A")).isEqualTo(false);
    }
    
    @DisplayName("해당 인수가 command에 맞는 BridgeGameCommand Enum을 반환한다.")
    @EnumSource(BridgeGameCommand.class)
    @ParameterizedTest
    void findByCommandByValid(BridgeGameCommand command) {
        assertThat(BridgeGameCommand.findByCommand(command.getCommand())).isEqualTo(Optional.of(command));
    }
    
    @DisplayName("해당 인수가 command에 맞는 BridgeGameCommand Enum이 없을 때 Empty를 반환한다.")
    @Test
    void findByCommandByInvalid() {
        assertThat(BridgeGameCommand.findByCommand("A")).isEqualTo(Optional.empty());
    }
}
