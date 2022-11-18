package bridge;

public class NumberToString implements NumberShape{
    @Override
    public String numToUpDown(int num){
        if(num == 1){return "U";}
        return "D";
    }
}
