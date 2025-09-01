import java.util.Random;
import java.util.Scanner;
public class App {

    public static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                if (tablero[i][i1] == 5) {
                    System.out.print("-" + " ");
                } else {
                    if (tablero[i][i1] == 0) {
                        System.out.print("O" + " ");
                    } else {
                        if (tablero[i][i1] == 1) {
                            System.out.print("X" + " ");
                        } else {
                            System.out.print(tablero[i][i1] + " ");
                        }
                    }
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= 7; i++) {
            char columna = (char) ('A' + i - 1);
            System.out.print(columna + " ");
        }
        System.out.println();
    }
public static int hayCuatroEnRaya(int[][] tablero) {
    for (int fi = 0 ; fi < 6 ; fi++) {
        for (int co = 0 ; co < 4 ; co++){
            if (tablero[fi][co] + tablero[fi][co+1] + tablero[fi][co+2] + tablero[fi][co+3] == 4) {
                if (tablero[fi][co] != 5 && tablero[fi][co+1] != 5 && tablero[fi][co+2] != 5 && tablero[fi][co+3] != 5){
                    return 1;
                }
            }
            if (tablero[fi][co] + tablero[fi][co+1] + tablero[fi][co+2] + tablero[fi][co+3] == 0){
                if (tablero[fi][co] != 5 && tablero[fi][co+1] != 5 && tablero[fi][co+2] != 5 && tablero[fi][co+3] != 5){
                    return 0; 
                }
            }
        }
    }
    for (int co = 0 ; co < 6 ; co++) {
        for (int fi = 0 ; fi < 3 ; fi++){
            if (tablero[fi][co] + tablero[fi+1][co] + tablero[fi+2][co] + tablero[fi+3][co] == 4) {
                if (tablero[fi][co] != 5 && tablero[fi+1][co] != 5 && tablero[fi+2][co] != 5 && tablero[fi+3][co] != 5){
                    return 1;
                }
            }
            if (tablero[fi][co] + tablero[fi+1][co] + tablero[fi+2][co] + tablero[fi+3][co] == 0) {
                if (tablero[fi][co] != 5 && tablero[fi+1][co] != 5 && tablero[fi+2][co] != 5 && tablero[fi+3][co] != 5){
                    return 0;
                }
            }
        }
    }
for (int fi = 0; fi < 3; fi++) {
    for (int co = 0; co < 4; co++) { 
        int suma = tablero[fi][co] + tablero[fi+1][co+1] + tablero[fi+2][co+2] + tablero[fi+3][co+3];
        if (suma == 4) {
            if (tablero[fi][co] != 5 && tablero[fi+1][co+1] != 5 && tablero[fi+2][co+2] != 5 && tablero[fi+3][co+3] != 5) {
                return 1;
            }
        }
        if (suma == 0) {
            if (tablero[fi][co] != 5 && tablero[fi+1][co+1] != 5 && tablero[fi+2][co+2] != 5 && tablero[fi+3][co+3] != 5) {
                return 0;
            }
        }
    }
}

for (int fi = 3; fi < 6; fi++) {   
    for (int co = 0; co < 4; co++) {     
        int suma = tablero[fi][co] + tablero[fi-1][co+1] + tablero[fi-2][co+2] + tablero[fi-3][co+3];
        if (suma == 4) {
            if (tablero[fi][co] != 5 && tablero[fi-1][co+1] != 5 && tablero[fi-2][co+2] != 5 && tablero[fi-3][co+3] != 5) {
                return 1;
            }
        }
        if (suma == 0) {
            if (tablero[fi][co] != 5 && tablero[fi-1][co+1] != 5 && tablero[fi-2][co+2] != 5 && tablero[fi-3][co+3] != 5) {
                return 0;
            }
        }
    }
}
    return -1;
}
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String jugador1;
        String jugador2;
        System.out.println("Ingresa el nombre de un jugador");
        String name1 = scanner.nextLine();
        System.out.println("Ingresa el nombre del otro jugador");
        String name2 = scanner.nextLine();
        int dado = random.nextInt(6) + 1;
        if (dado%2 == 0){
            jugador1 = name1;
            jugador2 = name2;
        }
        else {
            jugador2 = name1;
            jugador1 = name2;
        }
        int[][] tablero = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                tablero[i][i1] = 5;
            }
        }
        int turno = 0;
        Scanner teclado = new Scanner(System.in);
            while (hayCuatroEnRaya(tablero) == -1) {
            String jugadaColumna;
            System.out.println(jugador1 + " juega con o");
            System.out.println(jugador2 + " juega con x");
            if (turno % 2 == 0) {
                mostrarTablero(tablero);
                System.out.println(jugador1 + " ingresa tu jugada");
                System.out.println("Columna (A-G)");
                jugadaColumna = teclado.nextLine();
                int i1 = switch (jugadaColumna) {
                    case "A" -> 0;
                    case "B" -> 1;
                    case "C" -> 2;
                    case "D" -> 3;
                    case "E" -> 4;
                    case "F" -> 5;
                    case "G" -> 6;
                    default -> throw new IllegalArgumentException("Columna inválida: " + jugadaColumna);
                };
                int i = -1;
                for (int k = 5; k >= 0; k--) {
                    if (tablero[k][i1] == 5) {
                        i = k;
                        break;
                    }
                }
                if (i != -1) {
                    tablero[i][i1] = 0;
                    hayCuatroEnRaya(tablero);
                } else {
                    System.out.println("Columna llena, elige otra.");
                }
            } else {
                System.out.println(jugador2 + " ingresa la columna de tu jugada");
                mostrarTablero(tablero);
                System.out.println("Columna (A-G)");
                jugadaColumna = teclado.nextLine();
                int i1 = switch (jugadaColumna) {
                    case "A" -> 0;
                    case "B" -> 1;
                    case "C" -> 2;
                    case "D" -> 3;
                    case "E" -> 4;
                    case "F" -> 5;
                    case "G" -> 6;
                    default -> throw new IllegalArgumentException("Columna inválida: " + jugadaColumna);
                };
                int i = -1;
                for (int k = 5; k >= 0; k--) {
                    if (tablero[k][i1] == 5) {
                        i = k;
                        break;
                    }
                }
                if (i != -1) {
                    tablero[i][i1] = 1;
                    hayCuatroEnRaya(tablero);
                } else {
                    System.out.println("Columna llena, elige otra.");
                }
            }
            turno++;
        }
        if (hayCuatroEnRaya(tablero) == 1){
            System.out.println("Ha ganado " + jugador2);
        }
        else{
            System.out.println("Ha ganado " + jugador1);
        }
        mostrarTablero(tablero);
        teclado.close();
        scanner.close();
    }
}