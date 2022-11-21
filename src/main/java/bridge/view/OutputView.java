package bridge.view;

import java.util.List;

public class OutputView {

    private String upBridge = "[";
    private String downBridge = "[";

    public void printMap(List<String> bridge, int len, boolean flag) {
        initMap();
        if(flag == true) makeCorrectMap(bridge, len);
        if(flag == false) {
            makeCorrectMap(bridge, len-1);
            makeWrongMap(bridge, len);
        }
        printBridgeMap();
    }

    public void printResult(boolean flag, int count) {
        System.out.println(Message.RESULT_MESSAGE);
        printBridgeMap();
        if(flag == true)
            System.out.println(Message.RESULT_MESSAGE_IS_SUCCESS + "성공");
        if(flag == false)
            System.out.println(Message.RESULT_MESSAGE_IS_SUCCESS + "실패");
        System.out.printf("%s%d",Message.RESULT_MESSAGE_TOTAL_ATTEMPT,count);
    }

    private void printBridgeMap() {
        trimBridge();
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private void initMap() {
        this.upBridge = "[";
        this.downBridge = "[";
    }

    private void makeCorrectMap(List<String> bridge, int len) {
        for(int i = 0; i< len; i++){
            if(bridge.get(i).equals("U"))
                addUpBridgeO();
            if(bridge.get(i).equals("D"))
                addDownBridgeO();
        }
    }

    private void makeWrongMap(List<String> bridge, int len){
        if(bridge.get(len-1).equals("U"))
            addDownBridgeX();
        if(bridge.get(len-1).equals("D"))
            addUpBridgeX();
    }

    private void trimBridge() {
        upBridge = upBridge.substring(0, upBridge.length()-1) +"]";
        downBridge = downBridge.substring(0, downBridge.length()-1) + "]";
    }

    private void addUpBridgeO(){
        upBridge   += " O |";
        downBridge += "   |";
    }

    private void addUpBridgeX(){
        upBridge   += " X |";
        downBridge += "   |";
    }

    private void addDownBridgeO(){
        upBridge   += "   |";
        downBridge += " O |";
    }

    private void addDownBridgeX(){
        upBridge   += "   |";
        downBridge += " X |";
    }
}
