package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController();
        BridgeGame bridgeGame = new BridgeGame();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        outputView.printStart();
        Integer Bridge_size = inputView.readBridgeSize();
        List<String> Bridge = bridgeMaker.makeBridge(Bridge_size);


        Integer Number_of_Attempts = 1;
        Integer Sucess_Number = 0;

        while (true) {

            String User_Move = inputView.readMoving();
            List<String> User_Bridge = bridgeGameController.Make_User_Bridge(User_Move);
            boolean User_Move_isRight = bridgeGameController.Compare_User_Move_and_Bridge(User_Move, Bridge, Sucess_Number);
            outputView.printMap(User_Bridge, User_Move, User_Move_isRight);

            if (User_Move_isRight == false) {
                String GameCommand = inputView.readGameCommand();
                Number_of_Attempts++;
                if (GameCommand.equals("R")) {
                    bridgeGame.retry(User_Bridge);
                } else if (GameCommand.equals("Q")) {
                    outputView.printResult();
                    outputView.printMap(User_Bridge, User_Move, User_Move_isRight);
                    outputView.printFailEnd(Number_of_Attempts);
                    break;
                }
            } else {
                Sucess_Number = bridgeGame.move(Sucess_Number);
            }
            if (bridgeGameController.Bridge_length_isEqual(Bridge, User_Bridge)) {
                outputView.printResult();
                outputView.printMap(User_Bridge, User_Move, User_Move_isRight);
                outputView.printSuccessEnd(Number_of_Attempts);
                break;
            }

        }

        // TODO: 프로그램 구현
    }
}
