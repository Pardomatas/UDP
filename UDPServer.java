import java.net.*;

class UDPServer {
	public static void main(String args[]) throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		System.out.println("serverSocket:" + serverSocket);
		
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			String sentence = new String(receivePacket.getData());
			
			InetAddress IPAddress = receivePacket.getAddress();
			System.out.println("IPAddress:" + IPAddress);
			
			int port = receivePacket.getPort();
			System.out.println("PORT:" + port);
			
			int num = Integer.parseInt(sentence.trim());
			String doublednum = Integer.toString(num * 2);
			
			
			sendData = doublednum.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
	}

}
