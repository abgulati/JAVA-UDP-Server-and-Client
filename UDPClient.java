/*Author: Abheek Gulati
For: NJIT class CS 656
*/

import java.io.*;
import java.net.*;

class UDPClient {

	public static void main(String args[]) throws Exception {

		System.out.println("Emter the string you'd like to capitalize: ");
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		InetAddress IPAddress = InetAddress.getByName("localhost");

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8998);
		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);

		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("From server: " + modifiedSentence);

		clientSocket.close();

	}
}
