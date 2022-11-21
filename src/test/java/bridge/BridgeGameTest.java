package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import model.Bridge;
import model.User;
import model.UserProgress;
import model.UserStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("[move] 유저의 입력값을 기준으로 이동할때 성공케이스")
    void moveSuccess() {
        //given
        Bridge bridge = new Bridge(Arrays.asList(BridgeDirect.UP.getDirection(),
                BridgeDirect.DOWN.getDirection(),
                BridgeDirect.DOWN.getDirection()));
        User user = new User();
        //when
        bridgeGame.move(bridge,user, BridgeDirect.UP);
        //then
        UserProgress nowUserProgress = user.getUserProgress().get(0);
        Assertions.assertThat(nowUserProgress.getDirect()).isEqualTo(BridgeDirect.UP);
        Assertions.assertThat(nowUserProgress.getStatus()).isEqualTo(BridgeStatus.CROSS_STATUS);
    }

    @Test
    @DisplayName("[move] 유저의 입력값을 기준으로 이동할때 실패 케이스")
    void moveFail() {
        //given
        Bridge bridge = new Bridge(Arrays.asList(BridgeDirect.UP.getDirection(),
                BridgeDirect.DOWN.getDirection(),
                BridgeDirect.DOWN.getDirection()));
        User user = new User();
        //when
        bridgeGame.move(bridge, user, BridgeDirect.DOWN);
        //then
        UserProgress nowUserProgress = user.getUserProgress().get(0);
        Assertions.assertThat(nowUserProgress.getDirect()).isEqualTo(BridgeDirect.DOWN);
        Assertions.assertThat(nowUserProgress.getStatus()).isEqualTo(BridgeStatus.NOT_CROSS_STATUS);
    }

    @Test
    @DisplayName("[isEnd] 유저의 상태가 게임이 끝난경우 테스트")
    void isEnd(){
        //given
        Bridge bridge = new Bridge(Arrays.asList(BridgeDirect.UP.getDirection(),
                BridgeDirect.DOWN.getDirection(),
                BridgeDirect.DOWN.getDirection()));
        User user = new User();
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.NOT_CROSS_STATUS);
        //when
        //then
        Assertions.assertThat(bridgeGame.getNowStatus(bridge,user)).isEqualTo(UserStatus.END_STATUS);
    }

    @Test
    @DisplayName("[isEnd] 유저의 상태가 게임이 끝나지 않은 경우(진행중) 테스트")
    void isPlaying(){
        //given
        Bridge bridge = new Bridge(Arrays.asList(BridgeDirect.DOWN.getDirection(),
                BridgeDirect.UP.getDirection(),
                BridgeDirect.DOWN.getDirection()));
        User user = new User();
        user.updateUsersProgress(BridgeDirect.DOWN, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        //when
        //then
        Assertions.assertThat(bridgeGame.getNowStatus(bridge,user)).isEqualTo(UserStatus.PLAYING_STATUS);
    }

    @Test
    @DisplayName("[isEnd] 유저의 상태가 게임을 이긴경우")
    void isWin(){
        //given
        Bridge bridge = new Bridge(Arrays.asList(BridgeDirect.DOWN.getDirection(),
                BridgeDirect.UP.getDirection(),
                BridgeDirect.DOWN.getDirection()));
        User user = new User();
        user.updateUsersProgress(BridgeDirect.DOWN, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.DOWN, BridgeStatus.CROSS_STATUS);
        //when
        //then
        Assertions.assertThat(bridgeGame.getNowStatus(bridge,user)).isEqualTo(UserStatus.WIN_STATUS);
    }


    @Test
    @DisplayName("[retry] 유저가 retry를 선택한 경우 유저의 상태 초기화 확인")
    void retry(){
        //given
        User user = new User();
        user.updateUsersProgress(BridgeDirect.DOWN, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.UP, BridgeStatus.CROSS_STATUS);
        user.updateUsersProgress(BridgeDirect.DOWN, BridgeStatus.CROSS_STATUS);
        user.updateStatus(UserStatus.END_STATUS);
        user.updateCommand(User.COMMAND_RETRY);
        //when
        bridgeGame.retry(user);
        //then
        assertThat(user.getRetryCount()).isEqualTo(2);
        assertThat(user.getUserProgress().size()).isEqualTo(0);
        assertThat(user.getStatus()).isEqualTo(UserStatus.PLAYING_STATUS);
        assertThat(user.getCommand()).isEqualTo(null);
    }
}