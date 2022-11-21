package bridge;

import java.util.Objects;

public class ErrorCheck {
    public static int stringToInt(String goToNumber) {
        return Integer.parseInt(goToNumber);
    }

    public static void isItNumber(String haveToCheck) {
        for (int i = 0; i < haveToCheck.length(); i++)
            if (!Character.isDigit(haveToCheck.charAt(i)))
                System.out.println("error not number");
            //Error;
    }

    public static void isUpDown(String haveToCheck){
        if(!haveToCheck.equals("U") && !haveToCheck.equals("D"))
            System.out.println("error not U D");
    }

}
