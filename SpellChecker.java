import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SpellChecker {
	
  static ArrayList<String> dict;
  static ArrayList<String> document;
  static HashMap<Character, Pointers> pointerReference;
  static String docCurrentLine;
  static char firstChar;
  
 

  
 public static void main(String[] args){
	 readDictionary(args[1]);
	 BufferedReader readDocument;
	try {
		readDocument = new BufferedReader(new FileReader(args[0]));
		document = new ArrayList<>();
		 while ((docCurrentLine = readDocument.readLine()) != null) {
			 firstChar = docCurrentLine.charAt(0);
			 int returnValue =  Arrays.binarySearch(dict.toArray(), pointerReference.get(firstChar).getStartReference(), pointerReference.get(firstChar).getEndReference(), docCurrentLine);
			 if(returnValue < 0){
				 int replaceValue = returnValue * -1;
				 docCurrentLine = dict.get(replaceValue);
				 
			 }
			 document.add(docCurrentLine);
			}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	// writing the file from the array
	
	File fileOutput = new File("document-corrected.txt");
    try {
			fileOutput.createNewFile();
			FileWriter fw = new FileWriter(fileOutput.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0;i<=document.size()-1; i++)
			{
				bw.write(document.get(i)+"\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 }
	
   public static void readDictionary(String file){
	   String sCurrentLine;
	   BufferedReader br;
	   char firstLetter;
	   int startReference = 0, currentReference  = 0;
	   pointerReference = new HashMap<Character, Pointers>();
	   dict = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(file));
			firstLetter = br.readLine().charAt(0);
			System.out.println(firstLetter);
			while ((sCurrentLine = br.readLine()) != null) {
				currentReference++; 
				dict.add(sCurrentLine);
				char first = sCurrentLine.charAt(0);
				if(firstLetter != first){
					Pointers pointer = new Pointers(startReference, currentReference-1, firstLetter);
					pointerReference.put(firstLetter, pointer );
					// this is the beginning of another first character
					firstLetter = first;
					startReference = currentReference;
				}
				
			}
		} 
		catch (FileNotFoundException  e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
 }
   
 
   
	

}
