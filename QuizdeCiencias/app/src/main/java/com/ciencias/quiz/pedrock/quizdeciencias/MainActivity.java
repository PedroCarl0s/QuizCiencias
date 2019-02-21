package com.ciencias.quiz.pedrock.quizdeciencias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView abrirQuimica = (ImageView) findViewById(R.id.btnQuimica);
        abrirQuimica.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent itQuimica = new Intent(MainActivity.this, TelaQuestoes.class);

                // Passar título para a Activity de perguntas
                itQuimica.putExtra("titulo", "Química");

                startActivity(itQuimica);
            }

        });


        ImageView abrirFisica = (ImageView) findViewById(R.id.btnFisica);
        abrirFisica.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent itFisica = new Intent(MainActivity.this, TelaQuestoes.class);

                // Passar título para a Activity de perguntas
                itFisica.putExtra("titulo", "Física");

                startActivity(itFisica);
            }
        });


        ImageView abrirBiologia = (ImageView) findViewById(R.id.btnBiologia);
        abrirBiologia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent itBiologia = new Intent(MainActivity.this, TelaQuestoes.class);

                // Passar título para a Activity de perguntas
                itBiologia.putExtra("titulo", "Biologia");

                startActivity(itBiologia);
            }

        });
    }

}
