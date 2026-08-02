class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(String token : tokens) {
            if (token.equals("*") || token.equals("+") 
            || token.equals("-") || token.equals("/")) {
                String op = token;
                int b = stack.pop();
                int a = stack.pop();
                switch(op) {
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "+":
                        stack.push(a+b);
                        break;
                }
            }else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
