package by.mrk.gridlaba.validator;

public interface GridValidator {
    boolean validateGridSize(String height, String width);
    boolean validateCellValue(String cellValue);
    String getAndClearErrors();
}
