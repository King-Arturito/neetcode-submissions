class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack();
        if (s.length() % 2 == 1 ) {return false;}
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' ||  c == '{' || c == '[')  {
                st.push(c);
            } else{
                if(st.isEmpty()) return false;

                char ch = (Character) st.pop();
                if (ch == '(' && c != ')') return false;
                if (ch == '{' && c != '}') return false;
                if (ch == '[' && c != ']') return false;
            }
        }

        return st.isEmpty();
    }
}
