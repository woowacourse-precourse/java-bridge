package bridge;

import java.util.List;


public class BridgeGame {
    private static List<String> bridge;
    private int nowIdx;
    private int tryTimes;
    BridgeGame(){
        this.nowIdx = 0;
        this.tryTimes = 0;
    }

    public void setSize(int size){
        if(size<3||size>20)
            OutputView.errorHandling("3~20 사이의 숫자를 입력해주세요.");
        this.makeBridge(size);
    }

    private void makeBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker (null);
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean move(String userInput) {
        tryTimes++;
        if(userInput.equals(bridge.get(nowIdx))){
            nowIdx++;
            return true;
        }
        return false;
    }

    public boolean retry(String userInput) {
        if(userInput.equals("R")){
            return true;
        }
        return false;
    }

    public static List<String> getBridge(){
        return bridge;
    }
}
