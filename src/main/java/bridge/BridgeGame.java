package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 // 사용자 입출력을 담
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private List<String> userUpNumbers ;
    private List<String> userDownNumbers ;
    private int bridgeSize;
    public BridgeGame() {
        this.userUpNumbers = new ArrayList<>(List.of());
        this.userDownNumbers = new ArrayList<>(List.of());
        this.bridgeSize = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(boolean result,String moveCommand) {
        if(result) {
            setUserAnswer(moveCommand," O ");
            return true;
        }
        setUserAnswer(moveCommand," X ");
        return false;
    }
    public void setUserAnswer(String moveCommand,String answer){
        if(moveCommand.equals("U"))
        {
            setUpCase(answer);
        }
        if(moveCommand.equals("D"))
        {
            setDownCase(answer);
        }
    }
    public void setUpCase(String answer){
        userUpNumbers.add(answer);
        userDownNumbers.add("   ");
    }
    public void setDownCase(String answer){
        userUpNumbers.add("   ");
        userDownNumbers.add(answer);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        if (userInput.equals("R")){
            return true;
        }
        if (userInput.equals("Q")){
            return false;
        }
        return false; // throw ex
    }
    public void initGame(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeNumbersGenrator(bridgeSize);
        bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> targetBridge = bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge();
        bridge.setTargetBridge(targetBridge);
    }
    public List<String> getBridge(){
        return bridge.getTargetBridge();
    }
    public int getBridgeSize() {
        return bridgeSize;
    }
    public void setBridgeSize(int bridgeLength){
        this.bridgeSize = bridgeLength;
    }
    public List<String> getUserUpNumbers(){
        return userUpNumbers;
    }
    public List<String> getUserDownNumbers(){
        return userDownNumbers;
    }
    public Bridge getBridgeInstance(){
        setBridgeSize(bridge.getTargetBridge().size());
        return bridge;
    }

    public void resetUserList() {
        this.userUpNumbers = new ArrayList<>(List.of());
        this.userDownNumbers = new ArrayList<>(List.of());
    }
}
