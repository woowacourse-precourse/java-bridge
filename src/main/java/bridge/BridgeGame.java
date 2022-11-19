package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> answerBridge;
    private User user;
    private int gameTryNumber = 1;
    private boolean gameSuccess = true;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();


    // initialize Part
    public BridgeGame() {
        makeBridge();
        this.user = new User();
    }

    public void makeBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int result = bridgeInputCheckLogic("");
        answerBridge = new ArrayList<>(bridgeMaker.makeBridge(result));
    }

    public int bridgeInputCheckLogic(String userInputValue){
        while(true){
            try{
                userInputValue = inputView.readBridgeSize();
                return bridgeValidation(userInputValue);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int bridgeValidation(String userInputValue){
        try{
            int result = Integer.parseInt(userInputValue);
            if(result < 3 || result > 20){
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3에서 20사이의 숫자만 가능합니다.");
            }
            return result;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3에서 20사이의 숫자만 가능합니다.");
        }

    }

    // Processing Part

    public void gameStart(){
        while(getUserBridge().size() < answerBridge.size() && gameSuccess) {
            move();
            inputValueCorrectOrNot(outputView.printMap(getUserBridge()));
        }
        gameEnd();
    }

    // move Part

    public void move() {
        String userInputValue = inputCheckLogic("");
        user.getUserBridge().add(makeField(userInputValue));
    }

    public String inputCheckLogic(String userInputValue){
        while(true) {
            try {
                userInputValue = inputView.readMoving();
                fieldValueValidation(userInputValue);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return  userInputValue;
    }

    private Field makeField(String userInputValue){
         if (answerBridge.get(user.getGameCount()).equals(userInputValue)){
             return new Field(userInputValue, true);
        }
         return new Field(userInputValue, false);
    }

    public void fieldValueValidation(String userInputValue){
        if (userInputValue.equals("U") || userInputValue.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이동 칸은 U 또는 D만 입력 가능합니다.");
    }

    // Retry Part


    public void inputValueCorrectOrNot(boolean isCorrect){
        if (!isCorrect) {
            retry();
            return;
        }
        updateBridge();
        increaseUserGameCount();
    }


    public void retry() {
        String retryInput = retryInputCheckLogic("");
        retryLogic(retryInput);
    }

    public String retryInputCheckLogic(String retryInput){
        while(true){
            try {
                retryInput = inputView.readGameCommand();
                retryValueValidation(retryInput);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return retryInput;
    }

    private void retryLogic(String retryInput){
        if (retryInput.equals("Q")) {
            gameSuccess = false;
            return;
        }
        restoreBridge();
        increaseGameTryNumber();
    }


    // end logic
    public void gameEnd(){
        outputView.printResult(getUserBridge(),gameTryNumber,getSuccessString());
    }

    private String getSuccessString(){
        if(gameSuccess){
            return "성공";
        }
        return "실패";
    }

    public void increaseGameTryNumber(){
        gameTryNumber +=1;
    }

    public void retryValueValidation(String userInputValue) {
        if(userInputValue.equals("R") || userInputValue.equals("Q")){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요.");
    }

    public ArrayList<Field> getUserBridge(){
        return user.getUserBridge();
    }

    public int getGameTryNumber() {
        return gameTryNumber;
    }

    public void restoreBridge(){
        user.restoreBridge();
    }

    public void updateBridge(){
        user.updateBridge();
    }

    public void increaseUserGameCount(){
        user.increaseGameCount();
    }
}
