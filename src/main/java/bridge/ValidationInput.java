package bridge;

import java.lang.String;

public class ValidationInput {
    public static void checkDigit(String number){
        try{
            Integer.parseInt(number);
        }catch(Exception e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }

    public static void validSizeOfBridge(String number){
        try {
            if (!((Integer.parseInt(number) >= 3 && Integer.parseInt(number) <= 20))) {
                throw new IllegalArgumentException();
            }
        }catch (Exception e){
            System.out.println("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.");
        }
    }

    public static String validateInputBridge(String size){
        checkDigit(size);
        validSizeOfBridge(size);
        return size;
    }

    public static void validateUpperAlphaBet(String string){
        try{
            if (!(string.matches("^[A-Z]*$"))){ //Alphabet이 아니라면
                throw new IllegalArgumentException(); // 강제 에러 발생시키기
            }
        }catch(Exception e){
            System.out.println("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중에 하나를 입력해주세요.");
        }
    }

    public static void validateInputSizeIsOne(String string){
        try{
            if (1 != string.length()){ // 입력문자열의 개수가 1이 아니라면
                throw new IllegalArgumentException(); // 강제 에러 발생시키기
            }
        }catch(Exception e){
            System.out.println("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중에 하나를 입력해주세요.");
        }
    }

    public static void validateReadMoving(String string) {
        try {
            if (!(string == "U" || string == "D")) { // 입력문자열의 개수가 1이 아니라면
                throw new IllegalArgumentException(); // 강제 에러 발생시키기
            }
        } catch (Exception e) {
            System.out.println("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중에 하나를 입력해주세요.");
        }
    }

    public static void validateReadGameCommand(String string) {
        try {
            if (!(string == "R" || string == "Q")) { // 입력문자열의 개수가 1이 아니라면
                throw new IllegalArgumentException(); // 강제 에러 발생시키기
            }
        } catch (Exception e) {
            System.out.println("[ERROR] 게임을 다시 시도할지 여부는 R(재시도)과 Q(종료) 중에 하나를 입력해주세요.");
        }
    }
}
