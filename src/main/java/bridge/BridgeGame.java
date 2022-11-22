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
    public void retry() {
    }
    public String gameRunning(int size, List<String> bridge){
        String reGame = "";
        List<String> moveRecord = new ArrayList<>();
        int location = 0;

        while (reGame.equals("")){
            if (location == size)
                break;
            moveRecord.add(inputview.readMoving());
            reGame = move(moveRecord, bridge, location);
            location++;
        }
        printFinalGameResult(location, moveRecord, reGame);
        return reGame;
    }
    public void run (int size){
        List<String> bridge;
        String reGame = "R";
        int count = 0;

        bridge = maker.makeBridge(size);
        while (reGame.equals("R")){
            reGame = gameRunning(size, bridge);
            count++;
        }
        outputView.printResult(count, reGame);
    }

    public String regameIsUp(List<String> moveRecord, List<String> bridge, int location){
        String regame = "";

        if (bridge.get(location).equals("U")) {
            outputView.printMapCorrect(moveRecord);
        }
        else if (!bridge.get(location).equals("U")){
            outputView.printMapIncorrect(location, moveRecord);
            inputview.printReGameMessage();
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
            inputview.printReGameMessage();
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
