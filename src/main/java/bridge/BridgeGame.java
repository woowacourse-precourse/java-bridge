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

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Validate validate = new Validate();
    private List<String> visited = new ArrayList<>();
    private Bridge bridge;
    private int tryNum = 1;
    private boolean isSuccess=true;

    public void init(String input){
        validate.validateNumberRange(input, MINBRIDGELEN, MAXBRIDGELEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }

    public boolean move(String direction) {
        validate.validateContainWord(direction,UP,DOWN);
        visited.add(direction);
        return bridge.isRightDirection(visited.size()-1, direction);
    }

    public List<String> getDownBridge() {
        List<String> downBridge = new ArrayList<>();
        for(int i=0; i<visited.size(); i++){
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i,"D", rightDirection);
            downBridge.add(result);
        }
        return downBridge;
    }

     public List<String> getUpBridge() {
        List<String> upBridge = new ArrayList<>();
        for(int i=0; i<visited.size(); i++){
            boolean rightDirection = bridge.isRightDirection(i, visited.get(i));
            String result = getResult(i,"U", rightDirection);
            upBridge.add(result);
        }
        return upBridge;
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

