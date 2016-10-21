/*
* ShoppingCartWrapper.java
*
*/ 
package examples;

import javax.servlet.http.HttpServletRequest;

/**
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email deepak@roseindia.net
*/
public class ShoppingCartWrapper{

	protected ShoppingCart cart=null;
	

    public void processRequest(HttpServletRequest request) {
		
		try{
			System.out.println("In process request of ShoppingCartWrapper");
			System.out.println(request.getParameter("submit"));
			String item=request.getParameter("item");
			if(item==null){
				item="No Selection";
			}

			if(request.getParameter("submit")==null){

			}else if(request.getParameter("submit").equals("ADD")){
				getCart().addItem(item);
			}else if(request.getParameter("submit").equals("REMOVE")){
				getCart().removeItem(item);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
    }

	public String[] getItems() {
        try {
			return getCart().getItems();
            } catch (Exception ex) { }
		return null;
	}

	protected ShoppingCart getCart(){
        if (this.cart==null) {

            try {

                javax.naming.Context ctx = new javax.naming.InitialContext();

                Object obj = ctx.lookup("ShoppingCart");

                ShoppingCartHome cartHome =

                    (ShoppingCartHome)javax.rmi.PortableRemoteObject.narrow(obj, ShoppingCartHome.class);

                this.cart = cartHome.create();

            } catch (Exception ex) { }

        }

        return this.cart;
	}




};