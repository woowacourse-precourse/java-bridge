package bridge.domain;

import bridge.connector.Connector;

import java.util.ArrayList;
import java.util.List;

// 다리 건너기 게임을 관리하는 클래스
public class BridgeGame {

    private final List<String> randomBridge;
    private List<String> passHistory;

    // 클래스 기본 생성자, 랜덤으로 만들어진 randemBridge객체를 받는다.
    public BridgeGame (List<String> randomBridge) {
        this.randomBridge = randomBridge;
        this.passHistory = new ArrayList<>();
    }

    public List<String> getPassHistory () {
        return this.passHistory;
    }

    // 칸 이동을 관할하는 메소드, 이동이 끝났을 때는 false, 게속 진행할 때는 true를 반환한다.
    public boolean move(String choiceUpOrDown) {
        Connector connector = new Connector();
        clearBridge();

        if (!canPass(choiceUpOrDown)) return retry(connector);

        if (passHistory.size() == randomBridge.size()) {
            connector.setGameClear(true);
            return false;
        }
        return true;
    }

    // 잘못된 칸을 입력하고 재시작을 선택했을 때 기존의 passHistory리스트를 비워주는 메소드
    private void clearBridge() {

        if (passHistory.contains("DX") || passHistory.contains("UX")) {
            passHistory.clear();
        }
    }

    // 자신이 선택한 칸이 이동 가능한 칸인지 확인하는 메소드
    private boolean canPass (String choiceUpOrDown) {
        this.passHistory.add(choiceUpOrDown);

        return randomBridge.get(passHistory.size()-1).equals(choiceUpOrDown);
    }

    // 잘못된 칸을 선택했을 때 재시작할지 프로그램을 종료할지 선택하는 메소드
    public boolean retry(Connector connector) {
        connector.setGameClear(false);
        connector.setAttempt(1);

        addFailedRecord();

        return connector.selectRetry(passHistory);
    }

    // 잘못된 칸을 선택했을 때 선택한 칸이 틀린 칸인 걸 표시해주는 메소드
    private void addFailedRecord () {

        if(passHistory.get(passHistory.size()-1).equals("U")) {
            passHistory.set(passHistory.size()-1, "UX");
        }

        if(passHistory.get(passHistory.size()-1).equals("D")) {
            passHistory.set(passHistory.size()-1, "DX");
        }
    }
}
