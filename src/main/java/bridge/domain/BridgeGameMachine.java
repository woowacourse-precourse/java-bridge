package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.input.InputView;
import bridge.output.OutputView;
import java.util.List;

public class BridgeGameMachine {

    public void run() {
        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();

        boolean gameSuccess = true;
        int gameCount = 0;
        String restartVariable = "";

        Loop1:
        while (!(restartVariable.equals("R"))) {

            String str1 = "[ ";
            String str2 = "[ ";

            Loop2:
            for (int i = 0; i < designBridge.size() - 1; i++) {

                gameCount++;

                String moveLocation = inputView.readMoving();

                String discriminant = bridgeGame.move(moveLocation, designBridge.get(i));

                if (moveLocation.equals("U") && discriminant.equals("O")) {
                    str1 += discriminant;

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str1 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str1 += " | ";
                    }

                    // TODO: 여기서 부터는 str2 관한 부분

                    str2 += " ";

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str2 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str2 += " | ";
                    }

                }

                // TODO: U == X 경우
                if (moveLocation.equals("U") && discriminant.equals("X")) {
                    gameSuccess = false;
                    str1 += discriminant;

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str1 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str1 += " | ";
                    }

                    str2 += " ";

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str2 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str2 += " | ";
                    }


                }

                if (moveLocation.equals("D") && discriminant.equals("O")) {
                    str2 += discriminant;

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str2 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str2 += " | ";
                    }

                    // TODO: 여기서부터는 str1 관한 부분
                    str1 += " ";

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str1 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str1 += " | ";
                    }
                }

                //TODO: D == X인 경우
                if (moveLocation.equals("D") && discriminant.equals("X")) {
                    gameSuccess = false;
                    str2 += discriminant;

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str2 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str2 += " | ";
                    }

                    str1 += " ";

                    if (designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1) {
                        str1 += " ]";
                    }

                    if (!(designBridge.get(i + 1).equals("1") || designBridge.get(i + 1).equals("X") || i == designBridge.size() - 1)) {
                        str1 += " | ";
                    }
                }



                outputView.printMap(str1, str2);



                if (str1.contains("X") || str2.contains("X")) {

                    System.out.println("재시작/종료 입력받기: ");
                    String reStart = inputView.readGameCommand();

                    if (reStart.equals("Q")) {
                        outputView.printResult(str1, str2, gameCount, gameSuccess);
                        restartVariable = "R";
                        break;
                    }

                    //TODO: 문제점
                    if (reStart.equals("R")) {
                        gameSuccess = true;
                        str1 = "";
                        str2 = "";
                        break Loop2;
                    }
                }


                //TODO: 성공 출력
                if (i == designBridge.size() -2) {
                    System.out.println("게임 성공 로직 메시지");
                    outputView.printResult(str1, str2, gameCount, gameSuccess);
                    restartVariable = "R";
                    break;
                }

            }
        }
    }
}
