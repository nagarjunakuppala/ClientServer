import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
public class UDPServer
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket datagramSocet = new DatagramSocket(1236);
        byte[] receive = new byte[65535];
        InetAddress ipAddress = InetAddress.getLocalHost();
        DatagramPacket DpReceive = null;
        byte buf[] = null;
        while (true)
        {
            DpReceive = new DatagramPacket(receive, receive.length);
            datagramSocet.receive(DpReceive);
            System.out.println("UDP Server: The Message sent by Client:-" + data(receive));
 
		String sen = data(receive).toString();
		StringBuilder ss = new StringBuilder();
		ss.append(sen);
		ss = ss.reverse();
		sen = ss.toString();
		buf = sen.getBytes();
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length,ipAddress,1235);
 
            System.out.println("UDP Server: The Message sent tp Client by Server :-" + sen);
            datagramSocet.send(DpSend);
 
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("UDP Server Terminated..");
                break;
            }
 
            receive = new byte[65535];
        }
        datagramSocet.close();
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