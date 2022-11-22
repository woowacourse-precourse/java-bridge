package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public String move(String location) {
        String result = "";
        BridgeRandomNumberGenerator randomLocation = new BridgeRandomNumberGenerator();
        int locationChk = 0, number = randomLocation.generate();
        if (location.matches("U")) {locationChk = 1;}
        if (location.matches("U")) {
            if (number == locationChk) {result = "UO";
            } else {result = "UX";}
        } else {
            if (number == locationChk) {result = "DO";}
            else {result = "DX";}
        }return result;
    }

    public void game(int size ,int retryNum ,List<String> upBridge ,List<String> downBridge) {
        InputView inputView = new InputView();
        OutputView ouputView =new OutputView();
        int restartNum = size;
        while(size > 0){
            String moved = move(inputView.readMoving());
            if(moved.charAt(0) == 'U'){
                upBridge = bridgeAddMove(moved , upBridge);
                downBridge =  bridgeAddElseMove(downBridge);
                ouputView.printMap(moved, upBridge, downBridge);
            }else {
                downBridge = bridgeAddMove(moved , downBridge);
                upBridge = bridgeAddElseMove(upBridge);
                ouputView.printMap(moved, upBridge, downBridge);
            }
            size--;
            if(moved.charAt(1) == 'X'){
                break;
            }
        }
        retryNum++;
        String a = inputView.readGameCommand();
        retry(a, restartNum ,upBridge ,downBridge, size,retryNum );
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String quitOrRestart , int restartNum, List<String> upBridge, List<String> downBridge ,int size, int retryNum) {
        BridgeNumberGenerator BridgeNumberGenerator = null;
        BridgeMaker BridgeMaker = new BridgeMaker(BridgeNumberGenerator);
        OutputView OuputView =new OutputView();
        if(Objects.equals(quitOrRestart, "Q")){
            OuputView.printResult(upBridge,downBridge, size, retryNum);
        }
        if(Objects.equals(quitOrRestart, "R")){
            List<String> upBridgeNew = BridgeMaker.makeBridge(restartNum);
            List<String> downBridgeNew = BridgeMaker.makeBridge(restartNum);
            game(restartNum, retryNum, upBridgeNew, downBridgeNew);
        }
    }

    public List<String> bridgeAddMove(String move,List<String> Bridge ) {
        List<String> result = new ArrayList<>();
        if(move.charAt(1) == 'O'){
            result =  BridgeAdd(Bridge ,1);
        }
        else {
            result =  BridgeAdd(Bridge ,0);
        }
        return result;
    }

    public List<String> bridgeAddElseMove(List<String> Bridge ) {
        List<String> result = BridgeAddElse(Bridge);
        return result;
    }

    public List<String> BridgeAdd(List<String> Bridge, int chk) {
        if(chk == 1){
            Bridge.add(" ");
            Bridge.add("O");
            Bridge.add(" ");
            Bridge.add("|");
        }
        else{
            Bridge.add(" ");
            Bridge.add("X");
            Bridge.add(" ");
            Bridge.add("|");
        }
        return Bridge;
    }

    public List<String> BridgeAddElse(List<String> Bridge) {
        Bridge.add(" ");
        Bridge.add(" ");
        Bridge.add(" ");
        Bridge.add("|");
        return Bridge;
    }
}

