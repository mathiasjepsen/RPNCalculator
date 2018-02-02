package rpncalculator;

import java.util.Scanner;

/**
 *
 * @author mathiasjepsen
 */
public class Calculator {

    private final PathStack stack = new PathStack();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("RPN Calculator booting up...\n");
        System.out.println("> ");
        while (true) {
            String input = scanner.nextLine();
            String[] arguments = input.trim().split(" ");
            int index = 0;
            for (String arg : arguments) {
                try {
                    int num = Integer.parseInt(arg);
                    stack.push(num);
                    index++;
                } catch (NumberFormatException e) {
                    char operator = arguments[index].charAt(0);
                    try {
                        if (stack.getData() == null || stack.getData().getRest() == null) {
                            throw new EmptyStackException();
                        }
                        stack.push(calculate((int) stack.pop(), (int) stack.pop(), operator));
                        index++;
                    } catch (EmptyStackException ex) {
                        System.out.println("The stack isn't large enough to apply the provided operation!");
                    } catch (ArithmeticException ae) {
                        System.out.println("Division by zero, try again!");
                    }
                }
            }

            printStack((NumberPath) stack.getData());
        }
    }

    private int calculate(int first, int second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '/':
                return first / second;
            case '*':
                return first * second;
            default:
                return 0;
        }
    }

    private void printStack(Path path) {
        if (path == null) {
            return;
        }
        printStack(path.getRest());
        System.out.println(path.getFirst());
    }

}
