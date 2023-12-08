package br.com.udf.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String JOGADOR_PERDEU = "Jogador perdeu!";
    public static final String JOGADOR_VENCEU = "Jogador venceu!";
    public static final String EMPATE = "Empate!";
    String[] opcoes = {"Pedra", "Papel", "Tesoura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        opcaoSelecionadaJogador(opcoes[0]);
    }

    public void selecionadoPapel(View view) {
        opcaoSelecionadaJogador(opcoes[1]);
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionadaJogador(opcoes[2]);
    }

    public void opcaoSelecionadaJogador(String textoOpcaoSelecionadaJogador) {

        int numeroAleatorio = new Random().nextInt(opcoes.length);
        TextView veredito = findViewById(R.id.textView_instrucao_jogador);

        String textoOpcaoSelecionadaApp = opcoes[numeroAleatorio];
        ImageView imageOpcaoSelecionadaApp = findViewById(R.id.imageView_opcao_robo);

        if (
                Objects.equals(textoOpcaoSelecionadaApp, opcoes[0]) && Objects.equals(textoOpcaoSelecionadaJogador, opcoes[2]) ||
                Objects.equals(textoOpcaoSelecionadaApp, opcoes[1]) && Objects.equals(textoOpcaoSelecionadaJogador, opcoes[0]) ||
                Objects.equals(textoOpcaoSelecionadaApp, opcoes[2]) && Objects.equals(textoOpcaoSelecionadaJogador, opcoes[1])
        ) {
            veredito.setText(JOGADOR_PERDEU);
        } else if (
                Objects.equals(textoOpcaoSelecionadaJogador, opcoes[0]) && Objects.equals(textoOpcaoSelecionadaApp, opcoes[2]) ||
                Objects.equals(textoOpcaoSelecionadaJogador, opcoes[1]) && Objects.equals(textoOpcaoSelecionadaApp, opcoes[0]) ||
                Objects.equals(textoOpcaoSelecionadaJogador, opcoes[2]) && Objects.equals(textoOpcaoSelecionadaApp, opcoes[1])
        ) {
            veredito.setText(JOGADOR_VENCEU);
        } else {
            veredito.setText(EMPATE);
        }

        switch (textoOpcaoSelecionadaApp) {
            case "Pedra":
                imageOpcaoSelecionadaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageOpcaoSelecionadaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageOpcaoSelecionadaApp.setImageResource(R.drawable.tesoura);
                break;
        }

    }

}