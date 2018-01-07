package by.mrk.gridlaba.validator;

import java.util.ArrayList;
import java.util.List;

public class GridValidatorImpl {
    private List<String> errorList = new ArrayList<>();

    public boolean validateGridSize(String height, String width) {
        return validateSide(height, "Height") && validateSide(width, "Width");
    }

    private boolean validateSide(String side, String sideName) {
        if (side == null || side.trim().isEmpty()) {
            errorList.add( sideName + " wrong number format");
            return false;
        }

        try {
            int heightInt = new Integer(side.trim());

            if (heightInt <= 0 || heightInt % 2 == 1) {
                errorList.add(sideName + " must be bigger then zero and even");
                return false;
            }
        } catch (NumberFormatException e) {
            errorList.add(sideName + " wrong number format");
            return false;
        }

        return true;
    }

    public String getErrors() {
        StringBuilder stringErrors = new StringBuilder();
        errorList.forEach((error) -> stringErrors.append(error).append("\n"));
        return stringErrors.toString();
    }
}
