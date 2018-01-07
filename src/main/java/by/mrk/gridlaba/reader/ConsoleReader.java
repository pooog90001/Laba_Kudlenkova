package by.mrk.gridlaba.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        String inputString = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = reader.readLine().trim();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Read line error!");
        }

        return inputString;
    }
}
