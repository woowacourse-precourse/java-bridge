package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    Bridge bridge = new Bridge(List.of("U", "D", "U"));
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("플레이어의 선택이 맞는 선택인지 확인하는 테스트")
    @Test
    void compareToTest() {
        List<Boolean> firstResult = makeSituation("U");
        assertThat(firstResult).isEqualTo(List.of(true));

        List<Boolean> secondResult = makeSituation("D");
        assertThat(secondResult).isEqualTo(List.of(true, true));

        List<Boolean> thirdResult = makeSituation("D");
        assertThat(thirdResult).isEqualTo(List.of(true, true, false));
    }

    private List<Boolean> makeSituation(String choice) {
        player.addChoice(choice);
        return bridge.compareTo(player.getChoices());
    }


}
