package jpower.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class NetUtils
{

    /**
     * Checks if the host is reachable by ping
     * @param host hostname
     * @return reachable
     */
    public static boolean ping(String host)
    {
        try
        {
            return InetAddress.getByName(host).isReachable(1000);
        }
        catch (IOException e)
        {
            return false;
        }
    }

    public static HttpURLConnection getConnection(String url) throws IOException
    {
        return (HttpURLConnection) new URL(url).openConnection();
    }

    public static void download(String url, File location) throws IOException
    {
        FileUtils.write(location, IOUtils.getBytes(getConnection(url).getInputStream()));
    }

    public static String localIPAddress()
    {
        return InetAddress.getLoopbackAddress().getHostAddress();
    }

}
