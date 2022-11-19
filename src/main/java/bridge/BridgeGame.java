package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String RETRY = "R";

    private final List<String> stageBridge;
    private List<String> playLog;
    private int currentPosition;
    private int playCount;

    public BridgeGame(List<String> stageBridge) {
        this.stageBridge = stageBridge;
        this.playLog = new ArrayList<>();
        this.currentPosition = 0;
        this.playCount = 1;
    }

    public int getBridgeSize(){
        return this.stageBridge.size();
    }

    public int getPlayCount() {
        return playCount;
    }

    public final List<String> getPlayLog() {
        return playLog;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param userMove 유저가 입력한 이동 메시지
     * @throws IllegalStateException 이동할 수 없는데 입력이 들어온 경우
     * @return 유저가 움직이는데 성공하였는지 반환 (true : 이동 성공, false : 이동 실패)
     */
    public boolean move(String userMove) {
        if(currentPosition == stageBridge.size())
            throw new IllegalStateException("더 이상 이동할 수 없습니다.");
        playLog.add(userMove);
        return stageBridge.get(currentPosition++).equals(userMove);
    }

    /**
     * 사용자가 다시 게임을 시작할지 확인하는 메서드
     * @param userInput 유저가 입력한 게임 재시작 확인 메서드 (R : 재시작, Q : 종료)
     * @return 재시작을 하는지에 대한 여부 반환
     */
    public boolean retry(String userInput) {
        if(userInput.equals(RETRY)) {
            playLog.clear();
            currentPosition = 0;
            playCount++;
            return true;
        }

        return false;
    }
}
