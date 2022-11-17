package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;


    @BeforeEach
    void 객체_생성() {
        player = new Player();
    }

    @Test
    void 입력_정보_넘겨주는_테스트() {
        String inputInformation = player.sendInputInformation("U");
        Assertions.assertThat(inputInformation).isEqualTo("U");
    }

}