package by.mrk.gridlaba.service;

import by.mrk.gridlaba.entity.Grid;
import by.mrk.gridlaba.printer.ConsolePrinter;
import by.mrk.gridlaba.printer.Printer;
import by.mrk.gridlaba.reader.ConsoleReader;
import by.mrk.gridlaba.reader.Reader;
import by.mrk.gridlaba.validator.GridValidator;
import by.mrk.gridlaba.validator.GridValidatorImpl;

public class GridServiceImpl implements GridService {
    private final Reader reader = new ConsoleReader();
    private final Printer printer = new ConsolePrinter();
    private final GridValidator validator = new GridValidatorImpl();

    public void doLogic() {
        Grid grid = defineGridSize();
        defineGridCells(grid);
        printer.println(grid.toString());
    }

    /**
     * Функция для ввода размера матрицы
     *
     * @return Пустая таблица заданного размера
     */
    private Grid defineGridSize() {
        boolean doRepeat; // переменная для того, чтобы повторить ввод при некоректных данных
        String height;
        String width;
        do {
            printer.print("Enter grid height: ");
            height = reader.read();
            printer.print("Enter grid width: ");
            width = reader.read();
            if (!validator.validateGridSize(height, width)) {
                printer.println(validator.getAndClearErrors());
                doRepeat = true;
            } else {
                doRepeat = false;
            }
        } while (doRepeat);

        return new Grid(new Integer(height), new Integer(width));
    }

    private void defineGridCells(Grid grid) {
        for (int i = 0; i < grid.getHeight(); i += 2) {
            for (int j = 0; j < grid.getWidth(); j++) { //когда мы идёт зигзагами слева напрово
                if (j % 2 == 0) {
                    grid.setCellValue(i, j, defineGridCell(i, j));
                } else {
                    grid.setCellValue(i + 1, j, defineGridCell(i + 1, j));
                }
            }
            for (int j = grid.getWidth() - 1; j >= 0; j--) { //когда мы идем зигзагами справа на лево
                if (j % 2 == 1) {
                    grid.setCellValue(i, j, defineGridCell(i, j));
                } else {
                    grid.setCellValue(i + 1, j, defineGridCell(i + 1, j));
                }
            }
        }
    }

    private int defineGridCell(int height, int width) {
        boolean doRepeat; // переменная для того, чтобы повторить ввод при некоректных данных
        String cellValue;
        do {
            printer.println("Enter value in cell[" + height + "][" + width + "] : ");
            cellValue = reader.read();

            if (!validator.validateCellValue(cellValue)) {
                printer.println(validator.getAndClearErrors());
                doRepeat = true;
            } else {
                doRepeat = false;
            }
        } while (doRepeat);

        return new Integer(cellValue);
    }
}
