package bridge;

import Statements.BridgeShapes;
import Statements.NormalStatements;

public class OutputView {

    public void printMap(int movingTrials, int endOfBridges, String upOrDown) {
        printFirstUpOBridge(movingTrials, endOfBridges, upOrDown);
        printFirstDownOBridge(movingTrials, endOfBridges, upOrDown);
        printOngoingUpOBridge(movingTrials, endOfBridges, upOrDown);
        printOngoingDownOBridge(movingTrials, endOfBridges, upOrDown);
        printLastUpOBridge(movingTrials, endOfBridges, upOrDown);
        printLastDownOBridge(movingTrials, endOfBridges, upOrDown);
    }

    private void printFirstUpOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="U"&& movingTrials==1) {
            System.out.println(BridgeShapes.FIRST_O_BRIDGE.build());
            System.out.println(BridgeShapes.FIRST_EMPTY_BRIDGE.build());
        }
    }

    private void printFirstDownOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="D"&& movingTrials==1) {
            System.out.println(BridgeShapes.FIRST_EMPTY_BRIDGE.build());
            System.out.println(BridgeShapes.FIRST_O_BRIDGE.build());
        }
    }

    private void printOngoingUpOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="U"&& movingTrials!=1&& movingTrials!=endOfBridges) {
            System.out.println(BridgeShapes.FIRST_O_BRIDGE_OPENED.build());
            System.out.println(BridgeShapes.FIRST_EMPTY_BRIDGE_OPENED.build());
        }
    }

    private void printOngoingDownOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="D"&& movingTrials!=1 && movingTrials !=endOfBridges) {
            System.out.println(BridgeShapes.FIRST_EMPTY_BRIDGE_OPENED.build());
            System.out.println(BridgeShapes.FIRST_O_BRIDGE_OPENED.build());
        }
    }

    private void printLastUpOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="U"&& movingTrials==endOfBridges) {
            System.out.println(BridgeShapes.LAST_O_BRIDGE.build());
            System.out.println(BridgeShapes.LAST_EMPTY_BRIDGE.build());
        }
    }

    private void printLastDownOBridge(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="D"&& movingTrials==endOfBridges) {
            System.out.println(BridgeShapes.LAST_EMPTY_BRIDGE.build());
            System.out.println(BridgeShapes.LAST_O_BRIDGE.build());
        }
    }


    public void printFailedMap(int movingTrials, int endOfBridges, String upOrDown){
        if(upOrDown=="U"&& movingTrials==1) {
            BridgeShapes.FIRST_X_BRIDGE.build();
            BridgeShapes.FIRST_EMPTY_BRIDGE.build();
            return;
        }
        if(upOrDown=="D"&& movingTrials==1){
            BridgeShapes.FIRST_EMPTY_BRIDGE.build();
            BridgeShapes.FIRST_X_BRIDGE.build();
            return;
        }
        if(upOrDown=="U"&&movingTrials==endOfBridges){
            BridgeShapes.LAST_X_BRIDGE.build();
            BridgeShapes.LAST_EMPTY_BRIDGE.build();
            return;
        }
        if(upOrDown=="D"&&movingTrials==endOfBridges){
            BridgeShapes.LAST_EMPTY_BRIDGE.build();
            BridgeShapes.LAST_X_BRIDGE.build();
        }

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStatements(String printThis) {
        System.out.println(printThis);
    }
}
