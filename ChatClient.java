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
			Socket socket = new Socket ("codebank.xyz", 38001);
			PrintStream PS = new PrintStream(socket.getOutputStream()); // out from client to server
			System.out.print("Please enter a username: ");
			PS.println(keyboard.nextLine()); // prompt user for username
			
			InputStreamReader IR = new InputStreamReader(socket.getInputStream()); // listen to server
			BufferedReader BR = new BufferedReader(IR);

			while (true)
			{
				serverOutput = BR.readLine();
				System.out.println("Server: " + serverOutput);
				if (serverOutput.equals("Name in use."))
					System.exit(1);
				PS.println(keyboard.nextLine()); // sends user typed message to server
			}

		}
		catch (IOException e)
		{ e.printStackTrace(); }
	}
}