package android.niky.mahem_final.OffFinder;

import android.niky.mahem_final.R;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class map extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,LocationListener {

    GoogleMap mGoogleMap;
    GoogleApiClient mGoogleApiClient;
    MapFragment mapFragment;
    final int ID_THIS_ACTIVITY = 999;
    Marker marker;
    TextView Types;
    float types_color;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Types=findViewById(R.id.t_types);
        Types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PopupMenu popup = new PopupMenu(map.this,Types,10, R.attr.popupMenuStyle,R.style.popupmenuStyle);

                popup.getMenuInflater()
                        .inflate(R.menu.off_type, popup.getMenu());



                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.other:
                                types_color= BitmapDescriptorFactory.HUE_CYAN;
                                break;
                            case R.id.pen:
                                types_color= BitmapDescriptorFactory.HUE_AZURE;
                                break;
                            case R.id.cloth:
                                types_color= BitmapDescriptorFactory.HUE_BLUE;
                                break;
                            case R.id.trip:
                                types_color= BitmapDescriptorFactory.HUE_GREEN;
                                break;
                            case R.id.hotel:
                                types_color= BitmapDescriptorFactory.HUE_MAGENTA;
                                break;
                            case R.id.service:
                                types_color= BitmapDescriptorFactory.HUE_ORANGE;
                                break;
                            case R.id.teather:
                                types_color= BitmapDescriptorFactory.HUE_RED;
                                break;
                            case R.id.edu:
                                types_color= BitmapDescriptorFactory.HUE_ROSE;
                                break;
                            case R.id.kitchen:
                                types_color= BitmapDescriptorFactory.HUE_VIOLET;
                                break;
                            case R.id.jewerly:
                                types_color= BitmapDescriptorFactory.HUE_YELLOW;
                                break;
                            case R.id.car:
                                types_color= BitmapDescriptorFactory.HUE_ORANGE;
                                break;
                            case R.id.pretty:
                                types_color= BitmapDescriptorFactory.HUE_ROSE;
                                break;
                            case R.id.things:
                                types_color= BitmapDescriptorFactory.HUE_ORANGE;
                                break;
                            case R.id.sport:
                                types_color= BitmapDescriptorFactory.HUE_BLUE;
                                break;
                            case R.id.medicine:
                                types_color= BitmapDescriptorFactory.HUE_GREEN;
                                break;
                            case R.id.cafe:
                                types_color= BitmapDescriptorFactory.HUE_MAGENTA;
                                break;
                            case R.id.weekend:
                                types_color= BitmapDescriptorFactory.HUE_CYAN;
                                break;




                        }
                        show_places();
                        return true;
                    }
                });
                popup.show();
            }
        });


        if (googleserviceavailable()) {
            Toast.makeText(this, "perfect", Toast.LENGTH_SHORT).show();

            initMap();
        } else {
            //show no googlemap layout
        }
    }
    int m=-1;
    List<Integer> w=new ArrayList<>();
    private void show_places(){
        Geocoder geocoder = new Geocoder(map.this);
        location="white house";
        w.add(1);
        for (int i=0;w.get(i)!=-1;++i){

            List<Address> addressList = null;
            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(i);
            String locality = address.getLocality();
            Toast.makeText(map.this, locality, Toast.LENGTH_SHORT).show();

            double lat = address.getLatitude();
            double lng = address.getLongitude();
            gotoLocationZoom(lat, lng, 15);
            setMarker(locality, lat, lng);
            w.add(m);
        }
    }
    private void setMarker(String locality, double lat, double lng) {

        MarkerOptions options=new MarkerOptions()
                .title(locality)
                .icon(BitmapDescriptorFactory.defaultMarker(types_color))
                .position(new LatLng(lat,lng));
        marker=mGoogleMap.addMarker(options);
    }
    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo().isConnected();
    }
    private void initMap() {

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.MapFragment);
        mapFragment.getMapAsync(this);
    }
    private void gotoLocationZoom(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mGoogleMap.moveCamera(cameraUpdate);
    }


    public boolean googleserviceavailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isavailable = api.isGooglePlayServicesAvailable(this);

        if (isavailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isavailable)) {
            Dialog dialog = api.getErrorDialog(this, isavailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "can not connect to playservices", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap=googleMap;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                String[] FL_permission = {Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(FL_permission, ID_THIS_ACTIVITY);
            }
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                String[] CL_permission = {Manifest.permission.ACCESS_COARSE_LOCATION};
                requestPermissions(CL_permission, ID_THIS_ACTIVITY);
            }
        }
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
    }

    LocationRequest mLocationRequest;
    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = LocationRequest.create();

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                String[] FL_permission = {Manifest.permission.ACCESS_FINE_LOCATION};
                requestPermissions(FL_permission, ID_THIS_ACTIVITY);
            }
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                String[] CL_permission = {Manifest.permission.ACCESS_COARSE_LOCATION};
                requestPermissions(CL_permission, ID_THIS_ACTIVITY);
            }
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,  this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

        if(location==null){
            Toast.makeText(this, "can not find the location", Toast.LENGTH_SHORT).show();
        }else {
            LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
            CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latLng,15);

            ///change the location with animation moving
            mGoogleMap.animateCamera(cameraUpdate);
        }
    }
}
