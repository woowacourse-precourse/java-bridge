package controller;

import bridge.BridgeGame;
import view.AnnouncementView;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    public static void start_game(List<String> bridge, int size){
        String re="R";
        int try_count = 1;
        boolean success = true;
        while(re.contains("R")) {
            success = try_cross(bridge, size);
            if(success_info(size, success)) break;
            re = ask_retry();
            try_count = retry_cross(re, try_count);
        }
        print_result(success, try_count);
    }
    public static boolean success_info(int size, boolean success){
        if(BridgeGame.getUp_bridge().size()==size && success == true)
            return true;
        return false;
    }
    public static boolean try_cross(List<String> bridge, int size){
        boolean success = true;
        String move;
        for (int i = 0; i < size; i++) {
            AnnouncementView.move();
            move = InputView.readMoving();
            success = BridgeGame.move(bridge, move, i);
            OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
            if (success == false) break;
        }
        return success;
    }
    public static String ask_retry(){
        AnnouncementView.restart();
        return InputView.readGameCommand();
    }
    public static int retry_cross(String re, int try_count){
        if(re.contains("R")) {
            try_count += 1;
            BridgeGame.retry();
        }
        return try_count;
    }
    public static void print_result(boolean success, int try_count){
        AnnouncementView.bridge_result();
        OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
        OutputView.printResult(success, try_count);
    }
}
