# Library Architecture Determination – ELF Architecture Identifier

# Project Overview

This tool recursively scans a given directory for `.so` (shared object) files, validates whether they are valid ELF libraries, and determines the target CPU architecture for each valid `.so` file.

Compatible Environments :
- Windows
- Linux
- Android

# How to Run the code
-> Using makefile
    Just add folder directory we want to test by replacing "libs"
    where libs = <PATH OF THE FOLDER>

OR

-> Windows
   - Go to src folder and open cmd and run below cmd
     javac -d out com/company/*.java
     java -cp out com.company.Main "<PATH OF THE FOLDER>"

-> LINUX/UNIX
    - Go to src folder and open cmd and run below cmd
      javac -d out com/company/*.java
      java -cp out com.company.Main "<PATH OF THE FOLDER>"



##  Project Structure
    ├── src/
    │ └── com/company/
    │ ├── Main.java
    │ ├── LibraryAnalyzer.java
    │ └── ArchitectureIdentifier.java
    ├── Makefile
    ├── README.md

Class Details :

1. Main.java
   The entry point for the application. 
   -It accepts the folder path from command-line arguments.
   -Invokes LibraryAnalyzer to inspect the folder and display results.

2. LibraryAnalyzer.java
   Responsible for:
   -Recursively scanning the directory.
   -Identifying files ending in .so.
   -Using ArchitectureIdentifier to determine architecture type.
   -Collecting and displaying results.

3. ArchitectureIdentifier.java
   -Performs the ELF parsing:
   -Verifies ELF magic numbers (0x7F, 'E', 'L', 'F').
   -Extracts the e_machine field from the ELF header to determine architecture.
   -Supports:
    0x28 → armeabi-v7a
    0xB7 → arm64-v8a
    0x03 → x86
    0x3E → x86-64
    0x08 → mips

#  ELF Validation
   -First 4 bytes: must match ELF magic numbers.
   -Architecture detection is based on little-endian interpretation of bytes at offsets 18 and 19 

#  References Used
   - ELF File Format Specification
   - GFG

AUTHOR
Shashwat Srivastava
srivshshwatss3@gmail.com
