package com.ayaanle.device_optimizer;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Network;
import android.net.RouteInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.os.Build;
import android.net.LinkProperties;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import java.net.InetAddress;
import java.util.List;


public class Internet {
    LinkProperties link_properties = link_properties = new LinkProperties();

    Network network;
    WifiInfo _wifi_info;
    int _tx_link_speed, _rx_link_speed;
    WifiManager wifi_manager;
    int ip;
    float frequency;
    String mac_address, bssid, ip_address;
    @SuppressLint("HardwareIds")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public WifiInfo wifi_info(Context context) {

        wifi_manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi_manager.isWifiEnabled()) {
            _wifi_info = wifi_manager.getConnectionInfo()
            ip = _wifi_info.getIpAddress();
            frequency = _wifi_info.getFrequency();
            if (ActivityCompat.checkSelfPermission(context.getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                mac_address = _wifi_info.getMacAddress();
            }
            _tx_link_speed = _wifi_info.getTxLinkSpeedMbps();
            _rx_link_speed = _wifi_info.getRxLinkSpeedMbps();
            bssid = _wifi_info.getBSSID();
        }

    }
    public int WifiSuggestionFunc()
    {
        WifiNetworkSuggestion wifi_suggestion = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if(wifi_suggestion.isMetered())
            {

            }
        }
    }
    public void dns_selection()
    {
        List<InetAddress> dns_addresses = link_properties.getDnsServers();
        for(int i = 0; i < dns_addresses.size();++i)
        {
            if(dns_addresses.get(i).isAnyLocalAddress() && dns_addresses.get(i).isMulticastAddress())
            {
                dns_addresses.get(i).getHostAddress();
            }
        }
    }
    public void static_ipconfig()
    {

    }

    /**
     *
     * @param _route_info
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public InetAddress getDhcpServerAddress(RouteInfo _route_info)
    {
        List<InetAddress> dhcp_Address = link_properties.getDhcpServerAddress()
    }
}

