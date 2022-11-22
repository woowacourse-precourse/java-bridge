package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final String BLANK = " ";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";

    public List<String> playerBridge;
    public List<String> randomBridge;
    public List<String> resultUpBridge;
    public List<String> resultDownBridge;

    private Boolean playResult;
    private int position;


    public Bridge(List<String> randomBridge) {
        this.randomBridge = randomBridge;

        playerBridge = new ArrayList<>();
        resultUpBridge = new ArrayList<>();
        resultDownBridge = new ArrayList<>();

        playResult = true;
        position = 0;
    }

    public Boolean getPlayResult() {
        return playResult;
    }

    void runBridge(String inputLocation){
        playResult = checkBridge(inputLocation);
        makeResultBridge(playResult, inputLocation);
        checkBridgeLength();
    }

    void clearPlayerBridge(){
        playerBridge.clear();
        resultUpBridge.clear();
        resultDownBridge.clear();
        position = 0;
    }

    private Boolean checkBridge(String inputLocation){
        playerBridge.add(inputLocation);
        String state = playerBridge.get(position) + randomBridge.get(position);
        for (BridgeConstant bridgeconstant : BridgeConstant.values()){
            if(bridgeconstant.getPlayAndComLocation().equals(state)){
                return bridgeconstant.successStatus;
            }
        }
        throw new IllegalArgumentException(Errors.OPERATION_FAIL.getMessage());
    }

    private void makeResultBridge(Boolean playResult, String inputLocation){
        isUpBridgeTrue(playResult, inputLocation);
        isUpBridgeFalse(playResult, inputLocation);
        isDownBridgeTrue(playResult, inputLocation);
        isDownBridgeFalse(playResult, inputLocation);
        position ++;
    }

    void isUpBridgeTrue(Boolean playResult, String location){
        if (playResult.equals(true)&&location.equals("U")){
            resultUpBridge.add(CORRECT);
            resultDownBridge.add(BLANK);
        }
    }

    void isUpBridgeFalse(Boolean playResult, String location){
        if (playResult.equals(false)&&location.equals("U")){
            resultUpBridge.add(WRONG);
            resultDownBridge.add(BLANK);

        }
    }

    void isDownBridgeTrue(Boolean playResult, String location){
        if (playResult.equals(true)&&location.equals("D")){
            resultUpBridge.add(BLANK);
            resultDownBridge.add(CORRECT);
        }
    }

    void isDownBridgeFalse(Boolean playResult, String location){
        if (playResult.equals(false)&&location.equals("D")){
            resultUpBridge.add(BLANK);
            resultDownBridge.add(WRONG);
        }
    }

    void checkBridgeLength(){
        if (playerBridge.size() == randomBridge.size()){
            playResult = false;
        }
    }
}
