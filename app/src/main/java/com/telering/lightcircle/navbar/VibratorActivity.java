package com.telering.lightcircle.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.telering.lightcircle.R;
import com.telering.lightcircle.group.MainActivity;

public class VibratorActivity extends AppCompatActivity {

    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator);

        // ************************ Gestion des elements **********************************
        cancelButton = findViewById(R.id.cancel_button);

        // Click sur le bouton Retour
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VibratorActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // ************************ Gestion de la barre de navigation ***********************************
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // Apparence de la barre
        bottomNavBar.setSelectedItemId(R.id.navbar_vibrator); // Aucun Item selectionne

        // Navigation
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;

                switch(item.getItemId()) {
                    case R.id.navbar_lights:
                        intent = new Intent(VibratorActivity.this, LightsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_vibrator:
                        return true;
                    case R.id.navbar_flash_code:
                        intent = new Intent(VibratorActivity.this, FlashCodeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_infos:
                        intent = new Intent(VibratorActivity.this, InfosActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }
}