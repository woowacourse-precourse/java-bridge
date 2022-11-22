package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final OutputView outputView = new OutputView();

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        for(String i : bridge){
            System.out.print(i + " ");
        }
    }

    public boolean isCorrectSpot(int checkIdx, String spot){
        boolean isCorrectSpot = bridge.get(checkIdx).equals(spot);

        outputView.printMap(getUpLineResult(checkIdx, isCorrectSpot), getDownLineResult(checkIdx, isCorrectSpot));

        return isCorrectSpot;
    }

    public String getUpLineResult(int idx, boolean lastIdxResult){
        String result = "";
        result += createBridgeBeforeLastIndex(idx, "U");
        result += createBridgeAtLastIndex(idx, lastIdxResult, "U");

        return result;
    }

    public String getDownLineResult(int idx, boolean lastIdxResult){
        String result = "";
        result += createBridgeBeforeLastIndex(idx, "D");
        result += createBridgeAtLastIndex(idx, lastIdxResult, "D");

        return result;
    }

    private String createBridgeBeforeLastIndex(int idx, String UorD){
        String result = "";
        for(int i = 0; i < idx; i++){
            if(bridge.get(i).equals(UorD))
                result += "O | ";
            if(!bridge.get(i).equals(UorD))
                result += "  | ";
        }
        return result;
    }

    private String createBridgeAtLastIndex(int idx, boolean lastIdxResult, String UorD){
        String result ="";
        if(lastIdxResult) {
            result += createBridgeAtLastIndexAsSuccess(idx, UorD);
        }
        if(!lastIdxResult){
            result += createBridgeAtLastIndexAsFail(idx, UorD);
        }
        return result;
    }

    private String createBridgeAtLastIndexAsSuccess(int idx, String UorD){
        String result ="";
        if(bridge.get(idx).equals(UorD))
            result += "O";
        if(!bridge.get(idx).equals(UorD))
            result += " ";
        return result;
    }

    private String createBridgeAtLastIndexAsFail(int idx, String UorD){
        String result = "";
        if (bridge.get(idx).equals(UorD))
            result += " ";
        if (!bridge.get(idx).equals(UorD))
            result += "X";
        return result;
    }

    public boolean isLastSpot(int currentPosition) {
        return currentPosition == bridge.size() - 1;
    }
}
