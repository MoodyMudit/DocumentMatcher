import java.util.*;
class UselessKeywords
{
	public boolean uselessWord(String str)
        {
                str=str.toLowerCase();
                String words[]={"-","\\","/","or","is","a","the","that","we","they","are","me","you","at","has","be","of","to"};
                //String words[]={};
                for(int i=0;i<words.length;i++)
                {
                        if(str.equals(words[i]))
                                return true;
                }
                return false;
        }
}
