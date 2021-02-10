import java.util.*;
public class RabinKarp
{
    int d=101,t=255;
    public int hashvalue(String s)
    {
        int res=0,l = s.length();
        for(int i=0;i<l;i++)
        res = res + ((int)s.charAt(i)*(int)Math.pow(d,i))/t;
        return res;
    }
    public void search(String str, String pat)
    {
        int l_str = str.length(), l_pat = pat.length();
        String txt = str.substring(0,l_pat);
        int p = hashvalue(pat),t = hashvalue(txt);
        int flag = 0;
        for(int i=0;i<=l_str-l_pat;i++)
        {
            if(t==p)
            {
                if(txt.compareTo(pat)==0)
                {
                    System.out.println("Pattern found at "+i);
                    flag++;
                }
            }
            if(i<l_str-l_pat)
            {
                txt = str.substring(i+1,i+l_pat+1);
                t = hashvalue(txt);
            }
        }
        if(flag==0)
        System.out.println("Pattern not found");
    }
    public static void main()
    {
        Scanner obj = new Scanner(System.in);
        RabinKarp ob = new RabinKarp();
        System.out.println("Enter the string");
        String s = obj.nextLine();
        System.out.println("Enter the pattern to be searched");
        String p = obj.nextLine();
        ob.search(s,p);
    }
}
