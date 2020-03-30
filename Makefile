all: setup

setup:
	chmod -R 755 scripts && scripts/setup.bash

clean:
	rm -r bin/*
