.PHONY: all clean doc compile

PEERSIM_DIR=$(HOME)/app/peersim-1.0.5
LIB_JARS=$(wildcard lib/*.jar)

compile:
	mkdir -p classes
	javac -sourcepath src -classpath $(PEERSIM_DIR)/peersim-1.0.5.jar:$(LIB_JARS) -d classes $(wildcard src/peersim/pastry/*.java)

doc:
	mkdir -p doc
	javadoc -Xdoclint:none -sourcepath src -classpath "$(PEERSIM_DIR)/peersim-1.0.5.jar::classes" -d doc peersim.pastry

run:
	java -cp "$(LIB_JARS):$(PEERSIM_DIR)/peersim-1.0.5.jar:$(PEERSIM_DIR)/jep-2.3.0.jar:$(PEERSIM_DIR)/djep-1.0.0.jar:classes" peersim.Simulator example.cfg

all: compile doc run

clean:
	rm -fr classes doc
