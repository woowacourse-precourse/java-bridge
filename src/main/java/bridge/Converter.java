package bridge;

public class Converter {

    public String convertNumberToUpAndDown(int number){
        for(UpAndDown upAndDown : UpAndDown.values()){
            if(upAndDown.convertNumberToUpAndDown(number) != null){
                return upAndDown.convertNumberToUpAndDown(number);
            }
        }
        return null;
    }
}
