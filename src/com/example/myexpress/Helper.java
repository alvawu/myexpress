package com.example.myexpress;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class Helper {
	@SuppressWarnings("finally")
	public static String getUrlContent(String urlStr)
	{
		HttpURLConnection urlConnection = null;
		   try {
			   	URL url = new URL(urlStr);
			    urlConnection = (HttpURLConnection) url.openConnection();
			    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			    byte[] bytes = new byte[1024];  
	        	ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream(); 
	        	
	        	while (in.read(bytes) != -1) {  
	                arrayOutputStream.write(bytes, 0, bytes.length);  
	            }  
	        	in.close();  
	            arrayOutputStream.close();  
	            String content = new String(arrayOutputStream.toByteArray()); 
	            Log.d("Express", content);
			    return content;
		   }
		   catch( IOException e)
		   {
			   return "";
		   }
		   finally {
		     urlConnection.disconnect();
		     return "";
		   }
/*
		try
		{
			
			Log.d("Express", "1");
			URL yahoo = new URL(urlStr);
			Log.d("Express", "2");
			InputStreamReader inputstreamreader  =  new InputStreamReader(yahoo.openStream());
			Log.d("Express", "3");
			BufferedReader in = new BufferedReader( inputstreamreader );
			Log.d("Express", "4");
			String inputLine = "", tmp;

			while ((tmp = in.readLine()) != null)
				inputLine += tmp;

			in.close();
			return inputLine;
		}
		catch( IOException e)
		{
			return e.getMessage();
		}
		*/
	
	}
}
