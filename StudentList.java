

import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args.length > 1 || args.length < 1){
			System.err.println("Invalid number of arguments.");
			System.err.println("Exiting program");
			System.exit(1);
		}

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			String studentName[] = line.split(", ");
			for(String student : studentName) {
				System.out.println(student);
			}
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			String studentName[] = line.split(", ");
			Random random = new Random();
			int randomStudentName = random.nextInt(studentName.length);
			System.out.println(studentName[randomStudentName]);
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
			String inputData = args[0].substring(1);
	        Date date = new Date();
	        String format = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(format);
	        String formatDate= dateFormat.format(date);
			bufferedWriter.write(", "+inputData+"\nList last updated on "+formatDate);
			bufferedWriter.close();
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			String studentName[] = line.split(",");
			boolean done = false;
			String inputData = args[0].substring(1);
			for(int index = 0; index<studentName.length && !done; index++) {
				if(studentName[index].equals(inputData)) {
					System.out.println("We found it!");
					done=true;
				}
			}
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			char charArray[] = line.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char character:charArray) {
				if(character ==' ') {
					count++;
				}
			}
			System.out.println(count +" word(bufferedReader) found " + charArray.length);
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else{
			System.err.println("Invalid arguments.");
			System.err.println("Exiting program.");
			System.exit(2);
		}

	}
}