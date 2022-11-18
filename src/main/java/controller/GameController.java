package controller;

import bridge.InputView;
import camp.nextstep.edu.missionutils.Console;
import domain.AllBridge;

public class GameController {
    InputView inputView = new InputView();
    public void gameStart() {
        try{
            AllBridge allBridge = new AllBridge();
        }
        catch(IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
