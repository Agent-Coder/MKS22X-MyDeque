public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] ary=s.split(" ",0);
      MyDeque<String> expression=new MyDeque<>(ary.length);
      for (int i=0;i<ary.length;i++) {
        if(ary[i].equals("+")){
          double x=Double.parseDouble(expression.removeLast());
          double y=Double.parseDouble(expression.removeLast());
          expression.addLast(y+x+"");
        }
        else if(ary[i].equals("-")){
          double x=Double.parseDouble(expression.removeLast());
          double y=Double.parseDouble(expression.removeLast());
          expression.addLast(y-x+"");
        }
        else if(ary[i].equals("*")){
          double x=Double.parseDouble(expression.removeLast());
          double y=Double.parseDouble(expression.removeLast());
          expression.addLast(y*x+"");
        }
        else if(ary[i].equals("/")){
          double x=Double.parseDouble(expression.removeLast());
          double y=Double.parseDouble(expression.removeLast());
          expression.addLast(y/x+"");
        }
        else if(ary[i].equals("%")){
          double x=Double.parseDouble(expression.removeLast());
          double y=Double.parseDouble(expression.removeLast());
          expression.addLast(y%x+"");
        }
        else{
          expression.addLast(ary[i]);
        }
      }
      return Double.parseDouble(expression.removeLast());
    }
    public static void main(String[] args) {
      System.out.println(eval("10 2.0 -"));
      System.out.println(eval("11 3 - 4 + 2.5 *"));
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
