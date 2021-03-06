package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator {


	public static void main(String[] args) throws IOException {
		if (args.length <3){
			System.out.println("parametr 3 need");
			return;
		}
	int amount = Integer.parseInt(args[0]);
	File file= new File(args[1]);
	String format = args[2];
	
	if (file.exists()) {
		
		System.out.println("file exist,please remove it manually"+ file );
		return;
	}
	
	List<GroupData>groups = generateRandomGroups(amount);
	if ("csv".equals(format)){
		saveGroupsToCsvFile(groups, file);
	}else if ("xml".equals(format))

	{
		saveGroupsToXmlFile(groups, file);
	} else {
		System.out.println("unknown format"+ format);
		return;
	}
	
	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) {
		
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		
			
				FileWriter writer = new FileWriter(file);
		for (GroupData group:groups){
		writer.write(group.getName()+"," + group.getHeader()+"," +group.getFooter()+"\n");
		}	
			writer.close();
	}

	public  static List<GroupData> generateRandomGroups(int amount) {
List<GroupData> list = new ArrayList<GroupData>();
		
		for (int i=0;i<amount; i++){
		
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			
			
				
			list.add( group);
		}
		
		return list;
		
		
	}
	public static String generateRandomString(){
	Random rnd = new Random();
	
	
	if (rnd.nextInt(3)==0){
		return "";
	} else {
		return "test"+rnd.nextInt();
	}
	}



}
