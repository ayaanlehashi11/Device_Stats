package com.ayaanle.device_optimizer;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityDiagnosticsManager;
import android.net.IpConfiguration;
import android.net.MacAddress;
import android.net.Network;
import android.net.StaticIpConfiguration;
import android.net.wifi.WifiInfo;
import android.net.RouteInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSuggestion;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.net.LinkProperties;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;

import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
public class Internet {
    LinkProperties link_properties = link_properties = new LinkProperties();

    Network network;
    WifiInfo _wifi_info;
    int _tx_link_speed, _rx_link_speed;
    WifiManager wifi_manager;
    int ip;
    float frequency;
    WifiInfo wifi_info;
    String mac_address, host_address, bssid, ip_address , host_name;
    String sim_operator_name;
    String sim_number , sim_country , strphoneType;
    int sim_id;
    IpConfiguration ipConfiguration;
    IpConfiguration.Builder builder;
    SignalStrength signalStrength;
    WifiManager wifiManager;
    Context context;

    @SuppressLint("HardwareIds")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public WifiInfo wifi_info() {

        wifi_manager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi_manager.isWifiEnabled()) {
            _wifi_info = wifi_manager.getConnectionInfo();
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
    public synchronized static double network_diagnostics()
    {

    }
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    public int WifiSuggestionFunc() {
        WifiNetworkSuggestion.Builder builder = new WifiNetworkSuggestion.Builder();
        WifiNetworkSuggestion wifiNetworkSuggestion = builder.build();
        if (Build.VERSION.SDK_INT >= 33) {
            if(wifiNetworkSuggestion.isMetered() && wifiNetworkSuggestion.isRestricted() || wifiNetworkSuggestion.isUntrusted())
            {
                MacAddress wifi_mac_address = wifiNetworkSuggestion.getBssid();

            }
        }
        return 1;
        }

    public void dns_selection() {
        List<InetAddress> dns_addresses = link_properties.getDnsServers();
        for (int i = 0; i < dns_addresses.size(); ++i) {
            if (dns_addresses.get(i).isAnyLocalAddress() && dns_addresses.get(i).isMulticastAddress()) {
                dns_addresses.get(i).getHostAddress();
            }
        }
    }

    String Cell_Resol(TelephonyManager telephonyManager, CellInfo cellInfo) {
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (telephonyManager.isDataEnabled()) {
                    sim_country = telephonyManager.getSimCountryIso();
                    sim_operator_name = telephonyManager.getSimOperatorName();
                }
                else Toast.makeText(context.getApplicationContext() , "Data is not enabled" , Toast.LENGTH_SHORT).show();
            }
        else
        {
            Toast.makeText(context.getApplicationContext() , "Telephony Permission isn't enabled" , Toast.LENGTH_SHORT).show();
        }
        int phoneType=telephonyManager.getPhoneType();

        switch (phoneType)
        {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                strphoneType="CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                strphoneType="GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                strphoneType="NONE";
                break;
        }
        return "Null";
    }
    @RequiresApi(api = 33)
    @Nullable
    public void static_ipconfig(String ip_address)
    {
        builder = new IpConfiguration.Builder();
        ipConfiguration = builder.build();
        StaticIpConfiguration static_ip_config = ipConfiguration.getStaticIpConfiguration();
        static_ip_config.
    }
    /**
     *
     * @param _route_info
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.R)
    public String[] dhcp_dns_config(InetAddress dhcp_addresses)
    {
        link_properties = new LinkProperties();
        dhcp_addresses = link_properties.getDhcpServerAddress();
        List<InetAddress>dns_addresses = link_properties.getDnsServers();
        for(int i = 0;i < dns_addresses.size();++i)
        {
            host_name = dns_addresses.get(i).getHostName();
            host_address = dns_addresses.get(i).getHostAddress();
        }
        return new String[]{host_address , host_name};
    }
    public WifiInfo wifi_info()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if(wifi_info.getCurrentSecurityType() == WifiInfo.SECURITY_TYPE_WEP &&
                    wifi_info.getCurrentSecurityType() != WifiInfo.SECURITY_TYPE_OPEN) {

            }
        }
    }
}

