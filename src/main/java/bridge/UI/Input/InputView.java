package bridge.UI.Input;


import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public int readBridgeSize() throws IllegalArgumentException {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
        if((bridgeSize < 3) || (20 < bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 3과 20 사이의 숫자를 입력해주세요");
        }
        return bridgeSize;
    }

    public String readMoving() {
        String userInput = Console.readLine();
        if(!(userInput.equals("U") || userInput.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U(위칸) 혹은 D(아래칸)을 입력해주세요");
        }
        return userInput;
    }

    public String readGameCommand() {
        String userInput = Console.readLine();
        if(!(userInput.equals("R") || userInput.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R(재시작) 혹은 Q(종료)를 입력해주세요");
        }
        return userInput;
    }
}

//필요한 메서드 추가할 수 있다.