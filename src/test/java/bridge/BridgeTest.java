package bridge;

import bridge.model.Bridge;
import bridge.model.Player;
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

    @DisplayName("유저의 선택과 answerBridge 비교 결과 테스트 - ")
    @Test
    void compareToTest_empty() {
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

    @DisplayName("유저가 끝까지 도달했을 경우 테스트")
    @Test
    void isApproachEndTest() {
        player.addChoice("U");
        player.addChoice("D");
        player.addChoice("U");
        boolean result = bridge.isApproachEndPoint(player.getChoices());
        assertThat(result).isTrue();
    }

    @DisplayName("유저가 현재 선택한 결과를 반환하는 함수 테스트")
    @Test
    void isCorrect() {
        player.addChoice("U");
        boolean result = bridge.isCorrectChoice(player.getStep(), player.getLastChoice());
        assertThat(result).isTrue();

        player.addChoice("U");
        result = bridge.isCorrectChoice(player.getStep(), player.getLastChoice());
        assertThat(result).isFalse();
    }
}
