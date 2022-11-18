package bridge.service;

import bridge.view.OutputView;

import java.util.List;

public class BridgePrinter {

    private final OutputView outputView = new OutputView();
    private final Judge judge = new Judge();
    private StringBuilder upBridge;
    private StringBuilder downBridge;

    private void init(){
        upBridge = new StringBuilder();
        upBridge.append("[");
        downBridge = new StringBuilder();
        downBridge.append("[");
    }

    private void end(){
        upBridge.deleteCharAt(upBridge.length() - 1);
        upBridge.append("]");
        downBridge.deleteCharAt(downBridge.length() - 1);
        downBridge.append("]");
    }

    private void addUpBridge(String answer){
        upBridge.append(answer);
    }

    private void addDownBridge(String answer){
        downBridge.append(answer);
    }

    public void printStatus(List<String> bridge, List<String> playerMove){
        init();
        for(int index = 0; index < playerMove.size(); index++){
            makeUpBridge(bridge, playerMove, index);
            makeDownBridge(bridge, playerMove, index);
        }
        end();
        outputView.printMap(upBridge.toString(), downBridge.toString());
    }

    private void makeUpBridge(List<String> bridge, List<String> playerMove, int index) {
        if (playerMove.get(index).equals("U")) {
            addUpBridge(judge.isCorrect(bridge.get(index), playerMove.get(index)));
            addDownBridge("   |");
        }
    }

    private void makeDownBridge(List<String> bridge, List<String> playerMove, int index) {
        if (playerMove.get(index).equals("D")) {
            addDownBridge(judge.isCorrect(bridge.get(index), playerMove.get(index)));
            addUpBridge("   |");
        }
    }
}
