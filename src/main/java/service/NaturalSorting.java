package service;

import model.Model;

import java.util.ArrayList;
import java.util.List;

import static service.Sort.quickSort;

public class NaturalSorting {
    public static void naturalSorting(List<Model> list){
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).hashCode() % 2 == 0){
                numbersList.add(i);
            }
        }
        System.out.print(numbersList + "  -------  ");

        List<Model> newList = new ArrayList<>();

        for (int i = 0; i < numbersList.size(); i++) {
            newList.add(list.get(numbersList.get(i)));
        }

        int from = 0;
        int to = newList.size() - 1;

        quickSort(newList, from, to);

        System.out.println(newList);

        for (int i = 0; i < numbersList.size(); i++) {
            list.set(numbersList.get(i), newList.get(i));
        }
        System.out.println(list);
    }
}
