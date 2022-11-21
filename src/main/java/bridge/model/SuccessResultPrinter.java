package bridge.model;

import java.util.List;

class SuccessResultPrinter extends ResultPrinter {


    public SuccessResultPrinter(List<String> directions) {
        super(directions);
    }

    @Override
    public String print() {
        return getResultFormat(getUpResult())
                + getResultFormat(getDownResult());
    }
}
