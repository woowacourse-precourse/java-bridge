package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @DisplayName("다리의 길이 만큼 리스트를 생성해주는 테스트")
    @Test
    public void BridgeConstructorTest() {
        List<String> randomBridges = List.of("U","U");

        Bridge bridge = new Bridge(randomBridges);

        assertThat(bridge.getBridge().size()).isEqualTo(randomBridges.size());
    }
    @DisplayName("현재 인덱스를 0으로 설정해주는 테스트")
    @Test
    public void resetIndexTest() {
        Bridge bridge = new Bridge(List.of("U","D","U"));

        bridge.nextIndex();

        bridge.resetIndex();

        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("다음 인덱스로 넘어가는 테스트")
    @Test
    public void nextIndexTest() {
        Bridge bridge = new Bridge(List.of("U","D","U","D","U"));

        bridge.nextIndex();
        bridge.nextIndex();

        assertThat(bridge.getNowIndex()).isEqualTo(2);
    }

    @DisplayName("마지막 인덱스인지 확인해주는 테스트")
    @Test
    public void lastIndexTest() {
        Bridge bridge = new Bridge(List.of("U","D"));

        bridge.nextIndex();
        boolean lastIndex = bridge.isEndPoint();

        assertThat(lastIndex).isTrue();

    }

    @DisplayName("유저의 첫번째 요소에 대한 값과 컴퓨터의 첫 번째 요소에 대한 값이 같은지 확인시켜주는 테스트")
    @Test
    public void isSameValueOfUserAndComputerTest() {
        String userMoveInput = "U";
        Bridge computerBridge = new Bridge(List.of("U"));

        boolean checkSameValueOfUserAndComputer = computerBridge.getBridge().get(0).equals(userMoveInput);

        assertThat(checkSameValueOfUserAndComputer).isTrue();

    }
}
