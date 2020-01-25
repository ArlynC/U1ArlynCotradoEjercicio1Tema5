package com.example.u1arlyncotradoejercicio1tema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener,GoogleMap.OnMapClickListener, GoogleMap.OnInfoWindowLongClickListener {
    GoogleMap mapa;
    Polygon polygon= null;
    List<LatLng> latLngList= new ArrayList<>();
    List<Marker> markerList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Obtenemos el mapa de forma asíncrona (notificará cuando esté listo)
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-18.013766, -70.255331), 14));

        mapa.addMarker(new MarkerOptions().position(new LatLng(-18.004905, -70.235160)).title("Marcador Tacna"));
            PolygonOptions polygonOptions = new PolygonOptions()
                    .add(new LatLng(-18.004806, -70.235560),
                            new LatLng(-18.005302, -70.235287),
                            new LatLng(-18.004966, -70.234752),
                            new LatLng(-18.004543, -70.235130));

            polygon = mapa.addPolygon(polygonOptions); //se añade al mapa
            polygon.setFillColor(Color.MAGENTA);



    }
    @Override
    public void onInfoWindowClick(Marker marker) {
       /* Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://developer.android.com/guide/components/intents-common?hl=es-419"));
        startActivity(intent);*/
    }
    @Override public void onMapClick(LatLng puntoPulsado) {

    }



    @Override
    public void onInfoWindowLongClick(Marker marker) {
        marker.remove();
    }

}

