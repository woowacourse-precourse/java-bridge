package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Judge;
import bridge.model.BridgeSize;
import bridge.model.MoveResult;
import bridge.model.Moving;
import bridge.view.Input;
import bridge.view.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    Input input;
    Output output;

    List<String> bridge = new ArrayList<>();
    List<String> userBridge = new ArrayList<>();

    Judge judge = new Judge();

    public BridgeGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {

        // 사용자에게 다리길이를 입력 받는다

        BridgeSize bridgeSize = null;
        do {
            try {
                bridgeSize = new BridgeSize(input.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (bridgeSize == null);


        // 다리리스트를 생성하고 사용자가 입력한 길이만큼 랜덤번호가 0이면 D를 1이면 U를 반복하여 담아준다
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());


        // 사용자의 결과값을 알려줄 결과다리리스트를 생성한다
        userBridge = new ArrayList<>();

        // 사용자에게 이동할 칸을 입력 받아서 유저 다리리스트에 담아준다
        moveAndAddToUserBridge();
        printMapResult();


    }


    private void moveAndAddToUserBridge() {
        MoveResult moveResult;
        do {
            moveResult = move();
        } while (moveResult == MoveResult.CORRECT && userBridge.size() != bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move() {
        Moving moving = input.readMoving();
        userBridge.add(moving.getValue());
        return judge.checkIsCorrectMoving(bridge, userBridge);
    }


    private void printMapResult() {
        judge.makeResult(bridge, userBridge);
        output.printMap(judge.toString());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


}
