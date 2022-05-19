package main;

import java.util.Random;

import combate.Combate;
import combate.Estado;
import combate.Tipo;
import combate.Turno;
import movimientos.MovAtaqueFisico;
import movimientos.MovimientoAtaque;
import pokemon.Entrenador;
//import pokemon.MovimientoMejora;
//import pokemon.MovimientoEstado;
import pokemon.Pokemon;

public class Main {

    public static void main(String[] args) {

        MovAtaqueFisico mv_01 = new MovAtaqueFisico(Tipo.PYRO, "Placaje", 1, 50);

        Pokemon p1 = new Pokemon(01, "Pikachu", Tipo.ELECTRO, mv_01, null, null, null);
        Pokemon p2 = new Pokemon(01, "Squirtle", Tipo.HYDRO, mv_01, null, null, null);

        Entrenador gamer1 = new Entrenador("Poseidon", 9999, p1, p1, p1, p2);
        Entrenador gamer2 = new Entrenador("Joker", 0, p2, p2, p2, p2);

        // Combate eldenRingIntro = new Combate(gamer1, gamer2, 0, 0);

        // eldenRingIntro.combatir(gamer1, gamer2);
        // eldenRingIntro.escribirCombate();
        // gamer1.capturar();

    }

}