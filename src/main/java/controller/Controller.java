package controller;

import static controller.Util.*;

public class Controller {

    public int inputSize(){
        int size = Integer.parseInt(inputValue());
        checkSize(size);
        return size;
    }
}
