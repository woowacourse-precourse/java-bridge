package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String location,  List<String>upBridge ,List<String> downBridge) {
        int locationChk = 0;
        BridgeRandomNumberGenerator randomLocation = new BridgeRandomNumberGenerator();
        int number = randomLocation.generate();
        if(location.equals('U'))locationChk = 1;
        if(number == 1){ // up
            if(number == locationChk){BridgeAdd(upBridge, 1); BridgeAddElse(downBridge);}
            else{BridgeAdd(upBridge, 0);BridgeAddElse(downBridge);}
        }
        else{ //down
            if(number == locationChk){BridgeAdd(downBridge, 1);BridgeAddElse(upBridge);}
            else{BridgeAdd(downBridge, 0);BridgeAddElse(upBridge);}
        }
        
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

}
