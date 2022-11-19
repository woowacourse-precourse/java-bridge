package bridge;

import java.util.Objects;

public class BridgeShape {

    private final String UP_BRIDGE ="U";
    private final String DOWN_BRIDGE = "D";
    private final String PASS_STEP = " O ";
    private final String FAIL_STEP = " X ";
    private final String EMPTY_STEP = "   ";
    private final String ONE_STEP_OPEN ="[";
    private final String ONE_STEP_CLOSE ="]";

    private final StringBuilder upBridgeShape = new StringBuilder();
    private final StringBuilder downBridgeShape = new StringBuilder();

    public void moveBridge(String whereBridge, boolean checkBridge){
        upBridgeShape.append(ONE_STEP_OPEN);
        downBridgeShape.append(ONE_STEP_OPEN);
        moveNextStep(whereBridge, checkBridge);
        upBridgeShape.append(ONE_STEP_CLOSE);
        downBridgeShape.append(ONE_STEP_CLOSE);
    }

    private void moveNextStep(String whereBridge, boolean checkBridge){

        if(Objects.equals(whereBridge, UP_BRIDGE)){
            moveUpBridge(checkBridge);
            notMoveDownBridge();
        }
        if(Objects.equals(whereBridge, DOWN_BRIDGE)){
            moveDownBridge(checkBridge);
            notMoveUpBridge();
        }

    }

    private void moveUpBridge(boolean checkBridge){
        if(checkBridge){
            upBridgeShape.append(PASS_STEP);
        }
        if(!checkBridge){
            upBridgeShape.append(FAIL_STEP);
        }

    }

    private void moveDownBridge(boolean checkBridge){
        if(checkBridge){
            downBridgeShape.append(PASS_STEP);
        }
        if(!checkBridge){
            downBridgeShape.append(FAIL_STEP);
        }
    }

    private void notMoveUpBridge(){
        upBridgeShape.append(EMPTY_STEP);
    }

    private void notMoveDownBridge(){
        downBridgeShape.append(EMPTY_STEP);
    }

    public void returnShape(){
        upBridgeShape.delete(0, upBridgeShape.length());
        downBridgeShape.delete(0, downBridgeShape.length());
    }

    public StringBuilder getUpBridge(){
        return upBridgeShape;
    }

    public StringBuilder getDownBridge(){
        return downBridgeShape;
    }
}
