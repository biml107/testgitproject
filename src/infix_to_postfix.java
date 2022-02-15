import java.io.*;
import java.util.*;
public class infix_to_postfix
{
    public static void main(String args[])
    {
        String infix="  ((A-(B/C))*((A/K)-L))";
        String postfix="";
       Stack<Character> operators=new Stack<>();
        System.out.println(postfix);
        int l=infix.length();
        for(int i=0;i<l;i++)
        {  char ch=infix.charAt(i);
            if( ch<=90&&ch>=65)
            { postfix+=infix.charAt(i);}
            else if(ch=='*'||ch=='^'||ch=='/'||ch=='+'||ch=='-')
            {
                while(operators.size()!=0&&priority_checker(operators.peek())>=priority_checker(ch))
                {
                    postfix+=operators.pop();
                }
                operators.push(ch);
            }
            else if(ch=='(')
                operators.push(ch);
            else if(ch==')')
            {
                while(operators.size()!=0&&operators.peek()!='(')
                    postfix+=operators.pop();
                operators.pop();
            }

          



        }
        while(operators.size()!=0)
            postfix+=operators.pop();
        System.out.println(postfix);
    }
    static int  priority_checker(char ch)
    {
        if(ch=='^')
            return 4;
        else if(ch=='*'||ch=='/')
            return 3;
        else if(ch=='+'||ch=='-')
        return 2;
        else return 1;
    }
}
