package com.company;

import java.io.File;
import java.util.*;

public class LibraryAnalyzer {
    private final List<File> discoveredLibs = new ArrayList<>();
    private final List<String> archTypes = new ArrayList<>();

    public void inspectFolder(String path) {
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid directory: " + path);
            return;
        }
        collectLibraries(folder);
    }

    private void collectLibraries(File directory) {
        File[] entries = directory.listFiles();
        if (entries == null) return;

        for (File file : entries) {
            if (file.isDirectory()) {
                collectLibraries(file);
            } else if (file.getName().endsWith(".so")) {
                String arch = ArchitectureIdentifier.identify(file);
                if (arch != null) {
                    discoveredLibs.add(file);
                    archTypes.add(arch);
                }
            }
        }
    }

    public void displayResult() {
        System.out.printf("%-30s %-15s%n", "File", "ArchType");
        System.out.printf("%-30s %-15s%n", "====", "=========");

        for (int i = 0; i < discoveredLibs.size(); i++) {
            String fileName = discoveredLibs.get(i).getName();
            String arch = archTypes.get(i);
            System.out.printf("%-30s %-15s%n", fileName, arch);
        }
    }
}
