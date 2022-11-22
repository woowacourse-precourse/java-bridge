//package bridge.controller;
//
//import bridge.domain.GameCommand;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.NoSuchElementException;
//
//import static bridge.domain.GameCommand.QUIT;
//import static bridge.domain.GameCommand.RESTART;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//class GameCommandTest {
//    @DisplayName("command를 넘겨주면 GameState 가 반환된다")
//    @Test
//    void convertCommand() {
//        GameCommand restartCommand = GameCommand.parseCommandToInstance(RESTART.getCommand());
//        GameCommand quitCommand = GameCommand.parseCommandToInstance(QUIT.getCommand());
//
//        assertThat(restartCommand).isEqualTo(RESTART);
//        assertThat(quitCommand).isEqualTo(QUIT);
//    }
//
//    @DisplayName("지정되지 않은 값을 넘겨주면 예외가 발생한다.")
//    @ValueSource(strings = {"q", "r", "E", "A"})
//    @ParameterizedTest
//    void convertCommandFail(String command) {
//        assertThatThrownBy(() -> GameCommand.parseCommandToInstance(command))
//                .isInstanceOf(NoSuchElementException.class);
//    }
//}