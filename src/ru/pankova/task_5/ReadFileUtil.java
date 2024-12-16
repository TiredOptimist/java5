package ru.pankova.task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUtil {
    public static String readFile(String file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
