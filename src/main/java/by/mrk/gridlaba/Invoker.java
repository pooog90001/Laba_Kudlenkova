package by.mrk.gridlaba;

import by.mrk.gridlaba.entity.Grid;
import by.mrk.gridlaba.printer.ConsolePrinter;
import by.mrk.gridlaba.printer.Printer;
import by.mrk.gridlaba.reader.ConsoleReader;
import by.mrk.gridlaba.reader.Reader;

public class Invoker {
    private final Reader reader = new ConsoleReader();
    private final Printer printer = new ConsolePrinter();

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.invoke();
    }

    public void invoke() {
        printer.print("Hello, this is grid program! \nEnter please grid height: ");
        int height = new Integer(reader.read());
        printer.print("Enter please grid width: ");
        int width = new Integer(reader.read());
        Grid grid = new Grid(height, width);

        for (int i = 0; i < height; i+=2) {
            for (int j = 0; j < width; j++) { //когда мы идёт зигзагами слева напрово
                /*printer.println("Enter value in cell[" + i+1 + "][" + j+1 + "] : ");
                String value = reader.read();*/
                if (j % 2 == 0) {
                    grid.setCellValue(i, j, 5);
                } else {
                    grid.setCellValue(i+1 , j, 5);
                }
            }
            for (int j = width - 1; j >= 0 ; j-- ) { //когда мы идем зигзагами справа на лево
                /*printer.println("Enter value in cell[" + i+1 + "][" + j+1 + "] : ");
                String value = reader.read();*/
                if (j % 2 == 1) {
                    grid.setCellValue(i, j, 1);
                } else {
                    grid.setCellValue(i+1 , j, 1);
                }
            }
        }

        printer.println(grid.toString());
    }
}
