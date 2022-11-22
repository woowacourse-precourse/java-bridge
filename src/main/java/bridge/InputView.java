package bridge;
import java.util.*;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    





    public static int readBridgeSize() //다리 길이 입력받기
    {   
        Scanner sc = new Scanner(System.in);
        System.out.println("다리길이를 입력하시오.");
        int bridgeLength=sc.nextInt();
       
        return bridgeLength;
    }
    
    
    public static String readMoving(){ //이동할 칸 선택하기
        Scanner sc = new Scanner(System.in);
        System.out.println("이동할 칸을 선택 하시오  (위: U,아래: D)");
        String moveBridge=sc.nextLine();
        return moveBridge;
    }

    
    public static String readGameCommand  (){ //게임 재시작 여부결정
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String regame=sc.nextLine();
        return regame;
    }



    
}


