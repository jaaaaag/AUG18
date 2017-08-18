package com.oocl.ita.gervajo.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:\\testfile.txt");
		BufferedReader br = new BufferedReader(fr);
		List<String> list = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		List<Integer> num2 = new ArrayList<Integer>();
		List<String> num3 = new ArrayList<String>();

		for (int i = 0; i < 12; i++) {
			list.add(br.readLine());
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).matches("[-+]?\\d*\\.?\\d*")) {
				int j = Integer.parseInt(list.get(i));
				num2.add(j);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {	
			if (!list.get(i).matches("[-+]?\\d*\\.?\\d*")) {
				words.add(list.get(i));
			}
		}
		
		Collections.sort(words);
		Collections.sort(num2);
		
		for(int i : num2) {
			num3.add(String.valueOf(i));
		}
		
		List<String> newList = new ArrayList<String>(words);
		newList.addAll(num3);
		
		Files.write(Paths.get("D:\\testfile1.txt"), newList, StandardOpenOption.CREATE);


	}

}
