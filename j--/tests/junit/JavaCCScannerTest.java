// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package junit;

import jminusminus.JavaCCMain;
import junit.framework.TestCase;

import java.io.File;

/**
 * JUnit test case for the JavaCC scanner.
 */
public class JavaCCScannerTest extends TestCase {

    /**
     * Construct a JavaCCScannerTest object.
     */
    public JavaCCScannerTest() {
        super("JUnit test case for the scanner");
    }

    /**
     * Run the scanner against each pass-test file under the folder specified by
     * PASS_TESTS_DIR property.
     */
    public void testPass() {
        File passTestsDir = new File(System.getProperty("PASS_TESTS_DIR"));
        File[] files = passTestsDir.listFiles();
        boolean errorHasOccurred = false;
        for (int i = 0; files != null && i < files.length; i++) {
            if (files[i].toString().endsWith(".java")) {
                String[] args = null;
                System.out.printf("Running javacc scanner on %s ...\n\n", files[i].toString());
                args = new String[]{"-t", files[i].toString()};
                JavaCCMain.main(args);
                System.out.printf("\n\n");

                // true even if a single test fails
                errorHasOccurred |= JavaCCMain.errorHasOccurred();
            }
        }

        // We want all tests to pass
        assertFalse(errorHasOccurred);
    }

    /**
     * Entry point.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(JavaCCScannerTest.class);
    }

}
