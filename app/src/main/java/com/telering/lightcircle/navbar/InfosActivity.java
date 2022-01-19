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

public class InfosActivity extends AppCompatActivity {

    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        // ************************ Gestion des elements **********************************
        cancelButton = findViewById(R.id.cancel_button);

        // Click sur le bouton Retour
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfosActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // ************************ Gestion de la barre de navigation ***********************************
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // Apparence de la barre
        bottomNavBar.setSelectedItemId(R.id.navbar_infos); // Aucun Item selectionne

        // Navigation
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;

                switch(item.getItemId()) {
                    case R.id.navbar_lights:
                        intent = new Intent(InfosActivity.this, LightsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_vibrator:
                        intent = new Intent(InfosActivity.this, VibratorActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_flash_code:
                        intent = new Intent(InfosActivity.this, FlashCodeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_infos:
                        return true;
                }
                return false;
            }
        });
    }
}