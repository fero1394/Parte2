import java.util.*;

public class Main {
    public ArrayList<Integer> ordenamientoArrayListNumber(ArrayList<Integer> listNumber){

        for(int i = listNumber.size(); i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if(listNumber.get(j) > listNumber.get(j+1)){
                    int temp = listNumber.get(j);
                    listNumber.set(j,listNumber.get(j+1));
                    listNumber.set(j+1,temp);
                }
            }
        }

        return listNumber;
    }

    public void isPrimo(int number){

        int count = 0;
        for(int i = 1; i <= number; i++){
            if(number%i == 0){
                count++;
            }
        }

        if(count != 2){
            System.out.println("El numero: "+ number + " No es Primo");
        }else{
            System.out.println("El numero: "+ number +" Es Primo");
        }
    }



    public static void main(String[] args) {


        ArrayList<Integer> listNumber = new ArrayList();
        int numeroIngresado;
        int esprimo;

        //Preguntamos datos para ordenar
        System.out.println("Ingresa 5 numeros enteros: ");
        Scanner input = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.print((i+1) + "= ");
            numeroIngresado = input.nextInt();
            listNumber.add(numeroIngresado);
        }

        //Preguntamos por el numero a analizar si es primo o no
        System.out.print("Ingresa un numero entero para comparar si es primo" + " :");
        esprimo = input.nextInt();

        Main main = new Main();

        System.out.println("-------------METODO ORDENAMIENTO DE ARRAYLIST-------------");
        System.out.println("lista desordenada");
        for(int i = 0; i < listNumber.size(); i++){
            System.out.print(listNumber.get(i) + " ");
        }

        main.ordenamientoArrayListNumber(listNumber);

        System.out.println("\nlista ordenada");
        for(int i = 0; i < listNumber.size(); i++){

            System.out.print(listNumber.get(i) + " ");
        }


        System.out.println("\n-------------METODO PARA COMPROBAR SI ES PRIMO-------------");

        main.isPrimo(esprimo);

        //Preguntamos por los datos para el Pojo
        String nombre = "";
        String apellido = "";
        int edad = 0;

        System.out.print("Ingresa tu Nombre: ");
        nombre = input.next();
        System.out.print("Ingresa tu Apellido: ");
        apellido = input.next();
        System.out.print("Ingresa tu Edad: ");
        edad = input.nextInt();

        System.out.println("-------------EJEMPLO POJO-------------");

        PojoPersona persona = new PojoPersona(nombre,apellido,edad);
        System.out.println(persona.toString());


        System.out.println("-------------EJEMPLO DE SEMAFORO-------------");

        Timer timer = new Timer();

        TimerTask taskStartStop = new TimerTask() {
            boolean cambioEstado = false;
            @Override
            public void run() {

                try{
                    cambioEstado = !cambioEstado;
                    System.out.println("AMARILLO");
                    Thread.sleep(2000);
                    if(cambioEstado){
                        System.out.println("VERDE");
                    }
                    else {
                        System.out.println("ROJO");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        };

        timer.schedule(taskStartStop,1,6000);

    }
}
