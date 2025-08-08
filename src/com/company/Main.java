package com.company;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -cp . com.company.Main <folder-path>");
            return;
        }

        String folderPath = args[0];
        LibraryAnalyzer analyzer = new LibraryAnalyzer();
        analyzer.inspectFolder(folderPath);
        analyzer.displayResult();
    }
}
