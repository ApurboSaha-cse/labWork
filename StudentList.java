

import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		//Check number of arguments.
		if(args.length  != 1){
			System.err.println(Constant.invalid);
			System.err.println(Constant.MSG_USAGE);
			System.err.println(Constant.exit);
			System.exit(1);
		}

//		Check arguments
		if(args[0].equals(Constant.print)) { //List data arguments.
			System.out.println(Constant.load);
			try {
			//BufferedReader bufferedReader = readFile();
			//String line = readFile().readLine();
			//String studentName[] = readFile().readLine().split(Constant.comma);
			for(String student : readFile().readLine().split(Constant.comma)) {
				System.out.println(student);
			}
			} catch (Exception e){}
			System.out.println(Constant.loaded);
		}
		else if(args[0].equals(Constant.random)) { //Show random data arguments.
			System.out.println(Constant.load);
			try {
			//BufferedReader bufferedReader = readFile();
			//String line = readFile().readLine();
			String studentName[] = readFile().readLine().split(Constant.comma);
			//Random random = new Random();
			int randomStudentName = new Random().nextInt(studentName.length);
			System.out.println(studentName[randomStudentName]);
			} catch (Exception e){}
			System.out.println(Constant.loaded);
		}
		else if(args[0].contains(Constant.add)){ //Add data arguments.
			System.out.println(Constant.load);
			try {
			BufferedWriter bufferedWriter = writeFile();
			String inputData = args[0].substring(1);
	        //Date date = new Date();
	        //String format = Constant.dd;
	        //DateFormat dateFormat = new SimpleDateFormat(Constant.dd);
	        String formatDate = new SimpleDateFormat(Constant.dd).format(new Date());
			bufferedWriter.write(Constant.comma +inputData+ Constant.lastUpdate +formatDate);
			bufferedWriter.close();
			} catch (Exception e){}
			System.out.println(Constant.loaded);
		}
		else if(args[0].contains(Constant.search)) { //Search data arguments.
			System.out.println(Constant.load);
			try {
			//BufferedReader bufferedReader = readFile();
			//String line = readFile().readLine();
			String studentName[] = readFile().readLine().split(Constant.comma);
			
			//String inputData = args[0].substring(1);
			for(int index = 0; index<studentName.length; index++) {
				if(studentName[index].equals(args[0].substring(1))) {
					System.out.println(Constant.found);
					break;
				}
			}
			} catch (Exception e){}
			System.out.println(Constant.loaded);
		}
		else if(args[0].contains(Constant.count)) { //Count data arguments.
			System.out.println(Constant.load);
			try {
			System.out.println(readFile().readLine().split(Constant.comma).length + Constant.word);
			} catch (Exception e){}
			System.out.println(Constant.loaded);
		}
		else{ //Invalid arguments.
			System.err.println(Constant.invalid);
			System.err.println(Constant.MSG_USAGE);
			System.err.println(Constant.exit);
			System.exit(2);
		}

	}

	/**
	* Get first line from Students.txt file.
	* @return first line as string.
	* @throws Exception.
	*/

	private static BufferedReader readFile() throws FileNotFoundException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.studentsList)));
		return bufferedReader;
	}

	/**
	* Get student file buffer writer object.
	* @return BufferWriter of student file.
	*@throws Exception
	 */
	private static BufferedWriter writeFile() throws IOException {
		BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(Constant.studentsList, true));
		return bufferedReader;
	}

}