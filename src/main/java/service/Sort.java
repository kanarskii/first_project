package service;

import model.impl.Model;

import java.util.List;

public class Sort {
    public static void quickSort(List<Model> list, int from, int to) {

        if (list.size() == 0)
            return;

        if (from >= to)
            return;

        int middle = from + (to - from) / 2;
        Model pivot = list.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = from, j = to;
        while (i <= j) {
            while (list.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (list.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (list.get(j).compareTo(pivot) <= 0) {//меняем местами
                swap(list, i, j);
                i++;
                j--;
            }
//            if(i > to){
//                break;
//            }
//            if(j == from){
//                break;
//            }
//            if (list.get(i).compareTo(pivot) > 0) {//меняем местами
//                swap(list, i, j);
//
//                i++;
//                j--;
//            }
        }


        // вызов рекурсии для сортировки левой и правой части
        if (from <= j)
            quickSort(list, from, j);

        if (to >= i)
            quickSort(list, i, to);
    }


       /* int i = from;
        int j = to;

        if (j - i > 1) {

            Model pivot = list.get(i);
            while (j > i) {
                while (list.get(i).compareTo(pivot) <= 0 && i < to && j > i) {
                    i++;
                }
                while (list.get(j).compareTo(pivot) > 0 && j > from && j >= i) {
                    j--;
                }
                if (j > i) {
                    swap(list, i, j);
                }
            }
            quickSort1(list, from, j - 1);
            quickSort1(list, j, to);
        }else {

        }*/


    private static void swap(List<Model> listU, int i, int j) {
        Model temp = listU.get(i);
        listU.set(i, listU.get(j));
        listU.set(j, temp);
    }
}


