package by.mrk.gridlaba;

import by.mrk.gridlaba.service.GridService;
import by.mrk.gridlaba.service.GridServiceImpl;

public class Invoker {
    private final GridService service = new GridServiceImpl();

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.invoke();
    }

    public void invoke() {
        service.doLogic();
    }
}
