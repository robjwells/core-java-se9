package ch03.ex13;

import java.io.File;
import java.util.*;

public class SortFiles {
    public static void main(String[] args) {
        File[] files = new File("/Library/Logs/").listFiles();
        assert files != null;
        List<File> fileList = new ArrayList<File>(Arrays.asList(files));
        Collections.shuffle(fileList);
        files = fileList.toArray(File[]::new);

        sortFiles(files);
        for (File f : files) {
            System.out.println(f);
        }
    }

    static void sortFiles(File[] files) {
        Arrays.sort(files, (first, second) -> {
            if (first.isDirectory() != second.isDirectory()) {
                return first.isDirectory() ? -1 : 1;
            }
            return first.getPath().compareTo(second.getPath());
        });
    }
}
