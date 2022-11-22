package bridge.service;

import bridge.service.itf.CheckService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.BridgePrintTool;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckServiceTest {
    CheckService checkService;

    @BeforeEach
    void beforeEach() {
        checkService = new CheckServiceImpl();
    }

    @DisplayName("사용자의 입력 방향과 건널 수 있는 다리가 일치하는지 확인")
    @Nested
    class isMatchTest {
        List<String> bridgeInfo = List.of("U", "D", "U");
        int idx = 0;

        @DisplayName("일치하는 경우")
        @Test
        void match() {
            List<String> userDirection = List.of("U");
            String actual = checkService.isMatch(bridgeInfo, idx, userDirection);
            String expect = BridgePrintTool.MATCH;
            assertThat(actual).isEqualTo(expect);
        }

        @DisplayName("일치하지 않는 경우")
        @Test
        void not_match() {
            List<String> userDirection = List.of("D");
            String actual = checkService.isMatch(bridgeInfo, idx, userDirection);
            String expect = BridgePrintTool.NOT_MATCH;
            assertThat(actual).isEqualTo(expect);
        }
    }

}
