package bridge;

import java.util.List;
import model.Bridge;
import model.User;
import model.UserProgress;
import model.UserStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, User user, BridgeDirect userInput) {
        int nowIndex = user.getUserProgress().size();
        BridgeStatus result = compare(bridge, userInput, nowIndex);
        user.updateUsersProgress(userInput,result);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(User user) {
        user.setRetry();
    }

    private BridgeStatus compare(Bridge bridge, BridgeDirect userInput, int nowIndex) {
        List<String> generateBridge = bridge.getBridge();
        if (isMatchNowIndex(generateBridge, userInput, nowIndex)) {
            return BridgeStatus.CROSS_STATUS;
        }
        return BridgeStatus.NOT_CROSS_STATUS;
    }

    private boolean isMatchNowIndex(List<String> generateBridge, BridgeDirect userInputs, int nowIndex) {
        return generateBridge.get(nowIndex).equals(userInputs.getDirection());
    }

    public UserStatus getNowStatus(Bridge bridge, User user){
        List<UserProgress> userProgress = user.getUserProgress();
        int lastIndex = userProgress.size() - 1;
        if (isLastStatusEnd(userProgress, lastIndex)) {
            return UserStatus.END_STATUS;
        }
        if (isWin(bridge.getBridge(),userProgress,lastIndex)) {
            return UserStatus.WIN_STATUS;
        }
        return UserStatus.PLAYING_STATUS;
    }

    private boolean isWin(List<String> bridge, List<UserProgress> userProgress,int lastIndex) {
        BridgeStatus lastStatus = userProgress.get(lastIndex).getStatus();
        return bridge.size() == userProgress.size() && lastStatus==BridgeStatus.CROSS_STATUS;
    }


    private boolean isLastStatusEnd(List<UserProgress> userProgress, int lastIndex) {
        BridgeStatus lastStatus = userProgress.get(lastIndex).getStatus();
        return lastStatus.equals(BridgeStatus.NOT_CROSS_STATUS);
    }




}
