package service;

import model.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static <T> void quick(List<T> list, int from, int to, Comparator <T> comparator) {

        if (list.isEmpty())
            return;

        if (from >= to)
            return;

        int middle = from + (to - from) / 2;
        T pivot = list.get(middle);

        int i = from, j = to;
        while (i <= j) {
            while (comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }
            while (comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }
            if (comparator.compare(list.get(j), list.get(i))<= 0) {
                swap(list, i, j);
                i++;
                j--;
            }
        }

        if (from <= j)
            quick(list, from, j, comparator);

        if (to >= i)
            quick(list, i, to, comparator);
    }

    public static <T> void natural(List<T> list, Comparator <T>  comparator){
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).hashCode() % 2 == 0){
                numbersList.add(i);
            }
        }
        System.out.println("Номера элементов к которым будет применена натуральная сортировка");
        numbersList.forEach(System.out::print);
        System.out.println();

        List<T> newList = new ArrayList<>();

        for (Integer integer : numbersList) {
            newList.add(list.get(integer));
        }

        quick(newList, 0, newList.size() - 1, comparator);

        for (int i = 0; i < numbersList.size(); i++) {
            list.set(numbersList.get(i), newList.get(i));
        }
    }

    private static <T> void swap(List<T> listU, int i, int j) {
        T temp = listU.get(i);
        listU.set(i, listU.get(j));
        listU.set(j, temp);
    }
}


