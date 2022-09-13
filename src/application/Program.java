package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file full path: ");
			String path = sc.nextLine();
			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				Map <String, Integer>map = new HashMap<>();
				String line = br.readLine();
				while (line != null) {
					String [] fields = line.split(",");
					int votes = Integer.parseInt(fields[1]);
					if(map.containsKey(fields[0])==true) {
							votes = votes + map.get(fields[0]);
					}
					
					map.put(fields[0], votes);
					line = br.readLine();
					}
					Set <String> set = map.keySet();
					
					for (String a:set) {
						System.out.println(a + ": " + map.get(a));
					}
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	

}


