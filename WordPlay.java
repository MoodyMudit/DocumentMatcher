import java.io.*;
import java.util.*;
class WordPlay
{
	public int wordCount(BufferedReader br, HashMap<String,Integer> map) throws IOException
        {
                int counter=0;
                String line;
                while((line=br.readLine())!=null)
                {
                        String words[]=line.split(" ");
                        for(int i=0;i<words.length;i++)
                        {
                                String curWord = formatWord(words[i]);
                                if(map.get(curWord)==null)
                                {
                                        map.put(curWord,counter);
                                        counter++;
                                }
                        }
                }
                return counter;
        }

	public String formatWord(String word)
        {
                word=word.toLowerCase();
                int len=word.length();
                if(len<1)
                        return word;
                if(word.charAt(len-1)=='.' || word.charAt(len-1)==')' || word.charAt(len-1)=='"' || word.charAt(len-1)==',' ||  word.charAt(len-1)==']' || word.charAt(len-1)==':')
                        word = word.substring(0,len-1);
                if(word.charAt(0)=='(' || word.charAt(0)=='"')
                        word = word.substring(1,word.length());
                //System.out.print("<"+word+"> ");
                return word;
        }
}
