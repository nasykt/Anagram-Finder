import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AnagramAndPalindrome{
    
   public static void main (String[] args) throws FileNotFoundException, IOException{
       
	 Scanner s = new Scanner(new File("words.txt"));
	 ArrayList<String> words = new ArrayList<>();  
         while (s.hasNext()) {
            words.add(s.next());   
         }  
        
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Printing Anagram and Palindrome from given File\n");          
        char ch;
        //  Perform output selection operations  
        do
        {    System.out.println("Choose an Option:");
             System.out.println("1. Anagram Lists From Given File");
             System.out.println("2. Palindrome Lists From Given File");
             int choice = Integer.parseInt(b.readLine());
            switch (choice)
            {
            case 1 : 
                
                
                System.out.println("Anagrams Of Given Lists : ");
                Map<String, List<String>> Anagrams=findAnagrams(words);                
 
                for (Map.Entry<String, List<String>> entry : Anagrams.entrySet()){  
                { 
                 //String key = entry.getKey();
                List<String> values = entry.getValue();
                String a = values.toString();
                a = a.substring(1, a.length()-1);
                 if ( values.size()>= 2) {  
                  //System.out.print(" " + key+"   ");               
                  System.out.println("--> "+ a + " "); 
                 }}
                }
                break;                         
            case 2 : 
                System.out.println("Palindromes Of Given Lists : ");
                Palindrome(words);                    
                break;    
                               
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
           
            System.out.println("\nDo you want to continue (Type y or n) \n"); 
            ch = b.readLine().charAt(0);
        } while (ch == 'Y'|| ch == 'y');               
    }

    
     
     
 
     
     //method for Anagram
    private static Map <String,List<String>>findAnagrams(List<String> words){
	      Map<String,List<String>>anagrams=null;
	       if(words == null || words.isEmpty() ){
		   return null;
	       }
	       anagrams = new HashMap<>(); 
	        for(String word : words){
                    if(word.length()>1){
		     char[] charArray = word.trim().toCharArray();
		     Arrays.sort(charArray);
		     String sortedWord =String.valueOf(charArray);
		    if(anagrams.containsKey(sortedWord)){
			List<String> newList = anagrams.get(sortedWord);
			newList.add(word);
			anagrams.put(sortedWord,newList);         
		     }
		    else{
			List<String> list=new ArrayList<>();
			list.add(word);
			anagrams.put(sortedWord, list);       
		     }
                    }	
                }
                return anagrams;
    }

    
    
    
    
    //method for palindrom
    private static void Palindrome(List<String> words){
         
         for(String word : words){
            if(word.length()>1){
                String str=word;
                String original = str;
                int length = original.length();
                String reverse = "";
                     for ( int i = length - 1; i >= 0; i-- )
                     reverse = reverse + original.charAt(i);                       
                        if (original.equals(reverse)){                         
                         System.out.println("--> "+original);
                        }
                         
            }
        }
    }
}
  

  