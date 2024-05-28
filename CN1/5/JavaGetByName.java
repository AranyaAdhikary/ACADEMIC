import java.net.*;

class JavaGetByName
{
    public static void main(String args[]) throws UnknownHostException
    {
        String s = "www.youtube.com";
        try
        {
            InetAddress i = InetAddress.getByName(s);
            String str = i.getHostAddress();
            System.out.println("I.P. Address : "+str);
        }
        catch(Exception UnknownHostException)
        {
            System.out.println("Invalid URL");
        }
    }
}