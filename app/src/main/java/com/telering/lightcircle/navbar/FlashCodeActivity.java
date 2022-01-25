package com.telering.lightcircle.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.Result;
import com.telering.lightcircle.R;
import com.telering.lightcircle.group.MainActivity;

public class FlashCodeActivity extends AppCompatActivity {

    private Button cancelButton;
    private CodeScannerView scannerView;


    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_code);


        // ************************ Gestion des elements **********************************
        cancelButton = findViewById(R.id.cancel_button);

        // Code récupéré du github du créateur de l'API
        // https://github.com/yuriy-budiyev/code-scanner
        scannerView = findViewById(R.id.flash_code_scanner);

        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(FlashCodeActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

        // Click sur le bouton Retour
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlashCodeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // ************************ Gestion de la barre de navigation ***********************************
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // Apparence de la barre
        bottomNavBar.setSelectedItemId(R.id.navbar_flash_code); // Aucun Item selectionne

        // Navigation
        bottomNavBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;

                switch(item.getItemId()) {
                    case R.id.navbar_lights:
                        intent = new Intent(FlashCodeActivity.this, LightsActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_vibrator:
                        intent = new Intent(FlashCodeActivity.this, VibratorActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navbar_flash_code:
                        return true;
                    case R.id.navbar_infos:
                        intent = new Intent(FlashCodeActivity.this, InfosActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCodeScanner.releaseResources();
    }

    // TODO gestion de la connexion entre le téléphone, le bracelet et le serveur de la soirée
    private void initConnections() {

    }
}