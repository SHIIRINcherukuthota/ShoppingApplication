package BasicsMaven;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;


public class apistart {
	public String json="";

	public String hashtoJSON(HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number) {
		
	
		String json=new Gson().toJson(hashmap_with_keyas_bill_number);
	      return json;
		
		}

		
		
	    public static void main (String[] args) throws Exception {
	        //Start server
	        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
	        server.createContext("/getusers", (HttpHandler) new hhtpRequestParser());
	        server.createContext("/getaddresses", new hhtpRequestParser());
	        server.createContext("/getbillnumber", new hhtpRequestParser());
	        server.setExecutor(java.util.concurrent.Executors.newCachedThreadPool()); //Uses New Thread every time
	        server.start();
	        System.out.println("Server Started at 8000...");
	    }
	}
	    

	    class hhtpRequestParser implements HttpHandler {
	    	public boolean offsetCheck = true;
	    	public String apicountControl="";
	    	HashMap<String, String> apidetails = new HashMap<String, String>();
	        public void handle(HttpExchange reqandresoponse) throws IOException {
	        	 offsetCheck = true;
		    	  
	            URI uri = reqandresoponse.getRequestURI();
	            String path = uri.getPath();
	            System.out.println(path);
	            Map query_param = queryToMap(uri.getQuery());
	            JSONObject body = null;
	            String postData=reqandresoponse.getRequestMethod();
	            try {
	            if(postData.equals("POST")) {
	            
	            InputStreamReader isr = new InputStreamReader(reqandresoponse.getRequestBody(), StandardCharsets.UTF_8);
	            BufferedReader br = new BufferedReader(isr);
	            int b;
	            StringBuilder buf = new StringBuilder(512);
	            while ((b = br.read()) != -1) {
	                buf.append((char) b);
	            }
	            br.close();
	            isr.close();
	            
	            try {
	            	String buferofbody=buf.toString();
	                body = new JSONObject(buferofbody);
	                System.out.println(body);
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }   
	            }
	            }catch(Exception e) {
	            	System.out.println(e);
	            }
	            
	            
	            if (path.equals("/getusers")) {
	                //your Logic
	                //Use any other Library - I use GSON
	            String xml = "<user1>shirin</user1><user2>balu</user2>";
	                String json = "{\"user1\":\"shirin\",\"user2\":\"balu\"}";
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	               
	                if(query_param.get("type").equals("xml")) {
	                	reqandresoponse.getResponseHeaders().set("Content-Type", "application/xml");
	                	reqandresoponse.sendResponseHeaders(200, xml.length());
	                OutputStream os = reqandresoponse.getResponseBody();
	                os.write(xml.getBytes());
	                os.close();
	                }
	               
	                if(query_param.get("type").equals("json")) {
	                    reqandresoponse.getResponseHeaders().set("Content-Type", "application/json");
	                    reqandresoponse.sendResponseHeaders(200, json.length());
	                    OutputStream os = reqandresoponse.getResponseBody();
	                    os.write(json.getBytes());
	                    os.close();
	                    }
	               
	            }
	            if (path.equals("/getaddresses")) {
	                //Your Logic
	                //Use any other Library - I use GSON
	                Gson gson = new Gson();
	                String json = "{\"address1\":\"123 asdasd\",\"address2\":\"balalsdasd 123\"}";
	                //System.out.println(json);
	                reqandresoponse.getResponseHeaders().set("Content-Type", "application/json");
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	                reqandresoponse.sendResponseHeaders(200, json.length());
	                OutputStream os = reqandresoponse.getResponseBody();
	                os.write(json.getBytes());
	                os.close();
	            }
	            
	            
	            if (path.equals("/getbillnumber")&& reqandresoponse.getRequestMethod().equals("POST")) {
	                //Your Logic
	                //Use any other Library - I use GSON
	            	
	            	//HTTP Post
	                Gson gson = new Gson();
	                
	                HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number;
                   String quryParamString = reqandresoponse.getRequestURI().getQuery();
                   
                   
	               String sql_query= body.getString("query"); //reqandresoponse.getRequestBody().toString();
	               
	               
                   Map<String, String> quryParamsasMap = queryToMap(quryParamString);       
	                db_controllerForApi obj1=  new db_controllerForApi();	                
	               // String dbQuery= obj1.DBstring(sql_query);  
	                apidatarequestcount(sql_query);
	                hashmap_with_keyas_bill_number=obj1.APIDB_read_controller(sql_query);	                
	                String json = hashtoJSON(hashmap_with_keyas_bill_number);//get from database
	                
	               
	                reqandresoponse.getResponseHeaders().set("Content-Type", "application/json");
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
	                reqandresoponse.getResponseHeaders().set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	               if (offsetCheck==true) {
	                reqandresoponse.sendResponseHeaders(200, json.length());
	                OutputStream os = reqandresoponse.getResponseBody();
	                os.write(json.getBytes());
	                os.close();
	               }else {
	            	   
	            	   json=new Gson().toJson(apidetails);
	            	   reqandresoponse.sendResponseHeaders(200, json.length());
		                OutputStream os = reqandresoponse.getResponseBody();
		                os.write(json.getBytes());
		                os.close();
	               }
	                
	            }
	            
	        }
	        public Map<String, String> queryToMap(String query) {
	            Map<String, String> result = new HashMap();
	           
	            try {
	            	 String[] invidul_element = query.split("&");
	            for (String param : invidul_element) {
	                String[] entry = param.split("=",3);
	                if (entry.length > 1) {
	                    result.put(entry[0], entry[1]);
	                }else{
	                    result.put(entry[0], "");
	                }
	            }
	            System.out.println(result);
	            return result;
	            
	        }
	            catch (Exception e) {
	            	System.out.println(e);
	            }
				return result;
	        }
	        
	        
	        public String hashtoJSON(HashMap<Integer, ArrayList<customerModel>> hashmap_with_keyas_bill_number) {
	        	ArrayList<customerModel> eachValueForTheKey = new ArrayList<customerModel>();
	        	
	        	for (Integer bill : hashmap_with_keyas_bill_number.keySet()) {
	        		eachValueForTheKey = hashmap_with_keyas_bill_number.get(bill);
	        		
	        		
	        		for (int i = 0; i < eachValueForTheKey.size(); i++)   {
	        			String json = new Gson().toJson(eachValueForTheKey);
	        			
	        		}
	        	}
	        	
	              return new Gson().toJson(hashmap_with_keyas_bill_number);
	        	
	        	}
	        
	        public void apidatarequestcount(String sql_query) {
	        	
	        	String[] arrOfStr = sql_query.split("limit ");
	        	
	        	String beforelimit=arrOfStr[0];
	        	String afterlimit=arrOfStr[1];
	        	
	        	String comma[]=afterlimit.split(",");
	        	String limitwith=comma[1];
	        	
	        	String[] semicolumn= limitwith.split(";");
	        	
	        	String actual_limit=semicolumn[0];
	        	
	        	System.out.println(actual_limit);
//	        	String[] strings = afterlimit.split(",");
//	        	String offsetQuery= strings[0];
//	        	String llimitQuery=strings[1];
	        	int number=0;
	        	try {
	        	 number=Integer.parseInt(actual_limit);
	        	System.out.println(number);
	        	}catch (Exception e) {
	        		System.out.println(e);
	        	}
	        	if (number<10) {
	        		
	        	
	        		
	        	}
	        	else
	        	{
	        		offsetCheck=false;
	        		
	        		
apidetails.put("Error", "values limit exeeded");
apidetails.put("errorcode", "600");
apidetails.put("status", "false");
	        		
	        		
	        	}

	        	
	        	
	        }
	        
	    }
	 


	


