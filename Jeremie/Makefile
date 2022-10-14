compile : 
	rm -f */*.class
# mkdir -p commons/bin
# mkdir -p server/bin
# mkdir -p client/bin
	javac -d commons/bin/ commons/src/commons/*.java
	javac -d server/bin/ -cp ./commons/bin/ server/src/server/*.java
	javac -d client/bin/ -cp ./commons/bin/ client/src/client/*.java
server : 
	java -cp "server/bin/server:commons/bin" server.bin.server.Server

#client:
#java -cp "client/bin/server:commons/bin" client/client