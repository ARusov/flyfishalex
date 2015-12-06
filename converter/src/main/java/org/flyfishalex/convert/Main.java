package org.flyfishalex.convert;

import org.flyfishalex.convert.parser.TestImport;
import org.flyfishalex.convert.parser.rybolovorg.RybolovImporter;
import org.flyfishalex.convert.parser.vision.VisionImporter;

import java.io.IOException;

/**
 * Created by arusov on 02.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 2) {
            if (args[0].equals("update")) {
                if (args[1].equals("rybolov")) {
                    RybolovImporter rybolovImporter = new RybolovImporter();
                    rybolovImporter.doImport();
                }
                if (args[1].equals("vision")) {
                    VisionImporter visionImporter= new VisionImporter();
                    visionImporter.doImport();
                }
                if (args[1].equals("test")) {
                    TestImport testImport= new TestImport();
                    testImport.foImport();
                }
                else {
                    System.out.println("provider has not been found");
                }
            }
        } else {
            System.out.println("please use parameters update <provider>");
            System.exit(1);
        }
    }

}
