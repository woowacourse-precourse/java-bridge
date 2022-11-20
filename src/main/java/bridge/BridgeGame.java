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

    List<String> visited = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Validate validate = new Validate();
    Bridge bridge;
    private int tryNum = 1;
    private boolean isSuccess=true;

    public void init(String input){
        validate.validateNumberRange(input, MINBRIDGELEN, MAXBRIDGELEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }
    /**
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String direction) {
        validate.validateContainWord(direction,UP,DOWN);
        visited.add(direction);
        return visited;

    }

    public boolean isRightDirection(int idx, String direction) {
        return bridge.isRightDirection(idx, direction);
    }


    public String getResult(int i, String direction, boolean rightDirection) {
        String result = "O";
        if(!rightDirection){
            isSuccess = false;
            result = "X";
        }
        if(!visited.get(i).equals(direction)){
            result =" ";
        }
        return result;
    }

    public boolean isGameCompleted(){
        if(bridge.isCrossedBridge(visited) && isSuccess){
            return true;
        }
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String select) {
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
        isSuccess= true;
    }

    public int getTryNum(){
        return tryNum;
    }
    public String getGameResult(){
        String result = "실패";
        if(isGameCompleted()){
            result = "성공";
        }
        return result;
    }

}

