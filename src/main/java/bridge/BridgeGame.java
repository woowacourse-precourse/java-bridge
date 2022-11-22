package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;  // 랜덤하게 생성된 생성된 bridge
    private List<List<String>> bridgeFormat = new ArrayList<>();    // 사용자의 이동 결과에 따른 bridge의 현재 상황이 저장된 리스트
    private int tryCount = 0;   // 게임의 시도 횟수를 저장하는 변수
    private boolean keepGoing;  // 게임의 진행 여부를 결정하는 변수

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryCount++;
        this.keepGoing = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동 결과에 따라 알맞은 '다리 모양 출력 형식'을 만들어 bridgeFormat 리스트에 추가한다.
     *
     * @param index 사용자가 건너고자 하는 다리의 인덱스 번호
     * @param chooseBridge "U", "D" 중 하나의 값
     * @return bridgeFormat 다리의 출력 형식
     */
    public void move(int index, String chooseBridge) {
        bridgeFormat.add(getBridgeFormatMember(index, chooseBridge));
    }

    /**
     * 사용자의 다리 칸 선택 결과에 따라 알맞은 Bridgeformat 값을 반환하는 메소드
     *
     * @param index 다리에서 몇 번째 칸인지를 의미
     * @param chooseBridge 사용자의 다리 이동 입력
     * @return
     */
    private List<String> getBridgeFormatMember(int index, String chooseBridge) {
        if (!bridge.get(index).equals(chooseBridge)) {
            setStopOption();
            return inputBridgeFormatMember(chooseBridge, "X");
        }
        return inputBridgeFormatMember(chooseBridge, "O");
    }

    /**
     * bridgeGame의 '진행 가능 상황'을 불가능으로 바꿔주는 메소드
     */
    private void setStopOption() {
        keepGoing = false;
    }

    /**
     * 사용자의 다리 칸 선택 결과에 따라 알맞은 bridgeFormat을 만드는 메소드
     *
     * @param chooseBridge 사용자의 다리 칸 선택
     * @param OX 사용자의 다리 칸 선택 결과("O" 또는 "X")
     * @return bridgeFormatMember
     */
    private List<String> inputBridgeFormatMember(String chooseBridge, String OX) {
        if (chooseBridge.equals("U")) {
            return Arrays.asList(new String[]{OX, " "});
        }
        if (chooseBridge.equals("D")) {
            return Arrays.asList(new String[]{" ", OX});
        }
        return inputBridgeFormatMember(chooseBridge, OX);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @param retryOrQuit
     * @return true or false
     */
    public boolean retry(String retryOrQuit) {
        if (retryOrQuit.equals("Q")) { return false; }
        if (retryOrQuit.equals("R")) {
            tryCount++; // 시도 횟수 증가
            keepGoing = true;   // 게임 지속 가능 상태 초기화
            bridgeFormat.clear();
            return true;
        }
        return retry(retryOrQuit);
    }

    /**
     * bridge의 현재 상태 출력에 필요한 출력 형식을 반환하는 메소드
     *
     * @return bridgeFormat
     */
    public List<List<String>> getBridgeFormat() { return bridgeFormat; }

    /**
     * 게임의 총 시도 횟수를 반환하는 메소드
     *
     * @return tryCount
     */
    public int getTryCount() { return tryCount; }

    /**
     * 게임의 지속 가능 여부를 반환하는 메소드
     *
     * @return keepGoing
     */
    public boolean isKeepGoing() { return keepGoing; }

    /**
     * 생성된 bridge의 크기를 반환하는 메소드
     *
     * @return
     */
    public int getBridgeSize() { return bridge.size(); }
}
