package bridge;

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

}
