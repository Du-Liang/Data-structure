package du.liang.Stack;

public class main {
    public static void main(String[] args) {

        Stack<Integer> Stack=new Stack<>();
        Stack.push(11);
        Stack.push(22);
        Stack.push(33);
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
    }
}
