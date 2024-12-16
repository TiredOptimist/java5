package ru.pankova.task_3;

import java.util.ArrayList;
import java.util.List;

public class ListReplacer {
    public static <T> List<T> replace(List<T> L, List<T> L1, List<T> L2) {
        int sizeL1 = L1.size();
        int sizeL = L.size();

        for (int i = 0; i <= sizeL - sizeL1; i++) {
            if (L.subList(i, i + sizeL1).equals(L1)) {
                List<T> newList = new ArrayList<>(L.subList(0, i));
                newList.addAll(L2);
                newList.addAll(L.subList(i + sizeL1, sizeL));
                return newList;
            }
        }
        return L;
    }
}
