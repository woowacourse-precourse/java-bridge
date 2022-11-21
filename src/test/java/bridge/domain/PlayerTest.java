package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest{

    @Test
    void 성공케이스() {
        String inputSpring = "U";
        Player player = new Player(inputSpring);
        assertThat(player.getNextCurrent()).isEqualTo(inputSpring);
    }

    @Test
    void 소문자가_들어온_경우(){
        String inputSpring = "d";
        assertThatThrownBy(() -> new Player(inputSpring))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_들어온_경우(){
        String inputSpring = "123";
        assertThatThrownBy(() -> new Player(inputSpring))
                .isInstanceOf(IllegalArgumentException.class);
    }
}