# Makefile for Java project in src/com/company

SRC_DIR = src
BIN_DIR = out
PACKAGE = com.company
MAIN_CLASS = $(PACKAGE).Main

# Converts com.company.Main → com/company/Main
MAIN_CLASS_PATH = $(subst .,/,$(MAIN_CLASS))

# Find all Java files under src
SOURCES = $(shell find $(SRC_DIR) -name "*.java")

# Optional folder to analyze (passed as argument)
FOLDER ?= libs

# Default target
all: compile run

# Compile all Java sources
compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES)

# Run the main class and pass the folder as argument
run:
	java -cp $(BIN_DIR) $(MAIN_CLASS) $(FOLDER)

# Clean the output directory
clean:
	rm -rf $(BIN_DIR)
