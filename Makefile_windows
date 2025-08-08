# Makefile for Java project in src/com/company

SRC_DIR=src
BIN_DIR=out
PACKAGE=com.company
MAIN_CLASS=$(PACKAGE).Main

# Converts com.company.Main → com/company/Main
MAIN_CLASS_PATH=$(subst .,/,$(MAIN_CLASS))

# Find all Java files under src
SOURCES=$(shell find $(SRC_DIR) -name "*.java")

# Default target
all: compile run

compile:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(SOURCES)

run:
	java -cp $(BIN_DIR) $(MAIN_CLASS) $(FOLDER)

clean:
	rm -rf $(BIN_DIR)
