package bridge.Model;

public class BridgeJudge {
    public static final BridgeJudge getInstance = new BridgeJudge();

    public void judgeInput(String userInput, String madeBridge, Bridge bridge) {
        if(userInput.equals(madeBridge)) {
            if(userInput.equals("U")) {
                bridge.updateUp("O");
                bridge.updateDown(" ");
            }
            if(userInput.equals("D")) {
                bridge.updateDown("O");
                bridge.updateUp(" ");
            }
        }

        if(!userInput.equals(madeBridge)) {
            if(userInput.equals("U")) {
                bridge.updateUp("X");
                bridge.updateDown(" ");
            }
            if(userInput.equals("D")) {
                bridge.updateDown("X");
                bridge.updateUp(" ");
            }
        }
    }
}
