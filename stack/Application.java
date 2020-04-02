package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
/**
 * this class changes the infix expression to postfix expression with infixToPostfix function
 * calculate the value of the postfix expression with Evaluate function
 * 
 *
 */
public class Application implements IExpressionEvaluator {
	
	/**
	 * To remove the spaces of the string
	 * @param s
	 * the string with spaces
	 * @return the same string but without spaces
	 */
	public String trim(String s) {
		String i="";
		for(int j=0;j<s.length();j++) {
			if(s.charAt(j)==' ') {}
			else {
				i+=s.charAt(j);
			}
		}
		return i;
	}
	/**
	 * To arrange the presidence of the operations
	 * @param x
	 * is the operation
	 * @return the presedence of the operation
	 */
   public int presidence(char x) {
	   if (x=='*' || x=='/') {
		   return 2;
	   }
	   else if (x=='+' || x=='-') {
		   return 1;
	   }
	   else return 0;
   }
   /**
   * Takes a symbolic/numeric infix expression as input and converts it to
   * postfix notation. There is no assumption on spaces between terms or the
   * length of the term (e.g., two digits symbolic or numeric term)
   *
   * @param expression
   * infix expression
   * @return postfix expression
   */
   public String infixToPostfix(String expression) {
	   expression=trim(expression);
	   String result = new String();
	   String str = new String();
       str ="";
	   result="";
	   stack a = new stack();
	   for(int k=0;k<expression.length();k++) {
		   if(k<expression.length()-1 && Character.isDigit(expression.charAt(k)) && Character.isLetter(expression.charAt(k+1)) ) {
			   throw new RuntimeException("Invalid expression");
		   }
		   else if(k<expression.length()-1 && Character.isLetter(expression.charAt(k)) && ((Character.isLetter(expression.charAt(k+1))) || Character.isDigit(expression.charAt(k+1)))) {
			   throw new RuntimeException("Invalid expression");
		   }
	   }
	   if(expression.charAt(0)=='-') {
		   expression= "0 "+expression;
	   }
	   for(int i=0;i<expression.length();i++) {
		   if(Character.isDigit(expression.charAt(i)) || Character.isLetter(expression.charAt(i))) {
			   int j=i;
			   if(Character.isDigit(expression.charAt(i))) {
				   while(j<expression.length() && Character.isDigit(expression.charAt(j))==true) {
					   str+=expression.charAt(j);
					   j++;
				   }
				   i=j-1;
				   result+=str+" " ;
				   str="";
			   } 
		           else {
				   result+=expression.charAt(i)+" ";
			   } }
		   else if(expression.charAt(i)== ' ') {}
		   else if(expression.charAt(i)=='(') {
			   a.push('(');
		   }
		   else if(expression.charAt(i)==')') {
		     while(a.isEmpty()==false && (char) a.peek()!='(') {
		    	 result+=a.pop()+" ";
		     }
		     
		     if(a.isEmpty()==true) {
		    	 throw new EmptyStackException();
		     }
		     else {
		     a.pop(); }
		   } 
		   else if(a.isEmpty()==true) {
			   a.push(expression.charAt(i));
		   }
		   else if(a.isEmpty()==false && (expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*' || expression.charAt(i)=='/' )) {
               if(expression.charAt(i)=='-' && (expression.charAt(i-1)=='+' || expression.charAt(i-1)=='-' || expression.charAt(i-1)=='*' || expression.charAt(i-1)=='/' ||expression.charAt(i-1)=='(' )) {
            	if(Character.isLetter(expression.charAt(i+1))) {
            		result+="0"+" "+expression.charAt(i+1)+" "+"-"+" ";
            		i=i+1;
            	}
            	else if(Character.isDigit(expression.charAt(i+1))) {
            		int k=i+1;
            		String x="";
            		while(k<expression.length() && Character.isDigit(expression.charAt(k))==true) {
 					   x+=expression.charAt(k);
 					   i++;
 					   k++;
            	  }
            	
            		result+="0"+" "+x+" "+"-"+" ";
               }
               }
               else  {
			   
			   if(presidence(expression.charAt(i))>presidence( (char) a.peek())) {
			   a.push(expression.charAt(i));
		   }
		   else if(presidence(expression.charAt(i))<=presidence( (char) a.peek())) {
			   while(a.isEmpty()==false && presidence(expression.charAt(i))<=presidence( (char) a.peek())) {
				   result+=a.pop()+" ";
			   }
			   a.push(expression.charAt(i));
			   
		   }   
			   
			   
		   }
	   } }
	   while(a.isEmpty()==false) {
		   result+=a.pop()+" ";
	   }
	   result = result.substring(0,result.length()-1);
	   return result;   
   }
   /**
   * Evaluate a postfix numeric expression, with a single space separator
   *
   * @param expression
   * postfix expression
   * @return the expression evaluated value
   */
   public int evaluate(String expression) {
	   double result;
	   String x ="";
	   char c;
	   stack s = new stack();
	   for(int i=0;i<expression.length();i++) {
		   c=expression.charAt(i);
		   if(Character.isDigit(c) || c=='+' || c=='-' || c=='*' || c=='/') {
			   if(Character.isDigit(c)) {
				   while(Character.isDigit(expression.charAt(i))) {
					   x+=expression.charAt(i);
					   i++;
				   }
				   s.push(x);
				   x="";
				   i--;
			   }
			   else {
				    if(c=='+') {
				    	if(s.size()>=2) {
				    	result=Double.parseDouble(s.pop().toString()) + Double.parseDouble(s.pop().toString());
				    	s.push(result); }
				    	else {
							throw new EmptyStackException();
				    	}
				   }
				    else if(c=='-') {
				    	if(s.size()>=2) {
				    	double a= Double.parseDouble(s.pop().toString());
				    	double b =Double.parseDouble(s.pop().toString());
				    	result = b-a;
				    	s.push(result); }
				    	else {
							throw new EmptyStackException();

				    	}
				    }
				    else if(c=='*') {
				    	if(s.size()>=2) {
				    	result=Double.parseDouble(s.pop().toString()) *Double.parseDouble(s.pop().toString());
				    	s.push(result); }
				    	else {
							throw new EmptyStackException();
				    	}
			   }
				    else if(c=='/') {
				    	if(s.size()>=2) {
				    	double a= Double.parseDouble(s.pop().toString());
				    	double b = Double.parseDouble(s.pop().toString());
				    	result = b/a;
				    	s.push(result); }
				    	else {
							throw new EmptyStackException();
				    	}
		   }
	   } }
			   else if(c==' ') { }
			   else {
				   throw new RuntimeException("Invalid Expression");
			   }
		   
	   }
	   double d = Double.parseDouble(s.pop().toString());
	   int finalResult = (int)d; 
	   return(finalResult);
   }
   
   
   
}
