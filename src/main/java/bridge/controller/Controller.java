package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.MapPrinting;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputView inputView= new InputView();
    private OutputView outputView = new OutputView();
    private int size= 0;
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private List<String> mapBridge = new ArrayList<>();
    static private BridgeGame bridgeGame;
    static private final int UP=1;
    static private final int DOWN=0;

    public Controller() {
        setMap();
    }

    public void setMap(){
        size = inputView.readBridgeSize();
        mapBridge = bridgeMaker.makeBridge(size);
    }

    public void play(){
        int idx=0;
        List<Boolean> upPrint = new ArrayList<>();
        List<Boolean> downPrint = new ArrayList<>();
        while(idx<size){
            System.out.println("mapBridge = " + mapBridge);
            String nowIndex = inputView.readMoving();
            setPrintBool(upPrint, downPrint, convertNowIndex(mapBridge.get(idx)));
            MapPrinting mapPrinting = new MapPrinting(upPrint,downPrint,convertNowIndex(nowIndex));
            mapPrinting.makeList();
            idx++;


        }
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


}
