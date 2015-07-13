package com.example.tests;







import static org.testng.Assert.assertEquals;
//import org.testng.asserts.*;



import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	


		
	
  @Test(dataProvider ="randomValidGroupgenerator")
  public void testGroupCreationValidData(GroupData group) throws Exception {
	//app.navigateTo().mainPage();
	//app.navigateTo().groupsPage();
  
	GroupHelper groupHelper = app.getGroupHelper();
	SortedListOf<GroupData> oldList = groupHelper.getGroups();
	

   // GroupData group = new GroupData();
    group.name = "sdf";
    group.header = "header1 1";
    group.footer = "footer 1";
	app.getGroupHelper().createGroup(group);
	
	
	SortedListOf<GroupData> newList = groupHelper.getGroups();
    
  //  assertEquals(newList.size(), oldList.size()+1);
    oldList.add(group);
   
    assertEquals(newList, oldList);
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigateTo().mainPage();
	app.navigateTo().groupsPage();
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	GroupData group = new GroupData();
	group.name = "";
	group.header = "";
	group.footer = "";
   
	app.getGroupHelper().initGroupCreation(); 
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //  assertEquals(newList.size(), oldList.size()+1);
      oldList.add(group);
      
      assertEquals(newList, oldList);
  }


}
