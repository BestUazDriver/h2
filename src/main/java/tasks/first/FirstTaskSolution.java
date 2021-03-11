package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        String way = null;
        ArrayList<Integer> line = new ArrayList<>();
        ArrayDeque<Integer> vertex = new ArrayDeque<>();
        vertex.add(startIndex);
        while (line.size() < adjacencyMatrix.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[i][vertex.peekFirst()]) {
                    temp.add(i);
                }
            }
            Collections.sort(temp);
            vertex.addAll(temp);

            if (!line.contains(vertex.peekFirst())) {
                line.add(vertex.peekFirst());
                way = way + vertex.pop() + ", ";
            } else {
                vertex.removeFirst();
            }
        }
        way=way.substring(0,way.length()-1);
        return way;
    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> que = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                que.push(s.charAt(i));
            }
            if ((s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') && que.isEmpty()) {
                return false;
            }
            switch (s.charAt(i)) {
                case ')':
                    if (que.getFirst() == '(') {
                        que.pop();
                        break;
                    }
                case ']':
                    if (que.getFirst() == '[') {
                        que.pop();
                        break;
                    }
                case '}':
                    if (que.getFirst() == '{') {
                        que.pop();
                        break;
                    }
            }
        }
        return que.isEmpty();
    }

    @Override
    public Long polishCalculation(String s) {
        long number = 0;
        ArrayList<Character> branch = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            branch.add(s.charAt(i));
            if (branch.get(i).isDigit(s.charAt(i))) {
                queue.push(Integer.parseInt(Character.toString(s.charAt(i))));
            } else {
                System.out.println(queue.toString());
                if (number == 0) {
                    number = queue.getFirst();
                    queue.pop();
                    System.out.println(number);
                }
                System.out.println(queue.toString());
                switch (branch.get(i)) {
                    case '+':
                        number = queue.pop() + number;
                        System.out.println(number);
                        break;
                    case '-':
                        number = queue.pop() - number;
                        System.out.println(number);
                        break;
                    case '*':
                        number = queue.pop() * number;
                        System.out.println(number);
                        break;
                    case '/':
                        number = queue.pop() / number;
                        System.out.println(number);
                        break;

                }
            }

        }
        return number;
    }
}

