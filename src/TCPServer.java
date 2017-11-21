import java.net.*;
import java.io.*;
 
public class TCPServer{
    private Socket          socket   = null;
    private ServerSocket    serverSocket   = null;
    private DataInputStream dataInputStream       =  null;
    private DataOutputStream dataOutStream     = null;
 
    public TCPServer(int port){
        try{
        	serverSocket = new ServerSocket(port);
            System.out.println("TCP Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = serverSocket.accept();
            System.out.println("Client accepted");
 
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dataOutStream    = new DataOutputStream(socket.getOutputStream());
 
            String input = "";
 
            while (!input.equals("Over")){
                try {
                	input = dataInputStream.readUTF();
                    System.out.println("TCP Server: The Message sent by Client: "+input);
                    System.out.println("TCP Server: Message sent to Client by Server: "+input.toUpperCase());
                    dataOutStream.writeUTF(input.toUpperCase());
                    input ="";
                }catch(IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("TCP Server Terminated..");
 
        }catch(IOException i){
            System.out.println(i);
        }
    }
 
    public static void main(String args[]){
        TCPServer server = new TCPServer(5000);
    }
}