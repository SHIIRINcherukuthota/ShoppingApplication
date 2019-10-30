package BasicsMaven;

import java.lang.reflect.Method;

public class method_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Method[] methods = customerModel.class.getMethods();
			for (Method m :methods) {
			// System.out.println(m.getName());
				if (m.getName()=="getItem_id"){
				//	System.out.println(m.getName()+" *** ");
					customerModel demo=new customerModel();
				int item_id=123;
		     		demo.setItem_id(item_id);
					//System.out.println(demo.m);
					 System.out.println(m.invoke(demo));
				}
				  }
	}catch (Exception e){
		System.out.println(e);
	}
	}

}



