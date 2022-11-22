package bridge.constant;

import static bridge.constant.GameCommand.R;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCommandTest {

    @Test
    void 입력된_문자열과_일치하는_커맨드_enum반환성공() throws Exception {
        GameCommand gameCommand = GameCommand.from("R");
        Assertions.assertThat(gameCommand).isEqualTo(R);
    }

}