package com.telering.lightcircle.group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.telering.lightcircle.R;
import com.telering.lightcircle.Utils;

/**
 * Affiche la liste des groupes deja crees au lancement de l'application ou propose d'en creer un dans la cas
 * ou aucun n'as encore ete enregistre.
 *
 * Le bouton de creation de groupe lance {@link NewGroupActivity} NewGroupActivity
 *
 * Chaque item de la liste est cliquable et lance {@link GroupActivity} pour connaitre les details du groupe.
 *
 * Le bouton pour passer en "mode soiree" permet de selectionner un groupe. Au moment ou le groupe est selectionne,
 * l'app lance {@link com.telering.lightcircle.NightModeActivity}
 */
public class MainActivity extends AppCompatActivity {

    private ImageButton addGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addGroupButton = findViewById(R.id.main_add_group_button);
        boolean test = false;

        // Modification dynamique des proprietes du bouton.
       /* RelativeLayout.LayoutParams buttonsParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // Alignement horizontal
        buttonsParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        // Marge
        buttonsParam.topMargin = 1000;
        // Taille en dp
        buttonsParam.width = Utils.dpToPx(15, this);
        buttonsParam.height = Utils.dpToPx(15, this);
        // Ajout des prametres au bouton
        addGroupButton.setLayoutParams(buttonsParam);*/



        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewGroupActivity.class);
                startActivity(intent);
            }
        });
    }


}