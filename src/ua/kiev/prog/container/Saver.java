package ua.kiev.prog.container;

import java.io.FileWriter;
import java.io.IOException;

public class Saver {

    public void save(String path, String data) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
