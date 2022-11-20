package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int placeNumber = 0;
    private String restart = "";
    private int gameRepeatCount = 0;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public void playGame() {
        outputView.printGameStart(); //다리 건너기 게임을 시작합니다 출력
        //여기서부터 게임 시작
        int bridgeSize = inputView.readBridgeSize(); //InputView에서 다리 길이 입력받음
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator); // 다리를 생성하는 인스턴스 생성
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize); //InputView의 다리 길이를 전달받아서 BridgeMaker가 다리를 생성
        System.out.println(bridge);
        while (restart == null || !restart.equals("Q")) {
            playerChoice(bridge);
            retry();
        }
        outputView.printResult(successOrNot(), gameRepeatCount);
    }

    public String successOrNot() {
        if (placeNumber == 3) {
            return "성공";
        }
        return "실패";
    }

    public void clearBridgeMap(List<String> bridgeMap) {
        bridgeMap.clear();
    }

    private void playerChoice(List<String> bridge) {
        String playerMoving;
        for (String eachBridge : bridge) {
            playerMoving = inputView.readMoving();//1. 사용자가 U와 D중 하나를 입력한다
            outputView.printMap(playerMoving, eachBridge);
            if (!playerMoving.equals(eachBridge)) {//1-2)실패 시 해당 위치에 X를 출력하고 재시작 여부 입력 받음
                returnToStartPoint();
                clearBridgeMap(outputView.bridgeMap);
                break;
            }
            move();
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move() {
        placeNumber++;
    }

    public void returnToStartPoint() {
        placeNumber = 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        restart = "Q";
        if (placeNumber != 3) {
            gameRepeatCount++;
            restart = inputView.readGameCommand();
        }
    }
}
