package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeUserInputComparatorTest {

    private BridgeUserInputComparator bridgeUserInputComparator = new BridgeUserInputComparator();

    @Test
    @DisplayName("길이가 0일때 비교하기")
    void compareWhenUserSizeZero() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D"));
        List<String> user = new ArrayList<>();
        assertThat(bridgeUserInputComparator.isPrevUserMoveRight(bridge, user)).isEqualTo(true);
    }

    @Test
    @DisplayName("길이가 0이 아닐때 비교하기")
    void compareUserBridge() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D"));
        List<String> user = new ArrayList<>(Arrays.asList("U"));

        assertThat(bridgeUserInputComparator.isNextUserMoveRight(bridge, user, "D")).isEqualTo(
                true);
    }

    @Test
    @DisplayName("마지막 다리인지 확인하기")
    void userInBridgeEnd() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "D"));
        List<String> user = new ArrayList<>(Arrays.asList("U", "D", "D"));

        assertThat(bridgeUserInputComparator.isUserInLastBridge(bridge, user)).isEqualTo(true);
    }

    @Test
    @DisplayName("마지막 다리가 일치하는지 확인하기")
    void userInLastBridge() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "D"));
        List<String> user = new ArrayList<>(Arrays.asList("U", "D", "D"));

        assertThat(bridgeUserInputComparator.isUserRightInLastBridge(bridge, user)).isEqualTo(true);
    }
}