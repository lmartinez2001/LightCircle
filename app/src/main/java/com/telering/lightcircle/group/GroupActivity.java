package com.telering.lightcircle.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.telering.lightcircle.R;

/**
 * Permet d'afficher les details d'un groupe quand on a clique dessus dans la liste des groupes
 * - affichage de la liste des membres du groupe (stockee dans le telephone)
 * - bouton pour passer en mode edition afin d'ajouter/supprimer des contacts, renommer ou supprimer le groupe.
 * Le bouton ouvre {@link EditGroupActivity}
 */
public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
    }
}