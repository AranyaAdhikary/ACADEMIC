import java.net.*;

class JavaInetAddress
{
    public static void main(String args[])
    {
        try
        {
            InetAddress i = InetAddress.getLocalHost();
            String str = i.getHostAddress();
            System.out.println("I.P. Address : "+str);
        }
        catch(Exception e)
        {
            System.out.println("Exception : "+e);
        }
    }
}