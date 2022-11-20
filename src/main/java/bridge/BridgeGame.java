package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final int MINBRIDGELEN = 3;
    private final int MAXBRIDGELEN = 20;
    private final String UP = "U";
    private final String DOWN = "D";
    private final String RESTART = "R";
    private final String QUIT = "Q";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> visited = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Validate validate = new Validate();
    Bridge bridge;
    private int tryNum = 1;

    public void init(){
        String input = inputView.readBridgeSize();
        validate.validateNumberRange(input, MINBRIDGELEN, MAXBRIDGELEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }
    /**
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        String direction = inputView.readMoving();
        validate.validateContainWord(direction,UP,DOWN);
        visited.add(direction);
        printUpBridge();
        printDownBridge();
        int idx = visited.size()-1;
        return bridge.isRightDirection(idx, direction);
    }

    private void printDownBridge() {
        List<String> downString = new ArrayList<>();
        for(int i=0; i<visited.size(); i++){
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i,DOWN, rightDirection);
            downString.add(result);
        }
        outputView.printMap(downString);
    }

    private void printUpBridge() {
        List<String> upString = new ArrayList<>();
        for(int i=0; i<visited.size(); i++){
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i,UP, rightDirection);
            upString.add(result);
        }
        outputView.printMap(upString);
    }

    private String getResult(int i, String direction, boolean rightDirection) {
        String result = "X";
        if(rightDirection){
            result = "O";
        }
        if(!visited.get(i).equals(direction)){
            result =" ";
        }
        return result;
    }

    public boolean isGameCompleted(){
        if(bridge.isCrossedBridge(visited)){
            return true;
        }
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        String select = inputView.readGameCommand();
        validate.validateContainWord(select,RESTART,QUIT);
        if(select.equals("R")){
            reStartInit();
            return true;
        }
        return false;
    }

    public void reStartInit(){
        visited = new ArrayList<>();
        tryNum += 1;
    }

    public void printGameResult(){
        outputView.printEnding();
        printUpBridge();
        printDownBridge();
        boolean isSuccess = bridge.isCrossedBridge(visited);
        String result = "실패";
        if(isSuccess){
            result = "성공";
        }
        outputView.printResult(result,tryNum);
    }

}
