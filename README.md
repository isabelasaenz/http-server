# Java HTTP Server

This program creates a simple HTTP server using the `ServerSocket` and `Socket` classes. The server listens for incoming connections, accepts them, and responds with the system information of the machine it is running on. This information includes the operating system name and version, Java version, available processors, and total memory.

After compiling the program and running it, the server will start listening for connections on port 8080. To test the server, open a web browser to send an HTTP request to `http://localhost:8080`. The server will respond with the system information.

## Credits

Author: Isabela Cardoso

Heavily inspired by Javin Paul's [tutorial](https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html#ixzz81HPOUIno) at Javarevisited.

