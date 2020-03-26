package com.example.permisosmapas;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    static  final int PERMISSION_LOCATION_ID = 1;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); // Esto llama al metodo onMapReady
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng bogota = new LatLng(4.5981259, -74.0782322); //Esta en una ubicacion quemada
        mMap.addMarker(new MarkerOptions().position(bogota).title("Plaza de Bolivar"));// Esto es de los atributos de la misma
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bogota)); // esto dice que el mapa cuando apenas aparezca se ubique en la ubicacion quemada
        mMap.moveCamera(CameraUpdateFactory.zoomTo(10)); // es el nivel de zoom, cuando ya este bien dejelo en 15


        //--------------estos no se si estan bien aqui-------------------------------------------
        //si sirve lo del botones del zoom, el resto no se
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //----------------------------------------------------------------------------------------

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        //Pregunta si el servicio de la ubicacion esta aceptado
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //Si el permiso estaba aceptado pide la localizacion del usuario
            this.mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        //si existe la localizacion agrega un marcador nuevo
                        double longitud = location.getLongitude();
                        double latitud = location.getLatitude();
                        LatLng bogota = new LatLng(latitud,longitud);
                        mMap.addMarker(new MarkerOptions().position(bogota)
                                .title("Marcador pocision actual")
                                .snippet("aca se encuentra actualmente") //Texto de información
                                .alpha(0.5f));
                    }
                }
            });

        } else {
            //si el permiso no esta aceptado, lo pide!!!
            requestPermission(this, Manifest.permission.ACCESS_FINE_LOCATION, "Acceso a la localizacion necesario", PERMISSION_LOCATION_ID);
        }
    }

    private void requestPermission(Activity context, String permiso, String justificacion, int idCode) {

        //Aca pide el permiso

        if (ContextCompat.checkSelfPermission(context, permiso) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(context, permiso)) {
                Toast.makeText(context, justificacion, Toast.LENGTH_SHORT).show();
            }
            ActivityCompat.requestPermissions(context, new String[]{permiso}, idCode);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            //si acepta el permiso mira cual fue
            case PERMISSION_LOCATION_ID: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //hace lo mismo como si ya estuviera aceptado
                    this.mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location != null){
                                double longitud = location.getLongitude();
                                double latitud = location.getLatitude();
                                LatLng bogota = new LatLng(latitud,longitud);
                                mMap.addMarker(new MarkerOptions().position(bogota)
                                        .title("Marcador pocision actual")
                                        .snippet("aca se encuentra actualmente") //Texto de información
                                        .alpha(0.5f));

                            }
                        }
                    });
                }
            }
        }
    }
}
