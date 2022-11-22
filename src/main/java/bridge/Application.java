package bridge;

import java.util.List;

public class Application {
     InputView input = new InputView();
    static OutputView outputView = new OutputView();
     inputWrongError errorCheck = new inputWrongError();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridge = new BridgeGame();
        outputView.printStartGame();
        bridge.startGame();
    }

    public  int makeBridgeSize(){
        int size;
        outputView.printLengthBridge();
        try{
            size = input.readBridgeSize();
            errorCheck.bridgeSizeError(size);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return makeBridgeSize();
        }
        return size;
    }
    public String moveCheck(){
        String answerMove = "";
        outputView.printMovingChoice();
        try {
            answerMove = input.readMoving(); //이동할 칸 입력
            errorCheck.moveError(answerMove); //에러체크
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return moveCheck();
        }
        return answerMove;
    }


}
