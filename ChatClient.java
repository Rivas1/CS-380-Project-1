import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public final class ChatClient
{
	public static void main (String[] args) throws IOException
	{
		try 
		{
			Socket socket = new Socket ("codebank.xyz", 38001);
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
		}
		catch (IOException e)
		{ e.printStackTrace(); }
	}
}