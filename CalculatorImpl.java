package com.tsystems.javaschool.tasks;

import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * Для решения данной задачи применим алгоритм обратной польской записи
 * https://ru.wikipedia.org/wiki/Обратная_польская_запись
  */
    public class CalculatorImpl  {

        public String evaluate(String statement) {
            try {
                LinkedList<Double> st = new LinkedList<>(); //стек для хранения цифр
                LinkedList<Character> op = new LinkedList<>(); // стек для хранения цифр и операторов в порядке поступления
                DecimalFormat df = new DecimalFormat("##.####");
                for (int i = 0; i < statement.length(); i++) { // чтение строки с выражением
                    char c = statement.charAt(i);
                    if (isDelim(c))
                        continue;
                    if (c == '(')
                        op.add('(');
                    else if (c == ')') {
                        while (op.getLast() != '(')
                            processOperator(st, op.removeLast());
                        op.removeLast();
                    } else if (isOperator(c)) {
                        while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                            processOperator(st, op.removeLast());
                        op.add(c);
                    } else {
                        String operand = "";
                        while (i < statement.length() && Character.isDigit(statement.charAt(i)) || statement.charAt(i) == '.') {
                            operand += statement.charAt(i++);
                        }
                        i--;
                        st.add(Double.parseDouble(operand));
                    }
                }
                while (!op.isEmpty())
                    processOperator(st, op.removeLast());
                return df.format(st.get(0));
            } catch (Exception ex) {
                return null;
            }
        }

        private static boolean isDelim(char c) { // возвращает true если пробел
            return c == ' ';
        }

        private static boolean isOperator(char c) { // возвращает true если символ присутствует
            return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
        }

        private static int priority(char op) {
            switch (op) { // приоритеты операций
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                case '%':
                    return 2;
                default:
                    return -1;
            }
        }

        private static void processOperator(LinkedList<Double> st, char operation) {
            double first = st.removeLast();
            double second = st.removeLast();
            switch (operation) {
                case '+':
                    st.add(second + first);
                    break;
                case '-':
                    st.add(second - first);
                    break;
                case '*':
                    st.add(second * first);
                    break;
                case '/':
                    st.add(second / first);
                    break;
                case '%':
                    st.add(second % first);
                    break;
            }
        }
    }

