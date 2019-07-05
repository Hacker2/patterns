package interpreter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public interface Expr {
        int interpret(Map<String, Integer> context);

        static Expr plus(Expr left, Expr right) {
            return context -> left.interpret(context) + right.interpret(context);
        }

        static Expr minus(Expr left, Expr right) {
            return context -> left.interpret(context) - right.interpret(context);
        }

        static Expr variable(String name) {
            return context -> context.getOrDefault(name, 0);
        }
    }

    private static Expr parseToken(String token, ArrayDeque<Expr> stack) {
        Expr left, right;
        switch (token) {
            case "+":
                right = stack.pop();
                left = stack.pop();
                return Expr.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expr.minus(left, right);
            default:
                return Expr.variable(token);
        }
    }

    public static Expr parse(String expression) {
        var stack = new ArrayDeque<Expr>();
        Arrays.stream(expression.split(" ")).filter(token -> Character.isLetter(token.charAt(0))).forEach(token ->
                stack.push(parseToken(token, stack))
        );
        Arrays.stream(expression.split(" ")).filter(token -> !Character.isLetter(token.charAt(0))).forEach(token ->
                stack.push(parseToken(token, stack))
        );
        return stack.pop();
    }

    public static void main(final String[] args) {
        String expression = "a * b - c + (d  / e)";

        var expr = parse("one + two");
        var context = Map.of("one", 10, "two", 5);
        var result = expr.interpret(context);
        System.out.println(result);
    }
}