package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // консатнта для определения размера массива
    private static final int SIZE_ARR = 9;
    // Список для результата
    private static List<Element> neighbors = new ArrayList<>();
    // Массив для элементов
    private static Element[][] elements = new Element[SIZE_ARR][SIZE_ARR];

    public static void main(String[] args) {

        // Зполняю массив элементами
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                elements[j][i] = new Element(j,i);
            }
        }

        // Вывод массива для наглядности
        printArr(elements);

        // Получаю список соседей
        neighbors = getNeighbors(elements[0][8]);

        // Вывожу на экран полученный список соседей (пердварительно проверив что список существует)
        if (neighbors != null && neighbors.size() > 0) {
            for (Element e : neighbors) {
                System.out.println(e.getX() + "  " + e.getY());
            }
        } else {
            System.out.println("Neighbors list is empty or not exist.");
        }
    }

    /**
     * Метод для получения списка соседей переданного элемента
     * @param e
     * @return Список соседей
     */
    public static List<Element> getNeighbors(Element e) {

        // Список для результата
        List<Element> neighbors = new ArrayList<>();

        // Проверяю корректность координат в элементе
        if (e.getX() > -1 && e.getX() < elements.length && e.getY() > -1 && e.getY() < elements.length) {
            // Проверяю что массив существует
            if (elements != null) {

                // перебераю ближайших соседей с учётом координат
                for (int i = e.getY() - 1; i < e.getY() + 2; i++) {
                    for (int j = e.getX() - 1; j < e.getX() + 2; j++) {
                        if (j > -1 && j < elements.length && i > -1 && i < elements.length) {
                            // Если это переданный элемент ни чего не делаем
                            if (j == e.getX() && i == e.getY()) {
                                // do nothing
                            } else {
                                neighbors.add(elements[j][i]);
                            }
                        }
                    }
                }
            }
        }

        // Если элемент с не коррктными координатами или массив не существует
        // наверно нужно сообщить об этом, сгенерировать исключение. Не понял нужно ли это тут.

        return neighbors;
    }

    /**
     * Функция для вывода массива элементов
     * @param e
     */
    public static void printArr(Element e[][]) {
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < e[i].length; j++) {
                System.out.printf("%2d%2d  ", e[j][i].getX(), e[j][i].getY());
            }
            System.out.println();
        }
    }
}
