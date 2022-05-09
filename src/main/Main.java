package main;

import pokemon.Combate;
import pokemon.Entrenador;
import pokemon.Estado;
//import pokemon.Movimiento;
import pokemon.MovimientoAtaque;
//import pokemon.MovimientoMejora;
//import pokemon.MovimientoEstado;
import pokemon.Pokemon;
import pokemon.Tipo;

public class Main {

    public static void main(String[] args) {

        MovimientoAtaque placaje = new MovimientoAtaque(1, 50, false);

        Pokemon p1 = new Pokemon(01, "Malenia", 1000, 80, 20, 40, 10, 30, 10, 0, Estado.SIN_ESTADO, Tipo.DENDRO, placaje, null, null, null);
        Pokemon p2 = new Pokemon(02, "Radhan", 1000, 50, 30, 80, 40, 10, 10, 0, Estado.SIN_ESTADO, Tipo.ELECTRO, placaje, null, null, null);


        Entrenador gamer1 = new Entrenador("Poseidon", 0, p1, p1, p1);
        Entrenador gamer2 = new Entrenador("Joker", 0, p2, p2, p2);

        Combate eldenRingIntro = new Combate(0, gamer1, gamer2, 0, 0);
        eldenRingIntro.combatir(gamer1, gamer2);

    }

}