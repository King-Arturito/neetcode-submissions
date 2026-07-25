class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                switch(token) {
                    case "+": s.push(a + b); break;
                    case "-": s.push(a - b); break;
                    case "*": s.push(a * b); break;
                    case "/": {
                        if (b == 0 || a == 0) {
                           s.push(0);
                        } else {
                            s.push(a/b);
                        }
                    break;
                    }
                }
            } else {
                s.push(Integer.parseInt(token));
            }
            
        }
        return s.pop();
    }
}
