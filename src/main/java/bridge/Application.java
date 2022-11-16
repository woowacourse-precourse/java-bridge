package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
       String Top = "[]";
       String Bottom = "[]";
       String Correct = " O ";
       String False = " X ";
       String Space = "   ";
       StringBuffer T = new StringBuffer();
       StringBuffer B = new StringBuffer();
       T.append(Top);
       B.append(Bottom);
       int answer = 1;
       int slice = 4;
       System.out.println("몇번하실껀가요?");
       int count = Integer.parseInt(Console.readLine());
       for(int i = 0;i<count;i++) {
          System.out.println("이동하실칸 선택해주세요.(위: U, 아래: D)");
          String choice = Console.readLine();
          if(choice.equals("U")) {
             T.insert(answer, Correct);
             B.insert(answer, Space);
          } else if (choice.equals("D")) {
             T.insert(answer, False);
             B.insert(answer, Space);
          }
          System.out.println(T);
          System.out.println(B);
          answer = answer +4;
          if(i!=count-1){
            T.insert(answer - 1, "|");
            B.insert(answer - 1, "|");
         }
      }




    }
}
