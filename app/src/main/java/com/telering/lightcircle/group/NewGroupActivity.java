package com.telering.lightcircle.group;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.telering.lightcircle.R;

/**
 * Affiche le formulaire de creation d'un groupe :
 * - nom du groupe
 * - affichage de la liste des contacts de l'utilisateur. On peut selectionner plusieurs contacts.
 * - Ajout d'un contact via son numero de telephone (comme lydia).
 * Lors de l'ajout d'un contact par numero de telephone, il faut aussi specifier le nom de la personne.
 * Poposer d'ajouter le numero aux contacts de l'utilisateur.
 *
 * La creation du groupe est impossible tant qu'aucun contact n'a ete ajoute.
 *
 * Le bouton pour valider la creation du groupe redirige vers {@link MainActivity}
 * Le bouton pour annuler la creation du groupe redirige vers {@link MainActivity}
 */
public class NewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
    }
}