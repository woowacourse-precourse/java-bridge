package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> stageBridge;
    private List<String> playLog;
    private int currentPosition = 0;

    public BridgeGame(List<String> stageBridge) {
        this.stageBridge = stageBridge;
        this.playLog = new ArrayList<>();
        this.currentPosition = 0;
    }

    public int getBridgeSize(){
        return this.stageBridge.size();
    }

    public final List<String> getPlayLog() {
        return playLog;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param userMove 유저가 입력한 이동 메시지
     * @throws IllegalStateException 이동할 수 없는데 입력이 들어온 경우
     * @return 유저가 움직이는데 성공하였는지 반환 true : 이동 성공, false : 이동 실패
     */
    public boolean move(String userMove) {
        if(currentPosition == stageBridge.size())
            throw new IllegalStateException("더 이상 이동할 수 없습니다.");
        playLog.add(userMove);
        return stageBridge.get(currentPosition++).equals(userMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드(필드 초기화)
     */
    public void retry() {
        playLog.clear();
        currentPosition = 0;
    }
}
