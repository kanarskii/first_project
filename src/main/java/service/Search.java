package service;

import java.util.Comparator;
import java.util.List;

import model.Model;

/**
 * Класс поиска по коллекции
 * */
public class Search {

    /**
     * Бинарный поиск
     * @param objlList коллекция для поиска
     * @param key искомый обьект
     * @param comparator Условие сравнения обьектов
     * */
    public static <T> int binarySearch(List<T> objlList, T key, Comparator<T> comparator) {
        if(objlList == null || key == null || comparator == null) {
            return -1;
        }
        int low = 0;
        int high = objlList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            var comparResult = comparator.compare(key, objlList.get(mid));
            if (comparResult < 0) {
                high = mid - 1;
            } else if (comparResult > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
