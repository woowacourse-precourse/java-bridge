package bridge.game;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.game.BridgeGameCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BridgeGameCommandTest {
    
    @DisplayName("해당 인수가 command에 포함되면 true를 반환한다.")
    @EnumSource
    @ParameterizedTest
    void isContainByValid(BridgeGameCommand command) {
        assertThat(BridgeGameCommand.isContain(command.getCommand())).isEqualTo(true);
    }
    
    @DisplayName("해당 인수가 command에 포함되지 않으면 false를 반환한다.")
    @Test
    void isContainByInvalid() {
        assertThat(BridgeGameCommand.isContain("A")).isEqualTo(false);
    }
}
