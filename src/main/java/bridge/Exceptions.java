package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exceptions {

    OutputView outputView = new OutputView();

    String availableNumber = "3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20";
    List<Integer> availableNumbers = new ArrayList<>();
    List<String> numbers = Arrays.asList(availableNumber.split(","));

    public void availableNumberCheck(int number) {
        availableNumbers = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        if (!availableNumbers.contains(number)) {
            throw new IllegalArgumentException(outputView.numberInputError());
        }
    }

    public boolean checkNumber(int number) {
        boolean checkBool = true;
        try {
            availableNumberCheck(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            checkBool = false;
        }
        return checkBool;
    }

    public int numberFormatableCheck(String input) {
        try {
            int number = Integer.valueOf(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(outputView.numberInputError());
        }
    }

    public boolean checkNumberIfFormatable(String input) {
        boolean checkBool = true;
        try {
            numberFormatableCheck(input);
        } catch (IllegalArgumentException e) {
            System.out.println(outputView.numberInputError());
            checkBool = false;
        }
        return checkBool;
    }
}
