import java.io.File;
import java.util.Scanner;


public class ShellTester {

	static String workingDir;

	public static void main(String[] args) {
		
		System.out.println("Welcome to SHELLa Good, a proof-of-concept Java "
				+ "shell made by Josh Lieberman.");
		// get working directory
		System.out.println("getting working directory...");
		workingDir = System.getProperty("user.dir");
		System.out.println("your working directory is: " + workingDir);
		printSupportedCommands();
		// scanner
		System.out.println("Setting up your scanner...");
		Scanner sc = new Scanner(System.in);
		System.out.println("We're good to go!");

		// infinite loop
		while(true) {
			System.out.print("Command me, baby$ ");
			String command = sc.nextLine();
//			System.out.println(command);

			processCommand(command);
		}


		// Directory path here
		//		String path = "."; 
		//
		//		String files;
		//		File folder = new File(path);
		//		File[] listOfFiles = folder.listFiles(); 
		//		
		//		for (int i = 0; i < listOfFiles.length; i++) {
		//
		//				files = listOfFiles[i].getName();
		//				System.out.println(files);
		//		}
		//
		//		String current = System.getProperty("user.dir");
		//		System.out.println("Current working directory in Java (using System.getProperty): " + current);
		//
		//		String currentDir = new File(".").getAbsolutePath();
		//		System.out.println("Current working directory in Java (using getAbsolutePath): " + currentDir);

		//		try {
		//			Process p = Runtime.getRuntime().exec("ls -l");
		//			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		//			String line = null;
		//			while ((line = in.readLine()) != null) {
		//				System.out.println(line);
		//			}
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}

	}

	private static void printSupportedCommands() {
		System.out.println("Supported commands: "
				+ "ls, "
				+ "pwd, "
				+ "mkdir [new_dir], "
				+ "logout");
		
	}

	private static void processCommand(String command) {
		
		if(command.contains("mkdir")) {
			if(command.length() == 5) {
				System.out.println("Usage: mkdir [new_dir]");
			} else {
				
			String[] splitString = command.split("\\s+");
			new File(workingDir +"/" + splitString[1]).mkdirs();
			
//			System.out.println(splitString.length);
//			for(int i = 0; i < splitString.length; i++) {
//				System.out.println(splitString[i]);
//			}
			}
		}

		else if(command.equals("pwd")) {

			System.out.println(workingDir);

			command = "";
		}

		else if(command.equals("ls")) {

//			Directory path here
			String path = "."; 

			String files;
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles(); 

			for (int i = 0; i < listOfFiles.length; i++) {

				files = listOfFiles[i].getName();
				
				if (listOfFiles[i].isDirectory())  { // if file is directory
					String newFolder = listOfFiles[i].toString();
					// need to remove leading ./
					if(newFolder.charAt(0) == '.' && newFolder.charAt(1) == '/') {
						newFolder = newFolder.substring(2);
						newFolder = newFolder + "/";
						System.out.println(newFolder);
					}
//					System.out.println("folder:" + newFolder);
//					newFolder.replace("./", "");
					
//					System.out.println(newFolder);
//					if(!newFolder.equals(".//") || !newFolder.equals("..//"))
//					newFolder.concat("/");
//					System.out.println("folder: " + newFolder);
				} else // normal file
				System.out.println(files);
			}
		}
		
		else if(command.equals("logout")) {
			System.out.println("Sayonara, suckers!");
			System.exit(0);
		}
		
		else {
			System.out.println("Unknown or unsupported command: " + command);
		}

	}

}
