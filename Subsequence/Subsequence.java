package com.tsystems.javaschool.tasks;

import java.util.List;

public class Subsequence {
    public <T> boolean find(List <T> x, List <T> y) {
            if (x.isEmpty() || y.isEmpty());
            boolean isAlright = true;
            int marker = 0;                         //счетчик для отбора значений из второго списка
            for (int iterX = 0; iterX < x.size(); iterX++) { //внешний цикл для перебора значений х, второй для y
                if (isAlright != true) break;       //сработает, когда не найдётся нужный элемент в списке y
                isAlright = false;
                for (int iterY = marker; iterY < y.size(); iterY++) {
                    if (x.get(iterX).equals(y.get(iterY))) { //сравниваем i-й элемент из списка с j-ыми элементами(начиная с marker), пока не найдём подходящий
                        isAlright = true;           //если найден, меняем значение isAlright, чтобы во внешнем цикле не сработал break
                        marker = iterY + 1;                       //переносим marker на след. элемент. В след. раз цикл начнётся оттуда
                        break;                      //выход во внешний цикл
                    }
                }
            }
            return isAlright;                       //возвращаем значение
    }
}
