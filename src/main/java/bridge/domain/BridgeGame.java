package bridge;

import bridge.domain.MapPrinting;
import bridge.domain.RestartProcess;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {



    List<String> moving = new ArrayList<>();
    List<Boolean> upPrint = new ArrayList<>();
    List<Boolean> downPrint = new ArrayList<>();

    OutputView outputView = new OutputView();
    static final int UP=1;
    static final int DOWN=0;
    RestartProcess restartProcess = new RestartProcess();
    private static int count=0;
    int nowIndex;
    boolean restart=false;
    InputView inputView = new InputView();
    List<String> mapBridge = new ArrayList<>();


    public BridgeGame(List<String> mapBridge) {
        this.mapBridge=mapBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> mapBridge, int bridgeSize) {
        int idx=0;
        clearInfo();
        while(idx<bridgeSize && !MapPrinting.isMoveStop()){
            System.out.println("mapBridge = " + mapBridge);
            moving.add(inputView.readMoving());
            setPrintBool(upPrint, downPrint, convertNowIndex(mapBridge.get(idx)));
            MapPrinting mapPrinting = getMapPrinting(upPrint,downPrint, moving.get(idx));
            idx++;
        }
        retry(idx,bridgeSize, mapBridge);
    }

    public void clearInfo(){
        moving.clear();
        upPrint.clear();
        downPrint.clear();
        MapPrinting.clearUpDownLocation();
    }

    private MapPrinting getMapPrinting(List<Boolean> upPrint, List<Boolean> downPrint,
        String nowIndex) {
        MapPrinting mapPrinting = new MapPrinting(upPrint, downPrint,convertNowIndex(nowIndex));
        mapPrinting.makeList();
        return mapPrinting;
    }

    private int convertNowIndex(String nowIndex) {
        if(nowIndex.equals("U")){
            return UP;
        }
        return DOWN;
    }

    private void setPrintBool(List<Boolean> upPrint, List<Boolean> downPrint, int upDown) {
        if(upDown==UP){
            upPrint.add(true);
            downPrint.add(false);
        }
        if(upDown==DOWN){
            upPrint.add(false);
            downPrint.add(true);
        }
    }




    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int idx,int bridgeSize, List<String> mapBridge) {
        count++;
        if (isReachFinal(idx, bridgeSize)) {
            return;
        }
        if (isRestartTrue(idx, bridgeSize, mapBridge)) {
            return;
        }
        isRightQuit(idx,bridgeSize);
    }

    private boolean isRestartTrue(int idx, int bridgeSize, List<String> mapBridge) {
        if(isRestart(idx, bridgeSize)){
            MapPrinting.setRestart();
            move(mapBridge, bridgeSize);
            return true;
        }
        return false;
    }

    private boolean isReachFinal(int idx, int bridgeSize) {
        if(!MapPrinting.isMoveStop()) {
            isRightQuit(idx, bridgeSize);
            return true;
        }
        return false;
    }

    private boolean isRestart(int idx, int bridgeSize) {

        return restartProcess.restart(idx, bridgeSize);
    }

    private void isRightQuit(int idx, int bridgeSize) {
        if(bridgeSize == idx && !MapPrinting.isMoveStop()){
            outputView.printResult(count, new MapPrinting(upPrint, downPrint, convertNowIndex(moving.get(idx -1))), true);
            return;
        }
        outputView.printResult(count, new MapPrinting(upPrint, downPrint, convertNowIndex(moving.get(idx -1))), false);
    }

}
