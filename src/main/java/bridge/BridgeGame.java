package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private List<String> listU = new ArrayList<String>();
    private List<String> listD = new ArrayList<String>();
    private int gameCount = 0;

    public List<String> getListU() {
        return listU;
    }

    public List<String> getListD() {
        return listD;
    }

    public int getGameCount() {
        return gameCount;
    }

    /**
     * 다리 길이만큼 생성된 U,D 무작위 List값 호출 (준비)
     * 
     * @return
     */
    public List<String> moveReady() {
        BridgeNumberGenerator generate = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generate);

        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    /**
     * 다리길이와 입력하는 입력값의 일치 여부 확인 (작동 시작)
     * 
     * @param moveReady
     * @return
     */
    public boolean move(List<String> moveReady) {
        for (int i = 0; i < moveReady.size(); i++) {
            String readMoving = inputView.readMoving();
            UD1(moveReady.get(i), readMoving);
            UD2(moveReady.get(i), readMoving);
            outputView.printMap(listU, listD);
            boolean isFail = isFailContains();
            if (isFail == true)
                return isRetryGame();
        }
        return false;
    }

    /**
     * Game 시작~종료
     */
    public void moveBridgeGame() {
        List<String> moveReady = moveReady();
        gameCount++;
        boolean isRetry = true;
        while (true) {
            isRetry = move(moveReady);
            if (isRetry == false)
                break;
        }
        outputView.printResult(moveReady, listU, listD);
        outputView.printResult2(gameCount);
    }

    /**
     * 게임 재시작 여부 확인,앞 round 게임 초기화
     * 
     * @return
     */
    public boolean isRetryGame() {
        if (retry() == true) {
            gameCount++;
            listU.clear();
            listD.clear();
            return true;
        }
        return false;
    }

    /**
     * 게임 실패 여부 검증
     * 
     * @return
     */
    public boolean isFailContains() {
        if (listU.contains("X") || listD.contains("X")) {
            return true;
        }
        return false;
    }

    /**
     * 게임 위/아래 진행 List 1
     * 
     * @param moveReady
     * @param readMoving
     */
    public void UD1(String moveReady, String readMoving) {
        if (moveReady.equals("D") && readMoving.equals("D")) {
            listU.add(" ");
            listD.add("O");
        }
        if (moveReady.equals("D") && readMoving.equals("U")) {
            listU.add("X");
            listD.add(" ");
            return;
        }
    }

    /**
     * 게임 위/아래 진행 List 2
     * 
     * @param moveReady
     * @param readMoving
     */
    public void UD2(String moveReady, String readMoving) {
        if (moveReady.equals("U") && readMoving.equals("U")) {
            listU.add("O");
            listD.add(" ");
        }
        if (moveReady.equals("U") && readMoving.equals("D")) {
            listU.add(" ");
            listD.add("X");
            return;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    /**
     * 게임 재시도/종료 입력(재시도: R, 종료: Q)
     * 
     * @return
     */
    public boolean retry() {
        if (inputView.readGameCommand().equals("R"))
            return true;
        return false;

    }
}
