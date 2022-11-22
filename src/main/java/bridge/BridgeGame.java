package bridge;
import java.util.ArrayList;
import java.util.List;
public class BridgeGame {
    public List<String> move(List<String> makingBridge, String status, String movingState) {
        List<String> inputResult = new ArrayList<>();
        if(movingState.equals("U")){
            inputResult=chooseUp(makingBridge,status);
        }
        if(movingState.equals("D")){
            inputResult=chooseDown(makingBridge,status);
        }
        return inputResult;
    }
    private List<String> chooseUp(List<String> makingBridge, String status){
        List<String> inputResult = new ArrayList<>();
        if(makingBridge.get(0).length()<=3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+status+" ]");
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+" "+" ]");
        }
        if(makingBridge.get(0).length()>3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+"| "+status+" ]");
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+"| "+" "+" ]");
        }
        return inputResult;
    }
    private List<String> chooseDown(List<String> makingBridge, String status){
        List<String> inputResult = new ArrayList<>();
        if(makingBridge.get(1).length()<=3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+" "+" ]");
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+status+" ]");
        }
        if(makingBridge.get(1).length()>3){
            inputResult.add(makingBridge.get(0).substring(0,makingBridge.get(0).length()-1)+"| "+" "+" ]");
            inputResult.add(makingBridge.get(1).substring(0,makingBridge.get(1).length()-1)+"| "+status+" ]");
        }
        return inputResult;
    }
    public static String rightOrWrong(List<String> bridge, String movingState, int idx){
        if(bridge.get(idx).equals(movingState)){
            return "O";
        }
        return "X";
    }
    public boolean retry(String restartCommand) {
        checkCommand(restartCommand);
        if(restartCommand.equals("Q")){
            return false;
        }
        return true;
    }
    private void checkCommand(String restartCommand) {
        if(!restartCommand.equals("Q") && !restartCommand.equals("R")){
            throw new IllegalArgumentException("[ERROR] 허용된 입력은 Q or R 입니다.");
        }
    }
}