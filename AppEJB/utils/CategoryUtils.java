package utils;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class CategoryUtils {
	
	public static List<Pair<Integer,String>> catList;
	
	public static List<Pair<Integer,String>> getCatList()
	{
		catList = new ArrayList<Pair<Integer,String>>();
		catList.add(new Pair<Integer, String>(1, "Action"));
		catList.add(new Pair<Integer, String>(2, "Contrat"));
		catList.add(new Pair<Integer, String>(3, "Publication"));
		return catList;
	}

}
