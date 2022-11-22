package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;


public class InputView {

    private int inputSize;
    public final int count;
    public BridgeGame bridgeGame;
    public OutputView outputView;

    public InputView(BridgeMaker bridgeMaker, int count){
        this.bridgeGame = new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()));
        this.outputView = new OutputView(this.bridgeGame);
        this.count = count;
    }

    public boolean playGame(){
        for(int i=0; i<this.inputSize; i++){
            String result = readMoving();
            outputView.printMap();
            if(result.equals("X")) return bridgeGame.retry(readGameCommand(false));
        }
        return bridgeGame.retry(readGameCommand(true));
    }


    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        try{
            inputSize = Integer.parseInt(input);
        }catch(NumberFormatException nfe){throwException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");}
        if(inputSize < 3 || inputSize > 20) throwException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return inputSize;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if(!(input.equals("U")) && !(input.equals("D"))) throwException("이동할 칸은 U 또는 D만 입력할 수 있습니다.");
        return bridgeGame.move(input);
    }


    public String readGameCommand(boolean successOption) {
        if(successOption) return readGameCommandWithSuccess();
        return readGameCommandWithFailure();
    }

    public String readGameCommandWithSuccess(){
        outputView.printResult(bridgeGame.getCount(), inputSize, count);
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return "Q";
    }

    public String readGameCommandWithFailure(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if(!(input.equals("R")) && !(input.equals("Q"))) throwException("재시작 여부는 R 또는 Q만 입력할 수 있습니다.");
        outputView.printResult(bridgeGame.getCount(), inputSize, count);
        return input;
    }

    public void throwException(String message){
        System.out.println("[ERROR] " + message);
        throw new NoSuchElementException("[ERROR] " + message);
    }


}
