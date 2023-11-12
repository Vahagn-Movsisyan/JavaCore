package homeworks.hm12FileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil implements Command {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Command.printCommands();
            String choice = SCANNER.nextLine();
            switch (choice) {
                case EXIT -> isRun = false;
                case SEARCH_FILE -> fileSearch();
                case CONTENT_SEARCH -> contentSearch();
                case FIND_LINES -> findLines();
                case PRINT_SIZE_PACKAGE -> printSizeOfPackage();
                case CREATE_FILE_WITH_CONTENT -> createFileWithContent();
                default -> System.out.println("Unknown Command!");
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("Enter filepath and filename by ',':");
        String path = SCANNER.nextLine();
        String[] pathAndFilename = path.split(",");

        //To avoid the ArrayIndexOutOfBoundException
        if (pathAndFilename.length != 2) {
            System.out.println("Invalid input!");
            return;
        }

        File folder = new File(pathAndFilename[0].trim());
        String targetFileName = pathAndFilename[1].trim();
        fileSearchRecursive(folder, targetFileName);
    }

    static void fileSearchRecursive(File path, String targetFileName) {
        if (path.exists() && path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(targetFileName)) {
                        System.out.println("File is exist");
                        return;
                    } else if (file.isDirectory()) {
                        fileSearchRecursive(file, targetFileName);
                        return;
                    }
                }
            }
        }
        System.out.println("File dosen't exist");
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.println("Enter filepath and keyword by ',':");
        String path = SCANNER.nextLine();
        String[] filepathAndKeyword = path.split(",");

        //To avoid the ArrayIndexOutOfBoundException
        if (filepathAndKeyword.length != 2) {
            System.out.println("Invalid input!");
            return;
        }

        File folder = new File(filepathAndKeyword[0].trim());
        String totalKeyword = filepathAndKeyword[1].trim();

        contentSearchRecursive(folder, totalKeyword);
    }

    static void contentSearchRecursive(File path, String totalKeyword) {
        if (path.exists() && path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        contentSearchRecursive(file, totalKeyword);
                    } else if (file.isFile() && file.getName().endsWith(".txt")) {
                        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                if (line.contains(totalKeyword)) {
                                    System.out.println("Found in " + file.getName());
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        boolean isFound = false;
        System.out.println("Enter the path and keyword by ',':");
        String path = SCANNER.nextLine();
        String[] patAndKeywordArr = path.split(",");

        File file = new File(patAndKeywordArr[0].trim());
        String keyword = patAndKeywordArr[1].trim();

        //To avoid the ArrayIndexOutOfBoundException
        if (patAndKeywordArr.length != 2) {
            System.out.println("Invalid input!");
            return;
        }

        if (file.exists() && file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String foundLine;
                int lineCount = 0;

                while ((foundLine = bufferedReader.readLine()) != null) {
                    lineCount++;
                    if (foundLine.equals(keyword)) {
                        System.out.println(lineCount + "-" + foundLine);
                        isFound = true;
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (!isFound) {
                System.out.println(keyword + " dosen't found");
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("Enter the path:");
        String path = SCANNER.nextLine();

        File folder = new File(path);
        long totalSize = calculateSizeOfPackage(folder);

        if (totalSize > 0) {
            System.out.println("Size of the package is " + totalSize);
        } else {
            System.out.println("Folder not found or empty");
        }
    }

    static long calculateSizeOfPackage(File path) {
        if (path.exists() && path.isDirectory()) {
            long totalSize = 0;
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        totalSize += file.length();
                    } else if (file.isDirectory()) {
                        totalSize += calculateSizeOfPackage(file);
                    }
                }
            }
            return totalSize;
        }
        return 0;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Enter the path, filename and content by ',':");
        String pathFilenameContent = SCANNER.nextLine();
        String[] pathFilenameContentArr = pathFilenameContent.split(",");

        if (pathFilenameContentArr.length != 3) {
            System.out.println("Invalid input. You must provide path, filename, and content.");
            return;
        }

        File folder = new File(pathFilenameContentArr[0].trim());
        File newFile = new File(folder, pathFilenameContentArr[1].trim());

        if (folder.exists() && folder.isDirectory()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile))) {
                folder.createNewFile();
                bufferedWriter.write(pathFilenameContentArr[2].trim());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
