package bridge;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeRandomNumberGenerator brn = new BridgeRandomNumberGenerator(); //다리 랜덤 수 생성
        OutputView op = new OutputView();//출력뷰
        InputView ip = new InputView(); //입력뷰

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이를 입력해주세요.");

        Scanner scip = new Scanner(System.in);
        int ipsize = scip.nextInt();

        System.out.println("다리길이 : " + ipsize);

        int[] arry = new int[ipsize];//
        boolean gameYN = true; //게임 진행 여부
        int i = 0;

        while(true) {

            System.out.println("\r\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
            Scanner sc = new Scanner(System.in);
            String udsel = sc.next();
            int brsel = brn.generate();//다리 선택
            if(udsel.equals("U")) {//입력값이 U이면 그대로 입력, U는 0이면 아니오, 1이면 맞다
                arry[i] = brsel;
            }else if(udsel.equals("D")) {//입력값이 D면 반대로 입력
                if(brsel == 1) {
                    arry[i] = 0;
                }else if(brsel == 0) {
                    arry[i] = 1;
                }
            }else {
                System.out.println("\r\n잘못입력하셨습니다. U,D 중 입력해주세요.");
            }

            gameYN = op.printMap(i,arry[i],udsel,arry);
            i++;

            if(i==arry.length) { //배열만큼 돌면 게임종료
                break;
            }

            if(gameYN == false) {
                System.out.println("\r\n게임을 계속 하시겠습니까?");
                Scanner scYN = new Scanner(System.in);
                String strYN = scYN.next();
                if(strYN.equals("N")) { //게임 종료
                    break; //게임을 종료한다
                }else if(strYN.equals("Y")){ //게임계속
                    continue;
                }else {
                    System.out.println("\r\n잘못입력하셨습니다. Y,N 중 입력해주세요.");
                }
            }

        }

        System.out.println("\r\n" + Arrays.toString(arry));

    }

}