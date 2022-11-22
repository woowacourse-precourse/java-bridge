package bridge;

import static bridge.messages.error.inputE;
import static bridge.messages.words.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final InputView inputView = new InputView();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public List<String> move(List<String> makingBridge, String status, String movingState) {
        List<String> inputResult = new ArrayList<>();
        if(movingState.equals(up)){
            inputResult=chooseUp(makingBridge,status);
        }
        if(movingState.equals(down)){
            inputResult=chooseDown(makingBridge,status);
        }
        return inputResult;
    }

    private List<String> chooseUp(List<String> makingBridge, String status){
        List<String> inputResult = new ArrayList<>();
        if(makingBridge.get(0).length()<=3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+status+closing);
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+" "+closing);
        }
        if(makingBridge.get(0).length()>3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+partition+status+closing);
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+partition+" "+closing);
        }
        return inputResult;
    }
    private List<String> chooseDown(List<String> makingBridge, String status){
        List<String> inputResult = new ArrayList<>();
        if(makingBridge.get(1).length()<=3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+" "+closing);
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+status+closing);
        }
        if(makingBridge.get(1).length()>3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+partition+" "+closing);
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+partition+status+closing);
        }
        return inputResult;
    }

    public static String rightOrWrong(List<String> bridge, String movingState, int idx){
        if(bridge.get(idx).equals(movingState)){
            return right;
        }
        return wrong;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restartCommand) {
        checkCommand(restartCommand);
        if(restartCommand.equals(quit)){
            return false;
        }
        return true;
    }

    private void checkCommand(String restartCommand) {
        if(!restartCommand.equals(quit) && !restartCommand.equals(restart)){
            throw new IllegalArgumentException(inputE);
        }
    }
}
