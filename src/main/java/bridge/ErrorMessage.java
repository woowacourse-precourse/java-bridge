package bridge;

import java.util.Scanner;

public class ErrorMessage {
    public static void isNumberCheckErrorMessage(){
        System.out.println("[ERROR] 잘못된 입력입니다. 숫자를 입력하세요.");
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자를 입력하세요.");
    }
    public static void lengthMinMaxErrorMessage(){
        System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
    public static void isMoveUporDownCheckErrorMessage(){
        System.out.println("[ERROR] 잘못된 입력입니다. U 또는 D를 입력하세요.");
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. U 또는 D를 입력하세요.");
    }
    public static void isAnswerRorQCheckErrorMessage(){
        System.out.println("[ERROR] 잘못된 입력입니다. R 또는 Q를 입력하세요.");
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. R 또는 Q를 입력하세요.");
    }
}
