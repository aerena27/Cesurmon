package movimientos;

import combate.Estado;
import combate.Tipo;
import pokemon.Pokemon;

public abstract class Movimiento {

    protected Tipo tipo;
    protected String nombreHabilidad;
    protected int resistencia; // Cantidad de estamina que quita al usarse

    Movimiento(Tipo tipo, String nombreHabilidad, int resistencia) {
        this.nombreHabilidad = nombreHabilidad;
        this.resistencia = resistencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Comprobar resistencia del atacante para saber si se puede ejecutar el
     * movimiento
     * 
     * @param atacante
     * @return Boolean de si tiene suficiente estamina
     */
    public Boolean checkResistencia(Pokemon atacante) {
        if (atacante.getResistencia() >= getResistencia()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Consumir la resistencia del Pokémon al ejecutar el ataque
     * 
     * @param atacante
     */
    public void consumirResistencia(Pokemon atacante) {
        atacante.setResistencia(atacante.getResistencia() - getResistencia());
    }

    /**
     * Devolver el tipo de efectividad comprobando el tipo del movimiento y tipo del
     * Pokémon defensor
     * 
     * @param defensor
     * @return
     */
    public String checkVentaja(Pokemon defensor) {
        float potenciador = logicaTipos(defensor);
        if (potenciador == 1.0) {
            return "NEUTRO";
        } else if (potenciador > 1.0) {
            return "VENTAJA";
        } else {
            return "DESVENTAJA";
        }
    }

    /**
     * Método usado en el cálculo final de daño ejecutado para corregir la vitalidad
     * del Pokémon defensor en caso de ser negativa
     * 
     * @param vitalidadFinal Puntos de salud del defensor tras el ataque
     * @param defensor       Pokémon que recibe el ataque
     */
    public void corregirVitalidadNegativa(int vitalidadFinal, Pokemon defensor) {
        if (vitalidadFinal <= 0) {
            defensor.setPuntosSaludCombate(0);
        } else {
            defensor.setPuntosSaludCombate(vitalidadFinal);
        }
    }

    /**
     * Devolver si un Pokémon puede atacar en un turno, por si el contrincante ha
     * empezado antes y lo ha debilitado en el mismo turno
     * 
     * @param atacante Pokémon que ejecute el movimiento
     * @return
     */
    public Boolean puedeAtacar(Pokemon atacante) {
        if (atacante.getPuntosSaludCombate() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método principal que será heredado y sobrescrito por el resto de hijos, según
     * el tipo de movimiento. Hará un set del Pokémon defensor tras todos los
     * cálculos correspondientes teniendo en cuenta todas las variables.
     * 
     * @param atacante Pokémon que ejecuta el movimiento
     * @param defensor Pokémon que recibe el movimiento
     */
    public void usarMovimiento(Pokemon atacante, Pokemon defensor) {

    }

    /**
     * Convertir Enum de tipos a número para ser usado en lógicaTipos
     * 
     * @param elemento Tipo
     * @return Tipo en int
     */
    public int convertirTipo(Tipo elemento) {

        if (elemento == Tipo.NORMAL)
            return 0;

        if (elemento == Tipo.DENDRO)
            return 1;

        if (elemento == Tipo.PYRO)
            return 2;

        if (elemento == Tipo.CRYO)
            return 3;

        if (elemento == Tipo.HYDRO)
            return 4;

        if (elemento == Tipo.ANEMO)
            return 5;

        if (elemento == Tipo.ELECTRO)
            return 6;

        if (elemento == Tipo.SECTO)
            return 7;

        if (elemento == Tipo.GEO)
            return 8;

        return -1;
    }

    /**
     * Devolver un float con el potenciador o reductor de daño teniendo en cuenta el
     * tipo del movimiento y el tipo del Pokémon defensor, para ser usado en la
     * fórmula final de ataque.
     * 
     * @param defensor Pokémon que recibe el ataque
     * @return Potenciador o reductor de daño por tipo
     */
    public float logicaTipos(Pokemon defensor) {

        int a = convertirTipo(this.tipo);
        int d = convertirTipo(defensor.getTipo1());

        /*
         * NORMAL=0
         * DENDRO=1
         * PYRO=2
         * CRYO=3
         * HYDRO=4
         * ANEMO=5
         * ELECTRO=6
         * SECTO=7
         * GEO=8
         */

        float efectividad[][] = new float[9][9];

        // NORMAL
        efectividad[0][0] = 1f; // NORMAL
        efectividad[0][1] = 1f; // DENDRO
        efectividad[0][2] = 1f; // PYRO
        efectividad[0][3] = 1f; // CRYO
        efectividad[0][4] = 1f; // HYDRO
        efectividad[0][5] = 1f; // ANEMO
        efectividad[0][6] = 1f; // ELECTRO
        efectividad[0][7] = 1f; // SECTO
        efectividad[0][8] = 1f; // GEO

        // DENDRO
        efectividad[1][0] = 1f; // NORMAL
        efectividad[1][1] = 0.5f; // DENDRO
        efectividad[1][2] = 0.5f; // PYRO
        efectividad[1][3] = 1f; // CRYO
        efectividad[1][4] = 1.5f; // HYDRO
        efectividad[1][5] = 0.5f; // ANEMO
        efectividad[1][6] = 1.0f; // ELECTRO
        efectividad[1][7] = 0.5f; // SECTO
        efectividad[1][8] = 2f; // GEO

        // PYRO
        efectividad[2][0] = 1f; // NORMAL
        efectividad[2][1] = 2f; // DENDRO
        efectividad[2][2] = 0.5f; // PYRO
        efectividad[2][3] = 2f; // CRYO
        efectividad[2][4] = 0.5f; // HYDRO
        efectividad[2][5] = 1f; // ANEMO
        efectividad[2][6] = 1f; // ELECTRO
        efectividad[2][7] = 2f; // SECTO
        efectividad[2][8] = 1f; // GEO

        // CRYO
        efectividad[3][0] = 1f; // NORMAL
        efectividad[3][1] = 2f; // DENDRO
        efectividad[3][2] = 0.5f; // PYRO
        efectividad[3][3] = 0.5f; // CRYO
        efectividad[3][4] = 1.5f; // HYDRO
        efectividad[3][5] = 2f; // ANEMO
        efectividad[3][6] = 1.5f; // ELECTRO
        efectividad[3][7] = 2f; // SECTO
        efectividad[3][8] = 1.5f; // GEO

        // HYDRO
        efectividad[4][0] = 1f; // NORMAL
        efectividad[4][1] = 0.5f; // DENDRO
        efectividad[4][2] = 2f; // PYRO
        efectividad[4][3] = 1f; // CRYO
        efectividad[4][4] = 0.5f; // HYDRO
        efectividad[4][5] = 1f; // ANEMO
        efectividad[4][6] = 1f; // ELECTRO
        efectividad[4][7] = 1f; // SECTO
        efectividad[4][8] = 2f; // GEO

        // ANEMO
        efectividad[5][0] = 1f; // NORMAL
        efectividad[5][1] = 2f; // DENDRO
        efectividad[5][2] = 1f; // PYRO
        efectividad[5][3] = 1f; // CRYO
        efectividad[5][4] = 1f; // HYDRO
        efectividad[5][5] = 1f; // ANEMO
        efectividad[5][6] = 1f; // ELECTRO
        efectividad[5][7] = 0.5f; // SECTO
        efectividad[5][8] = 1f; // GEO

        // ELECTRO
        efectividad[6][0] = 1f; // NORMAL
        efectividad[6][1] = 0.5f; // DENDRO
        efectividad[6][2] = 1f; // PYRO
        efectividad[6][3] = 1f; // CRYO
        efectividad[6][4] = 2f; // HYDRO
        efectividad[6][5] = 2f; // ANEMO
        efectividad[6][6] = 0.5f; // ELECTRO
        efectividad[6][7] = 1f; // SECTO
        efectividad[6][8] = 1f; // GEO

        // SECTO
        efectividad[7][0] = 1f; // NORMAL
        efectividad[7][1] = 2f; // DENDRO
        efectividad[7][2] = 2f; // PYRO
        efectividad[7][3] = 2f; // CRYO
        efectividad[7][4] = 1.5f; // HYDRO
        efectividad[7][5] = 2f; // ANEMO
        efectividad[7][6] = 0.5f; // ELECTRO
        efectividad[7][7] = 0.5f; // SECTO
        efectividad[7][8] = 1f; // GEO

        // GEO
        efectividad[8][0] = 2f; // NORMAL
        efectividad[8][1] = 2f; // DENDRO
        efectividad[8][2] = 1f; // PYRO
        efectividad[8][3] = 2f; // CRYO
        efectividad[8][4] = 0.5f; // HYDRO
        efectividad[8][5] = 1f; // ANEMO
        efectividad[8][6] = 1f; // ELECTRO
        efectividad[8][7] = 1f; // SECTO
        efectividad[8][8] = 0.5f; // GEO

        return efectividad[a][d];
    }

}
