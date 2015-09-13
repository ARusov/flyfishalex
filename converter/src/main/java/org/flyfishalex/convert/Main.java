package org.flyfishalex.convert;

import org.flyfishalex.convert.parser.rybolovorg.RybolovImporter;
import org.flyfishalex.convert.parser.rybolovorg.RybolovParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Created by arusov on 02.08.2015.
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 2) {
            if (args[0].equals("update")) {
                if (args[1].equals("rybolov")) {
                    RybolovImporter rybolovImporter= new RybolovImporter();
                    rybolovImporter.doImport();
                } else {
                    System.out.println("provider has not been found");
                }
            }
        } else {
            System.out.println("please use parameters update <provider>");
            System.exit(1);
        }
    }

}
