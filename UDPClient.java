import java.io.*;
import java.net.*;

class UDPClient {
	public static void main(String args[]) throws Exception {
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader(System.in));
		
		DatagramSocket clientSocket = new DatagramSocket();
		System.out.println("Client Socket:" + clientSocket);
		
		InetAddress IPAddress = InetAddress.getByName("localhost");
		System.out.println("LOCALHOST:" + IPAddress);
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		
		int port = sendPacket.getPort();
		System.out.println("PORT on send Pkt:" + port);
		
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		
		clientSocket.close();
	}
}
