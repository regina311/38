package com.example.tests;

import static org.testng.Assert.assertEquals;



import java.util.Random;

import org.testng.annotations.Test;


import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
 @Test
public void deleteSomeGroup() {
	
	
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	Random rnd = new Random();
	int index= rnd.nextInt(oldList.size()-1);
	app.getGroupHelper().deleteGroup(index);
	

	 SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	
	 oldList.remove(index);
    
     assertEquals(newList, oldList);
 
 }
 
}
