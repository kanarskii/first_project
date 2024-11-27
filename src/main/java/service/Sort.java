package service;

import model.Model;

import java.util.List;

public class Sort {
    public static void quickSort(List<Model> list, int from, int to) {

        if (list.size() == 0)
            return;

        if (from >= to)
            return;

        int middle = from + (to - from) / 2;
        Model pivot = list.get(middle);

        int i = from, j = to;
        while (i <= j) {
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }
            while (list.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (list.get(j).compareTo(pivot) <= 0) {
                swap(list, i, j);
                i++;
                j--;
            }
        }

        if (from <= j)
            quickSort(list, from, j);

        if (to >= i)
            quickSort(list, i, to);
    }

    private static void swap(List<Model> listU, int i, int j) {
        Model temp = listU.get(i);
        listU.set(i, listU.get(j));
        listU.set(j, temp);
    }
}


