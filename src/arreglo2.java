import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class arreglo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese la cantidad de estudiantes:");
        int cantidadEstudiantes = Integer.parseInt(br.readLine());
        String[] arregloCadenas = new String[cantidadEstudiantes];
        int[][] notasEstudiantes = new int[cantidadEstudiantes][4];

        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.print("Ingresa el nombre del estudiante: ");
            String value = br.readLine();
            GuardarValor(arregloCadenas, i, value);

            System.out.println("Debes ingresar las 4 notas del estudiante:");
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                int nota = Integer.parseInt(br.readLine());
                notasEstudiantes[i][j] = nota;
            }

            // Calcular
            double promedio = calcularPromedio(notasEstudiantes[i]);
            int notaMasAlta = calcularNotaMasAlta(notasEstudiantes[i]);
            int notaMasBaja = calcularNotaMasBaja(notasEstudiantes[i]);

            System.out.println("Estudiante: " + arregloCadenas[i]);
            System.out.println("Promedio: " + promedio);
            System.out.println("Nota más alta: " + notaMasAlta);
            System.out.println("Nota más baja: " + notaMasBaja);
            System.out.println();
        }

        // Imprimir nombres de estudiantes
        ImprimirObjetos(arregloCadenas);
    }

    private static void GuardarValor(String[] arreglo, int position, String value) {
        if (arreglo.length <= position) return;
        arreglo[position] = value;
    }

    private static void ImprimirObjetos(String[] arreglo) {
        for (String nombre : arreglo) {
            System.out.println(nombre);
        }
    }

    private static double calcularPromedio(int[] notas) {
        int suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return (double) suma / notas.length;
    }

    private static int calcularNotaMasAlta(int[] notas) {
        int max = notas[0];
        for (int nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    private static int calcularNotaMasBaja(int[] notas) {
        int min = notas[0];
        for (int nota : notas) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }
}