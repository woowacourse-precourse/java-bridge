package bridge;

public class CheckInput {
    public int checkInput(String bSize){
        if(checkSize(bSize) ==0)
            return 0;
        if(checkNum(bSize) ==0)
            return 0;
        if(checkRange(bSize)==0)
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
        int num = Integer.valueOf(bSize);
        if(num<3 || num>20){
            return 0;
        }
        return 1;
    }
    public int checkNum(String bSize){
        for (int idx =0;idx<bSize.length();idx++){
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
