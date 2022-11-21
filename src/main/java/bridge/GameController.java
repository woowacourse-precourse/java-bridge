package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Message.MSG_GET_LENGTH;
import static bridge.Message.MSG_START;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final List<String> answerBridge;
    private final List<String> curBridge;
    private final int stageNum;
    private final String status;


    GameController(){
        answerBridge = new ArrayList<>();
        curBridge = new ArrayList<>();
        stageNum = 0;
        status = "Playing";
    }


    public void playGame(){
        System.out.println(MSG_START.getMessage());
        makeNewGame();
        // while ()
        // play new Stage
        // if success : print result
        // if fail && end : print result
    }

    private void makeNewGame(){
        System.out.println(MSG_GET_LENGTH.getMessage());
        int length = inputView.readBridgeSize();
    }


    private void playOneStage(){
        // cnt ++
        // for
        // get input U or D
        // move
        //
    }

}
