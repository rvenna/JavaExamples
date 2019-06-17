package fileread;

/*
    Developer: RVENNA
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {

	public static void main(String[] args) {
         FileReader fr = new FileReader();	
		 File file = fr.getFileFromResources("datafiles/DataFile.txt");
		 System.out.println(file.exists());
		 
	     fr.getFileAsResourceStream("CommonDataFile.txt");
	}
	
	private File getFileFromResources(String fileName){
		ClassLoader classLoader = getClass().getClassLoader();
		String fileStr = classLoader.getResource(fileName).getFile();
		System.out.println(":::::::::::"+fileStr);
		File file = new File(fileStr);
		return file;
	}
	
	private void getFileAsResourceStream(String fileName){
		try{
			//if from static method use FileReader.class.getClassLoader();
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(fileName);
			int i=0;
			char c;
			/*while((i=inputStream.read())!=-1)
			{
                 c=(char)i;
                 System.out.print(c);
			}*/
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		
	}

}
