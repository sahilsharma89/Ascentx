

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

interface Calculate{
  void cal(String s1);
}

class A  {

void hexCalculate(String s1){

Calculate c=(String s)->{
StringBuilder builder = new StringBuilder();
          
for (char ch: s1.toCharArray()) {
			if(ch!=' ')
                     { 
 builder.append(ch); }
		}
String s2=builder.toString();
if(s2=="")
{
   System.out.println("no hex");
return ;
}
int i=Integer.parseInt(s2);
String hexString = Integer.toHexString(i);
 
System.out.println(s1+"="+hexString);

try{

File file = new File("append.txt");
FileWriter fr = new FileWriter(file, true);
BufferedWriter br = new BufferedWriter(fr);
br.write(s1+"="+hexString);
br.newLine();
br.close();
fr.close();

}
catch (Exception e)
{
System.out.println(e);
}



};

c.cal(s1);

}
}

class B extends A implements Runnable {

	String s;
	B(String s1){
		s=s1;
	}
	
	@Override
	public void run(){
		hexCalculate(s);
	}

}


public class Prob1{

	public static void main(String[] args) throws IOException  {
		
		File file= new File("C:\\Users\\sahil.sharma2\\workspace\\temp\\src\\temp\\prob1.txt");
		System.out.println(file);
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			  
		 
		 ExecutorService pool = Executors.newFixedThreadPool(5);
		  
		 String st; 
		  while ((st = br.readLine()) != null) {
		    Runnable r=new B(st);
		    pool.execute(r);
			  
		  }
		 
		
		br.close();
pool.shutdown();
				 	}
	

}





