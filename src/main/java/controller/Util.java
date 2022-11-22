package controller;

import camp.nextstep.edu.missionutils.Console;
import view.ErrorMessage;
import view.InputView;

public class Util {
    private InputView inputView;

    public Util() {
        inputView = new InputView();
    }

    public int inputSize(){
        inputView.readBridgeSize();
        int size = Integer.parseInt(Console.readLine());
        validateSize(size);
        return size;
    }

    public String inputMoving(){
        inputView.readMoving();
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    public String inputRestart(){
        inputView.readGameCommand();
        String restart = Console.readLine();
        validateRetry(restart);
        return restart;
    }

    private void validateSize(int size){
        if(size < 3 || size >20)
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getErrorMessage());
    }

    private void validateMoving(String moving){
        if(!moving.equals("U") && !moving.equals("D"))
            throw new IllegalArgumentException(ErrorMessage.MOVING_ERROR.getErrorMessage());
    }
    private void validateRetry(String retry){
        if(!retry.equals("R") && !retry.equals("Q"))
            throw new IllegalArgumentException(ErrorMessage.RESTART_ERROR.getErrorMessage());
    }
}
