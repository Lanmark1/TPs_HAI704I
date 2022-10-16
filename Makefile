compile: 
	javac -d TP1RMICommons/bin/ TP1RMICommons/src/commons/*.java
	javac -d TP1RMIServer/bin/ -cp ./TP1RMICommons/bin/ TP1RMIServer/src/server/*.java
	javac -d TP1RMIClient/bin/ -cp ./TP1RMICommons/bin/ TP1RMIClient/src/client/*.java

server:
	java TP1RMIServer/bin/server/Server

client:
	java -cp "client/bin:TP1RMICommons/bin" client.client

clean: 
	rm -f TP1RMIServer/bin/*.class
	rm -f TP1RMIClient/bin/*.class
	rm -f TP1RMICommons/bin/*.class