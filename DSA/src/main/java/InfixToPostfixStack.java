import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputExpression = sc.next();

        System.out.println("Infix Expression :"+ inputExpression);
        System.out.println("Postfix Expression :"+ evaluatePostfix(inputExpression));
    }

    private static String evaluatePostfix(String inputExpression) {
        String result = new String();
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i < inputExpression.length(); ++i){

            char ch = inputExpression.charAt(i);
            System.out.println("Char : " +ch);

            if(Character.isLetterOrDigit(ch)){
                result += ch;
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result += stack.pop();
                }
                stack.pop();
            }
            else{ // an operator is encountered
                while(!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())){
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    static int getPrecedence(char x){

        switch (x){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return -1;
    }


}
//a+b*(c^d-e)^(f+g*h)-i
//abcd^e-fgh*+^*+i-