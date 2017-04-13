import java.io.*;
import java.net.*;
import java.util.Scanner;

public final class ChatClient
{
	public static void main (String[] args) throws IOException
	{
		String serverOutput = "";
		String clientInput = "";
		Scanner keyboard = new Scanner (System.in);
		try 
		{
			System.out.println("Waiting to connect to server...");
			Socket socket = new Socket ("codebank.xyz", 38001);
			System.out.println("Successfully connected!");
			PrintStream PS = new PrintStream(socket.getOutputStream()); // out from client to server
			PS.println("rivas1");
//			System.out.println("Test!");
			while (true)
			{
				InputStreamReader IR = new InputStreamReader(socket.getInputStream()); // listen to server
				BufferedReader BR = new BufferedReader(IR);

				serverOutput = BR.readLine();
				System.out.println("Server: " + serverOutput);
				PS.println(keyboard.nextLine());
			}
			
		}
		catch (IOException e)
		{ e.printStackTrace(); }
	}
}