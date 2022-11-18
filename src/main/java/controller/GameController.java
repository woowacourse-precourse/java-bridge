package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.AllBridge;

public class GameController {
    public void gameStart() {
        try{
            String length = Console.readLine();
            AllBridge allBridge = new AllBridge(length);
        }
        catch(IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
