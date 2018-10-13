package com.edu.aj.oub;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static com.edu.aj.oub.MapsActivity.TAG;

class MyLocationListener implements com.google.android.gms.location.LocationListener {

    @Override
    public void onLocationChanged(Location loc) {

        Toast.makeText(getBaseContext(),"Location changed : Lat: " +
                        loc.getLatitude()+ " Lng: " + loc.getLongitude(),
                Toast.LENGTH_SHORT).show();
        String longitude = "Longitude: " +loc.getLongitude();
        Log.v(TAG, longitude);
        String latitude = "Latitude: " +loc.getLatitude();
        Log.v(TAG, latitude);

        /*----------to get City-Name from coordinates ------------- */
        String cityName=null;
        Geocoder gcd = new Geocoder(getBaseContext(),
                Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(), loc
                    .getLongitude(), 1);
            if (addresses.size() > 0)
                System.out.println(addresses.get(0).getLocality());
            cityName=addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Context getBaseContext() {
        return null;
    }

    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub         
    }

    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub         
    }

    public void onStatusChanged(String provider,
                                 int status, Bundle extras) {
        // TODO Auto-generated method stub         
    }
}
