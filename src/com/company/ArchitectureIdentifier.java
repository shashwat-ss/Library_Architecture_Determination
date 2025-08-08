package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ArchitectureIdentifier {
    public static String identify(File soFile) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(soFile);
            byte[] header = new byte[20];
            if (stream.read(header) < 20) return null;
            if (header[0] != 0x7f || header[1] != 'E' || header[2] != 'L' || header[3] != 'F') return null;
            int machineCode = ((header[19] & 0xFF) << 8) | (header[18] & 0xFF);
            switch (machineCode) {
                case 0x28:
                    return "armeabi-v7a";
                case 0xB7:
                    return "arm64-v8a";
                case 0x03:
                    return "x86";
                case 0x3E:
                    return "x86-64";
                case 0x08:
                    return "mips";
                default:
                    return null;
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignore) {}
            }
        }
    }
}
