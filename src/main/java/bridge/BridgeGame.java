package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<String> bridge;
    private List<String> movingList = new ArrayList<>();
    private int tryCount = 1;


    public void gameStart() {
        printStartMessage();
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                bridge = bridgeMaker.makeBridge(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean gamePlay() {
        if (!runGame()) {
            loseMessage();
            return true;
        }
        if(finishCount()){
            WinMessage();
            return true;
        }
        return false;
    }

    public void WinMessage(){
        endGameMassage();
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: "+tryCount);
    }

    public void loseMessage(){
        endGameMassage();
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: "+tryCount);
    }

    private void endGameMassage() {
        List<String> movingResult = getMovingResult(movingList, bridge);
        outputView.printResult(movingResult);
    }

    private void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        while (true) {
            try {
                movingList.add(inputView.readMoving());
                List<String> movingResult = getMovingResult(movingList, bridge);
                return isMoveSuccess(outputView.printMap(movingResult));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean runGame() {
        if (!move()) {

            String answer = retryQuestion();
            if (answer.equals("R")) {
                retry();
            }
            return !answer.equals("Q");
        }
        return true;
    }

    public boolean finishCount() {
        int movingCount = movingList.size();
        int bridgeSize = bridge.size();

        return movingCount == bridgeSize;
    }

    public boolean isMoveSuccess(List<String> resultMap) {
        for (int i = 0; i < resultMap.size(); i++) {
            String movingResult = resultMap.get(i);
            if (movingResult.contains("X")) {
                return false;
            }
        }
        return true;
    }

    public List<String> getMovingResult(List<String> movingList, List<String> bridge) {
        List<String> movingResult = new ArrayList<>();

        for (int i = 0; i < movingList.size(); i++) {
            String correctAnswer = bridge.get(i);
            String userAnswer = movingList.get(i);
            movingResult.add(getResult(correctAnswer, userAnswer));
        }
        return movingResult;
    }

    private String getResult(String correctAnswer, String userAnswer) {
        if (correctAnswer.equals(userAnswer)) {
            return userAnswer + ",O";
        }
        return userAnswer + ",X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movingList.clear();
        tryCount++;

    }

    public String retryQuestion() {
        return inputView.readGameCommand();
    }

}
