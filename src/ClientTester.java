import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class TcpClient extends Thread{
	    private Socket socket            = null;
	    private BufferedReader  bufferedReader   = null;
	    private DataOutputStream dataOutStream     = null;
		private DataInputStream dataInputStream       =  null;
	 
	public void run(){
		 TcpClient client = new TcpClient();
		 client.execute("192.168.75.1", 8005);
	}
	
	public void execute(String address, int port){
		
		 try {
	            socket = new Socket(address, port);
	            System.out.println("Connected");
	            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
	            bufferedReader  =  new BufferedReader(new InputStreamReader(System.in));
	            dataOutStream    = new DataOutputStream(socket.getOutputStream());
	        }catch(UnknownHostException u){
	            System.out.println(u);
	        }
	        catch(IOException i){
	            System.out.println(i);
	        }
	 
	        String input = "";
	 
	        while (!input.equals("Over")){
	            try{
	            	input = bufferedReader.readLine();
	                dataOutStream.writeUTF(input);
	                input = dataInputStream.readUTF();
	                System.out.println("TCP Server Output:  "+input);
	                input = "";
	            }
	            catch(IOException i)
	            {
	                System.out.println(i);
	            }
	        }
	}
	
}
class UdpClient extends Thread{

	public void run(){
		//try {
			//tc.join();
		//} catch (InterruptedException e1) {
			//e1.printStackTrace();
		//}
		UdpClient client = new UdpClient();
		try {
			client.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() throws IOException{
		Scanner scanner = new Scanner(System.in);
		 
        DatagramSocket datagramSoc = new DatagramSocket();
        DatagramSocket ds1 = new DatagramSocket(21235);
        InetAddress ipAddress = InetAddress.getLocalHost();
        byte buf[] = null;
        byte[] receiveLine = new byte[65535];
        DatagramPacket DpReceive = null;
 
        while (true)
        {
            String inp = scanner.nextLine();
 
            buf = inp.getBytes();
 
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ipAddress, 21235);
 
            datagramSoc.send(DpSend);

            DpReceive = new DatagramPacket(receiveLine, receiveLine.length);
 
            ds1.receive(DpReceive);
 
            System.out.println("UDP Server output :-" + data(receiveLine));
 
            if (inp.equals("bye"))
                break;
            receiveLine = new byte[65535];
        }
        
	}
	
	public static StringBuilder data(byte[] bytes)
    {
        if (bytes == null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (bytes[i] != 0)
        {
        	stringBuilder.append((char) bytes[i]);
            i++;
        }
        return stringBuilder;
    }
	
}


public class ClientTester {

	public static void main(String[] args) throws InterruptedException {
		TcpClient tcpClient = new TcpClient();
		//UdpClient udpClient = new UdpClient();
		//udpClient.start();
		tcpClient.start();
		
	}

}
