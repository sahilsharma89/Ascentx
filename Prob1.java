import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.*;

class A {
void hexCalculate(String s1){

if(s1=="")
{
   System.out.println("no hex");
return ;
}
List<Character> chars = new ArrayList<>();
StringBuilder builder = new StringBuilder(chars.size());
          
for (char ch: s1.toCharArray()) {
			if(ch!=' ')
                     { 
 builder.append(ch); }
		}
String s2=builder.toString();
int i=Integer.parseInt(s2);
String hexString = Integer.toHexString(i);
 
System.out.println(s1+"="+hexString);

}}

class T1 extends A implements Runnable{
 
 String s1;
  T1(String s)
  { s1=s;}
 //@override
   public void run(){
   hexCalculate(s1);
   
}

}




public class Prob1 {
 public static void main(String[] args) throws FileNotFoundException {
 File file=new File("C:\\Users\\sahil.sharma2\\desktop\\prob1.txt"); 
Scanner fileScanner=new Scanner(file); 
 ArrayList<String> arrList=new ArrayList<String>();
A test=new A();
int i=0;
while(i<25) {
String s1=fileScanner.nextLine();
String s2=fileScanner.nextLine();
String s3=fileScanner.nextLine();
String s4=fileScanner.nextLine();
String s5=fileScanner.nextLine();

Thread thread1=new Thread(new T1(s1));
thread1.start();
Thread thread2=new Thread(new T1(s2));
thread2.start();
Thread thread3=new Thread(new T1(s3));
thread3.start();
Thread thread4=new Thread(new T1(s4));
thread4.start();
Thread thread5=new Thread(new T1(s5));
thread5.start();
i=i+5;
 } 
System.out.println("hello");
fileScanner.close(); 
}

 }