package org.flyfishalex.converter;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.util.List;

/**
 * Created by arusov on 2/27/2015.
 */
public class Parser {

    public static String[] getLine(List<String[]> allProducts, String articul) throws IOException {

        String[] nextLine = new String[0];
        try {

            for(String[] item:allProducts){
                nextLine=item;
                if(nextLine.length>=9){
                    if (nextLine[9].equals(articul)) {
                        return nextLine;
                    }
                }
            }


        } catch (Exception e) {
            System.err.println(nextLine[0]);
            e.printStackTrace();

            return null;
        }
        return null;
    }

}
