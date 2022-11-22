package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.type.Result;
import bridge.type.TextType;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        setGame();
    }

    public void setGame() {
        outputView.printStart();
        outputView.printSize();
        int size = readSize(false);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridges = bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridges);
    }

    public void playFirst() {
        while (true) {
            boolean correct = play();
            boolean go = true;
            if (!correct) go = checkPlay();
            if (!go) break;
            if (bridgeGame.getPos() == bridgeGame.getBridges().size()) {
                outputView.printResult(bridgeGame.getResults(), Result.SUCCESS,bridgeGame.getTryCount());
                break;
            }
        }
    }

    private boolean play() {
        outputView.printMove();
        String move = readMove(false);
        boolean correct = bridgeGame.move(move);
        outputView.printMap(bridgeGame.getResults());
        playFirst();
        return correct;
    }

    private boolean checkPlay() {
        outputView.printRestart();
        String command = readCommand(false);
        if (command.equals(TextType.RESTART.getText())) {
            bridgeGame.retry();
            return true;
        } else if (command.equals(TextType.EXIT.getText())) {
            outputView.printResult(bridgeGame.getResults(), Result.FAIL,bridgeGame.getTryCount());
        }
        return false;
    }

    private int readSize(boolean pass) {
        int size = 0;
        while (!pass) {
            try {
                size = inputView.readBridgeSize();
                pass = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return size;
    }

    private String readMove(boolean pass) {
        String move = "";
        while (!pass){
            try {
                move = inputView.readMoving();
                pass =true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return move;
    }

    private String readCommand(boolean pass) {
        String command = "";
        while (!pass) {
            try {
                command = inputView.readGameCommand();
                pass = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return command;
    }


}
