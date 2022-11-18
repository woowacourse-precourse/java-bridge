package game;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;
import view.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        bridgeGameManager.startGame();
    }

}
