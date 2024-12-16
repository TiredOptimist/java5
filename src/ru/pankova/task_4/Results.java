package ru.pankova.task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    public static Map<Information, Integer> readInformation(String filePath) {
        Map<Information, Integer> participantMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int n = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();
                String[] parts = line.split("\\s+");
                String lastName = parts[0];
                String firstName = parts[1];
                int[] scores = new int[3];
                for (int j = 0; j < 3; j++) {
                    scores[j] = Integer.parseInt(parts[j + 2]);
                }
                Information inf = new Information(lastName, firstName, scores);
                participantMap.put(inf, inf.getTotalScore());
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка в формате данных: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        return participantMap;
    }

    public static List<Information> findMaxScore(Map<Information, Integer> participantMap) {
        int maxScore = participantMap.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        List<Information> maxScoreParticipants = new ArrayList<>();
        for (Map.Entry<Information, Integer> entry : participantMap.entrySet()) {
            if (entry.getValue() == maxScore) {
                maxScoreParticipants.add(entry.getKey());
            }
        }
        return maxScoreParticipants;
    }
}
