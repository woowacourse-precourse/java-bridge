package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    InputView inputview = new InputView();
    BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);
    OutputView outputView = new OutputView();
    public void printFinalGameResult(int location, List<String> moveRecord, String regame){
        System.out.println("최종 게임 결과");
        outputView.printFianlMap(location, moveRecord, regame);
    }

    public String gameRunning(int size, List<String> bridge){
        String regame = "";
        List<String> moveRecord = new ArrayList<>();
        int location = 0;

        while (regame.equals("")){
            if (location == size)
                break;
            moveRecord.add(inputview.readMoving());
            regame = move(moveRecord, bridge, location);
            location++;
        }
        printFinalGameResult(location, moveRecord, regame);
        return regame;
    }

    public void run (int size){
        List<String> bridge;
        String regame = "R";
        int count = 0;

        bridge = maker.makeBridge(size);
        while (regame.equals("R")){
            regame = gameRunning(size, bridge);
            count++;
        }
        outputView.printResult(count, regame);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String regameIsUp(List<String> moveRecord, List<String> bridge, int location){
        String regame = "";

        if (bridge.get(location).equals("U")) {
            outputView.printMapCorrect(moveRecord);
        }
        else if (!bridge.get(location).equals("U")){
            outputView.printMapIncorrect(location, moveRecord);
            inputview.printRegameMessage();
            regame = inputview.readGameCommand();
        }
        return regame;
    }

    public String regameIsDown(List<String> moveRecord, List<String> bridge, int location){
        String regame = "";

        if (bridge.get(location).equals("D")){
            outputView.printMapCorrect(moveRecord);
        }
        else if (!bridge.get(location).equals("D")){
            outputView.printMapIncorrect(location, moveRecord);
            inputview.printRegameMessage();
            regame = inputview.readGameCommand();
        }
        return regame;
    }
    public String move(List<String> moveRecord, List<String> bridge, int location) {
        String regame = "";

        if (moveRecord.get(location).equals("U")){
            regame = regameIsUp(moveRecord, bridge, location);
        }
        else if (moveRecord.get(location).equals("D")){
            regame = regameIsDown(moveRecord, bridge, location);
        }
        return regame;
    }
}
