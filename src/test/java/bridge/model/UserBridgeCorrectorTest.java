package bridge.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserBridgeCorrectorTest {

    @Test
    void addBridgeTest() {
        String up = "U";
        List<String> userSelectResult = new ArrayList<>();
        List<String> ComputerResult = new ArrayList<>();
        ComputerResult.add(up);
        UserBridgeCorrector userBridgeCorrector = new UserBridgeCorrector();
        assertThat(userBridgeCorrector.addBridge(up, userSelectResult)).isEqualTo(ComputerResult);
    }//checkTest
}// end class
