package bridge;

public class CheckInput {
    public int checkInput(String bSize){
        if(checkSize(bSize) ==0) //공백일때
            return 0;
        if(checkNum(bSize) ==0)  //숫자가 아닐때
            return 0;
        if(checkRange(bSize)==0)  //다리길이 범위가 올바르지 않을때
            return 0;
        return 1;
    }
    public int checkSize(String bSize) {
        if (bSize.length()==0){
            return 0;
        }
        return 1;
    }
    public int checkRange(String bSize) {
        //3~10 사이 아닐때 예외
        int num = Integer.valueOf(bSize);
        if(num<3 || num>20){
            return 0;
        }
        //3~10사이 범위인지 검사
        return 1;
    }
    public int checkNum(String bSize){
        //문자열일때 에외
        for (int idx =0;idx<bSize.length();idx++){
            //문자열인지 검사
            if( Character.isDigit(bSize.charAt(idx)) == false) {
                return 0;
            }
        }
        return 1;
    }
    public  int checkMove(String move){
        if(checkMoveSize(move)==0){
            return 0;
        }
        if(checkMoveSpell(move)==0){
            return 0;
        }
        return 1;
    }
    public int checkMoveSize(String move){
        //문자열 길이가 2이상면 예외
        if(move.length()!=1){
            return 0;
        }
        return 1;
    }
    public int checkMoveSpell(String move){
        if(move.equals("U") || move.equals("D")){
            return 1;
        }
        return 0;
    }
    public int checkRetry(String move){
        if(move.equals("R") || move.equals("Q")){
            return 1;
        }
        return 0;
    }
}
