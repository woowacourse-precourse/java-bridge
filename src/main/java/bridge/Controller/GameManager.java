package bridge.Controller;

import bridge.Model.BridgeDTO;
import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameManager {
    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeDTO bridgeDTO = new BridgeDTO();
    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();

    public void runGame() {
        try {
            makeBridgeGame();
            boolean checkSame = runMovePoint();
            runResult(checkSame);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeBridgeGame() {
        outputView.printStartGame();
        outputView.printMakeBridgeSize();
        this.bridgeDTO = inputView.makeBridgeData();
    }

    public boolean runMovePoint() {
        boolean checkSame = true;
        for (int i=0;i<bridgeDTO.getSize() && checkSame;i++) {
            checkSame = movePointRoutine(i);
            bridgeGame.move(bridgeDTO);
            outputView.printMap(bridgeDTO);
        }
        return checkSame;
    }

    public boolean movePointRoutine(int i) {
        outputView.printMovePoint();
        String wordUpDown = inputView.readMoving();
        boolean checkSame = checkUpDown(wordUpDown, bridgeDTO, i);
        if (!checkSame) {
            missMatch(wordUpDown, bridgeDTO, i);
        }
        return checkSame;
    }

    public boolean checkUpDown(String wordUpDown, BridgeDTO bridgeDTO, int i) {
        if (wordUpDown.equals("U") && bridgeDTO.getBridge().get(i).equals("U")) {
            plusLine(outputView.COLLECT, outputView.BLANK);
            return true;
        }
        if (wordUpDown.equals("D") && bridgeDTO.getBridge().get(i).equals("D")) {
            plusLine(outputView.BLANK, outputView.COLLECT);
            return true;
        }
        return false;
    }

    public void plusLine(String first, String second) {
        bridgeDTO.getSaveFirstLine().add(first);
        bridgeDTO.getSaveSecondLine().add(second);
    }

    public void missMatch(String wordUpDown, BridgeDTO bridgeDTO, int i) {
        if (wordUpDown.equals("U") && bridgeDTO.getBridge().get(i).equals("D")) {
            plusLine(outputView.FAIL, outputView.BLANK);
            return ;
        }
        if (wordUpDown.equals("D") && bridgeDTO.getBridge().get(i).equals("U")) {
            plusLine(outputView.BLANK, outputView.FAIL);
        }
    }

    public void runResult(boolean checkSame) {
        if ((bridgeDTO.getMovePoint() != bridgeDTO.getSize()) && !checkSame) {
            bridgeGame.retry();
        }
    }
}
