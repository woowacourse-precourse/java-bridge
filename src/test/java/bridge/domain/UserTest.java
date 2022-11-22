package bridge.domain;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;

import static bridge.util.Constants.OutputViewConstants.WHETHER_GAME_CLEAR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest extends NsTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
    }

    @DisplayName("isGameClear와 isRestartGame의 상태를 변경하고 true가 반환되어야 한다.")
    @Test
    void 플레이어_상태_변경_테스트() {
        boolean result = user.changeStatusIsFailed(false);
        assertEquals(result, true);
    }

    @DisplayName("플레이어에 대한 다리 정보를 Map에 저장한다.")
    @Test
    void 플레이어_다리_정보_저장() {
        user.addBridgeInfo(2, "U");
        assertEquals(user.getPastResult().get(2), "U");
    }

    @DisplayName("만약 R를 입력하면 게임 재시작 상태를 true, Q를 입력한다면 false로 상태를 변경한다.")
    @Test
    void 입력값에_따라_플레이어_상태_변경() {
        assertEquals(user.ifUserInputQStopGameOrElseRestart("R"), true);;
    }

    @DisplayName("게임 최종 결과 출력")
    @Test
    void 최종_다리_상태_출력() {
        user.printResult();
        assertThat(output()).contains(WHETHER_GAME_CLEAR.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}