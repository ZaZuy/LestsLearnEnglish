package AppLetsLearnEnglish.Entity;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@Configuration
public class GetIPAddressConfig {
	@Bean
	public String GetIPAddress() {
		String addresIPV4 =null;
		try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();

                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress instanceof java.net.Inet4Address) {
                        System.out.println("IPv4 Address: " + inetAddress.getHostAddress());
                        addresIPV4 = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return  "http://"+addresIPV4+":8081";
	}

}
