package service;

import java.util.List;

public class QuickSort {

    private static void quickSort(List<String> list, int leftIndex, int rightIndex) {
        String pivot = list.get(list.size() / 2);
        String leftMarkerIndex = list.get(leftIndex);
        String rightMarkerIndex = list.get(rightIndex);

        System.out.println(pivot);
        System.out.println(leftMarkerIndex);
        System.out.println(rightMarkerIndex);

        //while (list.get(leftMarkerIndex) < list.get(rightMarkerIndex)) {}
    }

}
