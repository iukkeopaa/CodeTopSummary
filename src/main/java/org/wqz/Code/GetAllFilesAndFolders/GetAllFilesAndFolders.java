package org.wqz.Code.GetAllFilesAndFolders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetAllFilesAndFolders {
    public static List<File> getAllFilesAndFolders(String directoryPath) {
        List<File> allFilesAndFolders = new ArrayList<>();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    allFilesAndFolders.add(file);
                    if (file.isDirectory()) {
                        allFilesAndFolders.addAll(getAllFilesAndFolders(file.getAbsolutePath()));
                    }
                }
            }
        }
        return allFilesAndFolders;
    }

    public static void main(String[] args) {
        String directoryPath = "your_directory_path";
        List<File> allFilesAndFolders = getAllFilesAndFolders(directoryPath);

        for (File file : allFilesAndFolders) {
            System.out.println(file.getAbsolutePath());
        }
    }
}    