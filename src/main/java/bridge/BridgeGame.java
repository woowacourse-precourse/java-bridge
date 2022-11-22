package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static int numberOfTry = 1;
    public static int round = 1;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        InputView input = new InputView();
        String direction = input.readMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        numberOfTry += 1;
    }

    public void gameStart() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        OutputView output = new OutputView();
        InputView input = new InputView();
        output.printGameStart();
        int sizeOfBridge = input.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(sizeOfBridge);
        playGame(bridge);
    }
    public void playGame(List<String> bridge){
        OutputView output = new OutputView();
        InputView input = new InputView();
        while(true){
            String move = input.readMoving();
            boolean match = judgeMatch(bridge.get(round-1),move);
            if(!match){output.printFailMap(bridge,move);
                if (playGameWhenNotMatch(bridge,move) == "Q"){break;}
                retry();
            } playGameWhenMatch(bridge,match,move);
            if (judgeSuccess(bridge)){break;}
        }
    }

    public String judgeSuccessOrFail(List<String> bridge){
        if (bridge.size() == round){
            return "성공";
        }
        return "실패";
    }

    public boolean judgeSuccess(List<String> bridge){
        if (bridge.size() == round){
            return true;
        }
        return false;
    }

    public boolean judgeMatch(String bridgeElement,String inputMove){
        if (bridgeElement == inputMove){
            return true;
        }
        return false;
    }

    public void playGameWhenMatch(List<String> bridge, boolean match, String move){
        OutputView output = new OutputView();
        if (match) {
            output.printSuccessMap(bridge, match);
            if (judgeSuccess(bridge)) {
                output.printResult(bridge, move);
            }
            round += 1;
        }
    }
    public String playGameWhenNotMatch(List<String> bridge, String move){
        OutputView output = new OutputView();
        InputView input = new InputView();
        output.printFailMap(bridge,move);
        if (input.readGameCommand() == "Q"){
            output.printResult(bridge,move);
        }
        return input.readGameCommand();
    }


}
