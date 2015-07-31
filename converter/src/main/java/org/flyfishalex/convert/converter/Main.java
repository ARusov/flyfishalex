package org.flyfishalex.convert.converter;


import org.flyfishalex.convert.parser.FFParser;
import org.flyfishalex.convert.parser.VisionParser;
import org.flyfishalex.convert.parser.XLSParser;

import java.io.File;

/**
 * Created by arusov on 2/23/2015.
 */
public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Projects\\flyfishalex\\converter\\input");
        if (file.exists()){
            File[] inputFiles=file.listFiles();
            for(File input:inputFiles){
                if(input.getName().trim().toLowerCase().contains("vision")){
                    XLSParser parser= new VisionParser(input);
                    parser.convert();

                }
                if(input.getName().trim().toLowerCase().contains("ff")){
                    XLSParser parser= new FFParser(input);
                    parser.convert();

                }
            }
        }else{
            System.exit(1);
        }
        System.out.println("finish");
    }
}
