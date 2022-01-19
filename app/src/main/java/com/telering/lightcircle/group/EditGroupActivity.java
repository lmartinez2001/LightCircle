package com.telering.lightcircle.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.telering.lightcircle.R;

/**
 * Affiche la fenetre d'edition du groupe.
 * Il y a possibilite d'ajouter/supprimer un contact, modifier le nom du groupe, supprimer le groupe
 *
 * Si le groupe est supprime, on est redirige vers {@link MainActivity}
 *
 * Le bouton pour valider la modification n'est actif que si le groupe a effectivement ete modifie.
 * Si on clique dessus, il redirige vers {@link MainActivity}
 */
public class EditGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);
    }
}