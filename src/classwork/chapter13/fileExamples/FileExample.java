package classwork.chapter13.fileExamples;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        String filePath = "\\AllJavaProjects\\JavaCore\\src\\classwork\\chapter13\\fileExamples";
        File file = new File(filePath);

        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File file1 : list) {
                System.out.println(file1);
            }
        }
    }
}
