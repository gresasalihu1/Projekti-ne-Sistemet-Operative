package projekti; 

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(2000);
		Socket sk = ss.accept();
		BufferedReader cin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout = new PrintStream(sk.getOutputStream());
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			s = cin.readLine();
			System.out.print("Client : " +s+ "\n");
			System.out.print("Server : ");
			s = sc.nextLine();
			if (s.equalsIgnoreCase("bye"))
			{
				cout.println("BYE");
				System.out.println("Connection ended by server");
				break;
			}
			cout.println(s);
		}
		ss.close();
		sk.close();
		sc.close();
		cin.close();
		cout.close();
		stdin.close();
	}
}
