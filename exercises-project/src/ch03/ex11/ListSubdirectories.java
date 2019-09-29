package ch03.ex11;

import java.io.File;
import java.io.FileFilter;

public class ListSubdirectories {
    public static void main(String[] args) {
        File root = new File(args[0]);

        File[] lambdaFiles = root.listFiles((file) -> file.isDirectory());
        assert lambdaFiles != null : "Not a directory.";
        for (File dir : lambdaFiles) {
            System.out.println("Lambda: " + dir);
        }

        File[] methodExpressionFiles = root.listFiles(File::isDirectory);
        assert methodExpressionFiles != null : "Not a directory.";
        for (File dir : methodExpressionFiles) {
            System.out.println("Method expression: " + dir);
        }

        File[] anonymousClassFiles = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        assert anonymousClassFiles != null : "Not a directory.";
        for (File dir : methodExpressionFiles) {
            System.out.println("Anonymous class: " + dir);
        }
    }
}
