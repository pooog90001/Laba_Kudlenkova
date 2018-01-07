package by.mrk.gridlaba.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
