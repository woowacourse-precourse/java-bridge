package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String RETRY = "R";

    private final List<String> stageBridge;
    private final List<String> playLog;
    private int currentPosition; // 현재 비교 위치
    private int tryCount; // 게임 플레이 횟수

    public BridgeGame(List<String> stageBridge) {
        this.stageBridge = stageBridge;
        this.playLog = new ArrayList<>();

        resetFields();
    }

    /**
     * 새로운 게임을 할 수 있도록 설계될 수 있으므로 확장 가능하도록 필드를 reset하는 함수 구분
     */
    private void resetFields(){
        this.playLog.clear();
        this.currentPosition = 0;
        this.tryCount = 1;
    }

    public int getBridgeSize(){
        return this.stageBridge.size();
    }
    public int getPlayLogSize(){
        return this.playLog.size();
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getPlayLogAtIndex(int index){
        return playLog.get(index);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param userMove 유저가 입력한 이동 메시지
     * @throws IllegalStateException 이동할 수 없는데 입력이 들어온 경우
     * @return 유저가 움직이는데 성공하였는지 반환 (true : 이동 성공, false : 이동 실패)
     */
    public boolean move(String userMove) {
        if(currentPosition >= stageBridge.size())
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
            tryCount++;
            return true;
        }

        return false;
    }
}
