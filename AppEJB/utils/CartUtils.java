package utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import models.PanierItem;

public class CartUtils {

public static Double getTotalPrice(List<PanierItem> panier){

	Double price = 0.0;
	for(PanierItem p : panier)
	{
		price += (p.getProduct().getPrice() * p.getQte());
	}
	return price;

}

public static void initSession(HttpSession session)
{
	if(session.getAttribute("cart") == null)
    {
    	List<PanierItem> panier = new ArrayList<PanierItem>();
    	session.setAttribute("cart", panier);
    }
}

public static int getItemNumber(List<PanierItem> panier)
{
	int nbr = 0;
	for(PanierItem p : panier)
	{
		nbr += p.getQte();
	}
	return nbr;
	}

}
