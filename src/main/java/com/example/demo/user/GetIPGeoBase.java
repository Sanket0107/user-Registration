package com.example.demo.user;

import org.springframework.stereotype.Component;

import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;
@Component
public class GetIPGeoBase {
	IPGeolocationAPI api = new IPGeolocationAPI("608e770708864df3b59b7b90e05dd981");
	
	public String getCountryNameByIP(String IP) {
		String Country="";
		
		// Get geolocation for IP address (1.1.1.1) and fields (geo, time_zone and currency)
		GeolocationParams geoParams = new GeolocationParams();
		geoParams.setIPAddress(IP);
		geoParams.setFields("geo");

		Geolocation geolocation = api.getGeolocation(geoParams);

		// Check if geolocation lookup was successful
		if(geolocation.getStatus() == 200) {
		    System.out.println(geolocation.getCountryName());
		     Country= geolocation.getCountryName();
		  
		} else {
		    System.out.printf("Status Code: %d, Message: %s\n", geolocation.getStatus(), geolocation.getMessage());
		}
		return Country;
	}


}
