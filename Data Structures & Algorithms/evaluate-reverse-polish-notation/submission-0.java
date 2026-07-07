class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();

      for (String token : tokens) {
        if (token.equals("+")) {
          if (stack.size() < 2) {
            return 0;
          }
          Integer second = stack.pop();
          Integer first = stack.pop();
          stack.push(first + second);
        } else if (token.equals("-")) {
          if (stack.size() < 2) {
            return 0;
          }
          Integer second = stack.pop();
          Integer first = stack.pop();
          stack.push(first - second);
        } else if (token.equals("*")) {
          if (stack.size() < 2) {
            return 0;
          }
          Integer second = stack.pop();
          Integer first = stack.pop();
          stack.push(first * second);
        } else if (token.equals("/")) {
          if (stack.size() < 2) {
            return 0;
          }
          Integer second = stack.pop();
          Integer first = stack.pop();
          stack.push(first / second);
        } else {
          int val = Integer.parseInt(token.trim());
          stack.push(val);
        }
      }

      return stack.peek();
    }
  }