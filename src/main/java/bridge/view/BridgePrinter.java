package bridge.view;

import bridge.domain.BridgeGame;
import bridge.vo.Commend;

import java.util.ArrayList;
import java.util.List;

public class BridgePrinter {

    private final static String START = "[";
    private final static String CORRECT = " O ";
    private final static String INCORRECT = " X ";
    private final static String BLANK = "   ";
    private final static String BOARDER = "|";
    private final static String END = "]";

    private List<String> user;
    private List<String> bridge;

    public void print(BridgeGame bridgeGame) {
        this.user = bridgeGame.getUser().getMovings();
        this.bridge = bridgeGame.getBridge().getRoads();
        printLineByDirection(Commend.UP);
        printLineByDirection(Commend.DOWN);
    }

    private void printLineByDirection(String direction) {
        StringBuilder sb = new StringBuilder();
        sb.append(START);
        for (String s : makeLineElement(direction)) {
            sb.append(s).append(BOARDER);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(END);
        System.out.println(sb.toString());
    }

    private ArrayList<String> makeLineElement(String direction){
        ArrayList<String> lineElements = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            makeElements(direction, lineElements, i);
        }
        return lineElements;
    }

    private void makeElements(String direction, ArrayList<String> lineElements, int i) {
        if(!user.get(i).equals(direction)){
            lineElements.add(BLANK);
            return;
        }
        if(user.get(i).equals(bridge.get(i)))
            lineElements.add(CORRECT);
        if(!user.get(i).equals(bridge.get(i)))
            lineElements.add(INCORRECT);
    }
}
