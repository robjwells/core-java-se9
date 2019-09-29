package ch03.ex12;

import java.io.File;

public class ListFilesWithExtension {
    public static void main(String[] args) {
        File root = new File(args[0]);
        String extension = args[1];

        File[] files = root.listFiles((dir, name) -> name.endsWith("." + extension));
        // `extension` variable captured by lambda expression from the enclosing scope
        assert files != null : "Directory not found";
        for (File f : files) {
            System.out.println(f);
        }
    }
}
