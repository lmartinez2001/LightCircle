package com.telering.lightcircle.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.madrapps.pikolo.HSLColorPicker;
import com.telering.lightcircle.R;
import com.telering.lightcircle.group.MainActivity;

public class LightsActivity extends AppCompatActivity {

    private Button cancelButton;
    private ImageButton toggleLightsButton;
    private HSLColorPicker colorPicker;

    private boolean lightOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        // Etat des LEDS du bracelet,
        // TODO Actualiser l'état de la variable quand le bracelet est connecté au téléphone
        lightOn = false ;

        // ************************ Gestion des elements **********************************
        cancelButton = findViewById(R.id.cancel_button);
        toggleLightsButton = findViewById(R.id.lights_button);
        colorPicker = findViewById(R.id.lights_colorpicker);


        // Click sur le bouton d'allumage des lumières
        toggleLightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleLights();
                if(lightOn == true) {
                    toggleLightsButton.setColorFilter(ContextCompat.getColor(LightsActivity.this, R.color.design_default_color_primary));
                } else {
                    toggleLightsButton.setColorFilter(ContextCompat.getColor(LightsActivity.this, R.color.material_on_surface_disabled));
                }

            }
        });



        // Click sur le bouton Retour
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LightsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // ************************ Gestion de la barre de navigation ***********************************
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // Apparence de la barre
        bottomNavBar.setSelectedItemId(R.id.navbar_lights); // Aucun Item selectionne

        // Navigation
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;

                switch(item.getItemId()) {
                    case R.id.navbar_lights:
                        return true;
                    case R.id.navbar_vibrator:
                        intent = new Intent(LightsActivity.this, VibratorActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_flash_code:
                        intent = new Intent(LightsActivity.this, FlashCodeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_infos:
                        intent = new Intent(LightsActivity.this, InfosActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void toggleLights() {
        lightOn = !lightOn;
    }
}