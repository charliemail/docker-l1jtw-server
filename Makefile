all: v380c

v380c: permission_380c compile_380c

permission_380c:
	chmod 755 ./L1J-TW_3.80c/build/ant/bin/ant

compile_380c:
	cd L1J-TW_3.80c; ./build/ant/bin/ant
