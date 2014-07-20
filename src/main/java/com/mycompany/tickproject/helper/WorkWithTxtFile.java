package com.mycompany.tickproject.helper;

import com.mycompany.tickproject.models.RowAndSeat;
import com.mycompany.tickproject.models.SectionOfStadium;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** This class provide methods that are used to work with text files. Text files contain some data about seats and rows
 * @author jenias
 * @version 1.0, 09/07/14
 */
public class WorkWithTxtFile {

    List<String> fileNames;

    public WorkWithTxtFile(){
        fileNames = new ArrayList<String> ();
    }

    public ArrayList<RowAndSeat> getRowsAndSeatsFromFile (String pathToFile, SectionOfStadium sectionOfStadium) throws FileNotFoundException {
        ArrayList<RowAndSeat> list = new ArrayList<>();
        int row = 0;
        String retrievedStr = "";
        String [] strArray;
        Scanner in = new Scanner(new File(pathToFile));
        while(in.hasNext()) {
            row++;
            retrievedStr += in.nextLine() + "\r\n";
            strArray = new String [retrievedStr.length()];
            strArray = retrievedStr.split("\\s+");

            for(int i=0;i<strArray.length;i++) {
                int seat =(int)Double.parseDouble(strArray[i]);
                RowAndSeat ras = new RowAndSeat();
                ras.setRow(row);
                ras.setSeat(seat);
                ras.setSectionOfStadium(sectionOfStadium);
                list.add(ras);
            }
            strArray=null;
            retrievedStr = "";
        }

        in.close();
        return list;
    }

    public void uploadFileOnTheServer(List<MultipartFile> files) {
        String saveDirectory ="/Users/apple/IdeaProjects/tickproject/src/main/webapp/textfiles/";
        List<String> fileNames = new ArrayList<String>();

        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                if(fileName.length()!=0)
                {
                    if (!"".equalsIgnoreCase(fileName)) {
                        if(checkExistsFileInFolder(saveDirectory,fileName)==false) {
                            try {
                                multipartFile
                                        .transferTo(new File(saveDirectory + fileName));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        fileNames.add(fileName);
                    }
                }
            }
            this.fileNames = fileNames;
        }
    }

    public boolean checkExistsFileInFolder(String directory, String fileName) {
        String temp = fileName + ".txt";
        boolean check = new File(directory, temp).exists();
        return check;
    }
    public List<String> getFileNames() {
        return this.fileNames;
    }
}
