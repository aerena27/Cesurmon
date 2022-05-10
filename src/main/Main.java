package main;

import combate.Combate;
import combate.Estado;
import combate.Tipo;
import movimientos.MovimientoAtaque;
import pokemon.Entrenador;
//import pokemon.MovimientoMejora;
//import pokemon.MovimientoEstado;
import pokemon.Pokemon;

public class Main {

    public static void main(String[] args) {

        MovimientoAtaque mv_01 = new MovimientoAtaque("Placaje", 1, 50, false);

        Pokemon p1 = new Pokemon(01, "Malenia", 1000, 80, 20, 40, 10, 30, 10, 0, Estado.SIN_ESTADO, Tipo.DENDRO, mv_01, null, null, null);
        Pokemon p2 = new Pokemon(02, "Radhan", 1000, 50, 30, 80, 40, 10, 10, 0, Estado.SIN_ESTADO, Tipo.ELECTRO, mv_01, null, null, null);


        Entrenador gamer1 = new Entrenador("Poseidon", 0, p1, p1, p1);
        Entrenador gamer2 = new Entrenador("Joker", 0, p2, p2, p2);

        Combate eldenRingIntro = new Combate(0, gamer1, gamer2, 0, 0);
        eldenRingIntro.combatir(gamer1, gamer2);

    }

}