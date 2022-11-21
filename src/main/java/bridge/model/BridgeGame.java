package bridge.model;

import java.util.List;

/**
 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 BridgeGame의 패키지는 변경할 수 있다.
 BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private static final String END_STRING = "]";
    private static final String ORDER_UP = "U";
    private static final String RIGHT_ORDER = " O |";
    private static final String FALSE_ORDER = " X |";
    private static final String NOTHING_ORDER = "   |";

    private List<String> bridge;
    private int bridgePoint;
    private StringBuilder usb;
    private StringBuilder dsb;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
        resetBridge();
    }

    public boolean move(String input) {
        boolean flag = bridge.get(++bridgePoint).equals(input);
        drawCaseSelect(flag, input);
        return flag;
    }

    public void retry() {
        resetBridge();
    }

    public int getBridgeLength(){
        return this.bridge.size();
    }

    public void resetBridge(){
        bridgePoint = -1;
        usb = new StringBuilder("[");
        dsb = new StringBuilder("[");
    }

    public String getBridgeMap(){
        return usb.substring(0,usb.length()-1) + END_STRING + "\n" +
                dsb.substring(0,dsb.length()-1) + END_STRING;
    }

    public int getBridgePoint(){
        return this.bridgePoint;
    }

    public void drawCaseSelect(boolean flag, String input){
        if(input.equals(ORDER_UP)){
            drawMap(usb,dsb,flag);
            return;
        }

        drawMap(dsb,usb,flag);
    }

    public void drawMap(StringBuilder sb1, StringBuilder sb2, boolean flag){
        sb2.append(NOTHING_ORDER);

        if(flag){
            sb1.append(RIGHT_ORDER);
            return;
        }

        sb1.append(FALSE_ORDER);
    }
}
