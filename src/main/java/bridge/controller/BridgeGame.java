package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;

    public BridgeGame() {
    }

    public void start() {
        makeBridge();
        attemptCross();
    }

    public void makeBridge() {
        OutputView.printLine(Message.INTRO);
        OutputView.printLine("");
        OutputView.printLine(Message.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        this.bridge = new Bridge(size);
        this.user = new User();
        OutputView.printLine("");
    }

    public void attemptCross() {
        boolean tryAcross = true;
        while(tryAcross) {
            inOrderAcross();
            tryAcross = retry();
        }
        OutputView.printResult();
    }



    public void inOrderAcross() {
        for(int i=0 ; i<bridge.getSize() ; i++) {
            boolean movingResult = move(i);
            if(!movingResult) break;
        }
        // 성공로직
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int index) {
        // move를 boolean을 return 하도록 해도 될까
        OutputView.printLine(Message.INQUIRE_MOVE_BLOCK);
        String input = InputView.readMoving();
        boolean isSuccess = compareInputAndResult(input, bridge.getIndexResult(index));
        OutputView.printMap(bridge, user);
        return isSuccess;
    }

    public boolean compareInputAndResult(String input, String result) {
        if(input.equals(result)) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        OutputView.printLine(Message.INQUIRE_REGAIN_GAME);
        String decision = InputView.readGameCommand();
        if(decision.equals("Q")) {
            return false;
        }
        return true;
    }
}
