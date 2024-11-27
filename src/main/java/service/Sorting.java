package service;

import model.Model;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void quick(List<Model> list, int from, int to) {

        if (list.isEmpty())
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
            quick(list, from, j);

        if (to >= i)
            quick(list, i, to);
    }

    public static void natural(List<Model> list){
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).hashCode() % 2 == 0){
                numbersList.add(i);
            }
        }

        List<Model> newList = new ArrayList<>();

        for (Integer integer : numbersList) {
            newList.add(list.get(integer));
        }

        quick(newList, 0, newList.size() - 1);

        for (int i = 0; i < numbersList.size(); i++) {
            list.set(numbersList.get(i), newList.get(i));
        }
        System.out.println(list);
    }

    private static void swap(List<Model> listU, int i, int j) {
        Model temp = listU.get(i);
        listU.set(i, listU.get(j));
        listU.set(j, temp);
    }
}


