package ussdprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ListFiles {

    int session = 0;

    public static void main(String[] args) {
        File folder = new File("G:\\Test");
        ListFiles listFiles = new ListFiles();
        listFiles.listAllFiles(folder);
    }

    public void listAllFiles(File folder) {
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            if (file.isDirectory()) {
                listAllFiles(file);
            } else {
                try {
                    readContent(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(session);
    }
    

    public void readContent(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("GETCUSTOMER")) {
                    session++;
                }
            }
        }
    }
    
    
    

}
