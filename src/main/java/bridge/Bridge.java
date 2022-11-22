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
        // 출력 // 윗 라인, 아래라인 나눠서 print(윗라인, 아래라인) 전송송

        outputView.printMap(getUpLineResult(checkIdx, isCorrectSpot), getDownLineResult(checkIdx, isCorrectSpot));

        return isCorrectSpot;
    }

    private String getUpLineResult(int idx, boolean lastIdxResult){
        String result = "";
        for(int i = 0; i < idx; i++){
            if(bridge.get(i).equals("U"))
                result += "O | ";
            else
                result += "  | ";
        }

        if(lastIdxResult) {
            if(bridge.get(idx).equals("U"))
                result += "O";
            else
                result += " ";
        }
        else {
            if (bridge.get(idx).equals("U"))
                result += " ";
            else
                result += "X";
        }

        return result;
    }

    private String getDownLineResult(int idx, boolean lastIdxResult){
        String result = "";
        for(int i = 0; i < idx; i++){
            if(bridge.get(i).equals("D"))
                result += "O | ";
            else
                result += "  | ";
        }

        if(lastIdxResult) {
            if(bridge.get(idx).equals("D"))
                result += "O";
            else
                result += " ";
        }
        else {
            if (bridge.get(idx).equals("D"))
                result += " ";
            else
                result += "X";
        }

        return result;
    }

    public boolean isLastSpot(int currentPosition) {
        return currentPosition == bridge.size() - 1;
    }
}
