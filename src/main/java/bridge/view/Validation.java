package bridge.view;

public class Validation {
    public static int validSize(String str){
        int num;
        try{
            num = Integer.parseInt(str);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        if(!(3<=num && num<=20)) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return num;
    }

    public static void validMoving(String str){
        if(!(str.equals("U") || str.equals("D"))) throw new IllegalArgumentException("[ERROR] 입력은 U,D 만 가능합니다.");
    }

    public static void validCommand(String str){
        if(!(str.equals("R") || str.equals("Q"))) throw new IllegalArgumentException("[ERROR] 입력은 R,Q 만 가능합니다.");
    }
}
