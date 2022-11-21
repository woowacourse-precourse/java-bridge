package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.CheckCrossBridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    static int bridgeSize;
     static String userInput;
    public static List<String> bridge;
    public static int round;
    static List<String> mark = new ArrayList<>();

    public void setting() { //입력값받기
        Print.gameStartMessage();
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.requestBridgeLengthMessage();
            try {
                bridgeSize = inputView.readBridgeSize();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }

    }

    public void make(){ //입력값만큼 다리 만들고 랜덤값 넣기
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.requestPickAPartOfBridgeMessage();
            try {
                userInput = inputView.readMoving();
                retryCheckNumber = 0;
                round++;
                System.out.println(round);
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }

    }

    /**
     * 사용자가 선택한 칸이 건널 수 있는 칸인지 확인하는 메서드
     */
    public boolean check(){
        CheckCrossBridge checkCrossBridge = new CheckCrossBridge();
        boolean crossPossible = checkCrossBridge.check(userInput, bridge, round);
        if (crossPossible == false){
            mark.add("X");
        }
        if(crossPossible == true){
            mark.add("O");
        }
        System.out.println("mark"+ mark);
        outputView.printMap(bridge, mark, round);
        return crossPossible;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        int retryCheckNumber = 1;
        round = 0;
        while (retryCheckNumber != 0) {
            Print.askRetryMessage();
            try {
                userInput = inputView.readGameCommand();
                retryCheckNumber = 0;
                System.out.println(round);
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }

    }
}
