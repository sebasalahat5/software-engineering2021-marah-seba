package org.Library;
import java.util.ArrayList;
import java.util.Scanner;
public class Library
{
	public ArrayList<Book> myLibrary = new ArrayList <Book>();
	public ArrayList<Book> toPrint = new ArrayList <Book>();
   
	public String [] inputString ;
	public String username;
	public boolean isbnExist = false;
	public boolean found = false;
	public Library()
	{
	}
	public void Input_fun(String input)
	{
		String myInput;
		Scanner input1=new Scanner(System.in); 
		myInput = input1.nextLine();
		inputString = myInput.split(" ");
		if(inputString[0].equalsIgnoreCase("search"))
		{
			String [] searchSt;
			searchSt = inputString[1].split("-");
			if(searchSt[0].equalsIgnoreCase("title"))
				SearchTitle(searchSt[1]);
			else if(searchSt[0].equalsIgnoreCase("author"))
				SearchAuthor(searchSt[1]);
			else if(searchSt[0].equalsIgnoreCase("isbn"))
				SearchISBN(searchSt[1]);
			else
				System.out.println("Please Enter the write statment");		
		}
	}
	public Book SearchTitle(String searchFor)
	{
		toPrint.clear();
		Book result = new Book();
		
		for(int i=0; i<myLibrary.size(); i++)
		{
			if(myLibrary.get(i).getTitle().contains(searchFor))
			{
				result = new Book();
				result.setTitle(myLibrary.get(i).getTitle());
				result.setAuthor(myLibrary.get(i).getAuthor());
				result.setIsbn(myLibrary.get(i).getIsbn());
				result.setSignature(myLibrary.get(i).getSignature());
				toPrint.add(result);
				found = true;
			}
		}
		if(!found)
		{
			result.setTitle("Not Found");
			System.out.println("Result of searching about title: "+searchFor+" Not Found");
		}
		else
		{
			System.out.print("Result of searching about title    "+searchFor+": ");
			printOutput();
		}
		return result;
	}
	public Book SearchAuthor(String searchFor)
	{
		toPrint.clear();	
		Book result= new Book();
		for(int i=0; i<myLibrary.size(); i++)
		{
			if(myLibrary.get(i).getAuthor().contains(searchFor))
			{
				result = new Book();
				result.setTitle(myLibrary.get(i).getTitle());
				result.setAuthor(myLibrary.get(i).getAuthor());
				result.setIsbn(myLibrary.get(i).getIsbn());
				result.setSignature(myLibrary.get(i).getSignature());
				toPrint.add(result);	
				found = true;				
			}
		}	
		if(!found)
		{
			result.setTitle("Not Found");
			System.out.println("Result of searching about author:  "+searchFor+" Not Found");
		}
		else
		{
			System.out.print("Result of searching about author    "+searchFor+":  ");
			printOutput();
		}
		return result;
	}
	public Book SearchISBN(String searchFor)
	{
		toPrint.clear();
		Book result = new Book();
		for(int i=0; i<myLibrary.size(); i++)
		{
			if(myLibrary.get(i).getIsbn().contains(searchFor))
			{
				result = new Book();
				result.setTitle(myLibrary.get(i).getTitle());
				result.setAuthor(myLibrary.get(i).getAuthor());
				result.setIsbn(myLibrary.get(i).getIsbn());
				result.setSignature(myLibrary.get(i).getSignature());
				toPrint.add(result);
				found = true;
			}
		}
		if(!found)
		{
			result.setTitle("Not Found");
			System.out.println("Result of searching about ISBN:   "+searchFor+" Not Found");
		}
		else
		{
			System.out.print("Result of searching about ISBN   "+searchFor+":  ");
			printOutput();
		}
		return result;
	}
	public void printOutput()
	{
		if(toPrint.isEmpty())
			System.out.println("Not Found");
		else
		{
			for(int p=1; p<= toPrint.size(); p++)
			{
				System.out.println("Title:  "+toPrint.get(p-1).getTitle()+"  Author:  "+toPrint.get(p-1).getAuthor()+
						"  ISBN:  "+toPrint.get(p-1).getIsbn()+"  Signtaure:  "+toPrint.get(p-1).getSignature());			
			}
		}
	}
}