/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burbuja;

/**
 *
 * @author Alfonso
 */
public class Burbuja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = new int [10];
        for(int i = 0; i<array.length; i++){
            array[i]= (int) (Math.random() * 9);
        }
        
        //ordenacionBurbuja(array);
        
        shellShort(array);
    }
    
    public static void ordenacionBurbuja( int [ ] numeros ){
        
        for (int l =0; l<numeros.length; l++){
            System.out.print(numeros[l]);
        }
        
        int aux;   //variable
        for (int j=1; j<numeros.length; j++){
            for(int i=0;  i < numeros.length -j;  i++ ){
                if ( numeros[ i ] > numeros[i+1] ) {
                    aux = numeros[ i ];                //intercambia los elementos
                    numeros[ i ] = numeros[ i+1 ];
                    numeros[ i+1 ] = aux; 
                } 
            } 
        }
        
        System.out.println("");
        
        for (int k =0; k<numeros.length; k++){
            System.out.print(numeros[k]);
        }
    } 
    
     public static void ordenacionShell(int[] v) {
         
         for (int l =0; l<v.length; l++){
            System.out.print(v[l]);
        }
         
        final int N = v.length;
        int incremento = N;
        do {
            incremento = incremento /  2;
            for (int k =  0; k < incremento; k++) { 
                for (int i = incremento + k; i < N; i += incremento) { 
                    int j = i;
                    while (j - incremento >=  0 && v[j] < v[j - incremento]) { 
                        int tmp = v[j];
                        v[j] = v[j - incremento];
                        v[j - incremento] = tmp;
                        j -= incremento;
                    }
                }
            }
        } while (incremento >  1 );
        
        System.out.println("");
        
        for (int k =0; k<v.length; k++){
            System.out.print(v[k]);
        }
     }
        
    private static void shellShort(int[] array){
         for (int l =0; l<array.length; l++){
            System.out.print(array[l]+"-");
        }
        
        int aux;
        boolean cambios;
        for(int i=array.length/2; i!=0; i/=2)
        {
           cambios=true;
           while(cambios)
           {
                cambios=false;
                for(int j=i; j< array.length; j++) 
                    if(array[j-i]>array[j])
                    { 
                        aux=array[j]; 
                        array[j]=array[j-i];
                        array[j-i]=aux;
                        cambios=true; 
                    }
            }
        }
        for(int i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
    }
    
    public void quickSort(int[] numeros, int izquierda, int derecha) {
         
        int i = izquierda;
        int j = derecha;
        // toma como pivote el primer elemento de la izquierda
        int pivot = numeros[izquierda];
 
        while (i <= j) {
                //en cada pasada del bucle se busca un número mayor que el pivote por la izquierda y un numero menor que 
                // el pivote por la derecha. Si los encuentra, los intercambia
            while (numeros[i] < pivot) {
                i++;
            }
            while (numeros[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int aux = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = aux;
                //actualiza los indices por la derecha y por la izquierda
                i++;
                j--;
            }
        }
        // llama a  quickSort() de forma recursiva con los dos subarrays que han quedado
        if (izquierda < j){
            quickSort(numeros,izquierda, j);
        }
        if (i < derecha){
            quickSort(numeros,i, derecha);
        }
    }
    
    public void insercionDirecta(int[] numeros) {
        for (int i = 2; i < numeros.length; i++) {
            int aux = numeros[i];
            int j=0; //declaro la j fuera del bucle for interior porque necesito utilizar su valor fuera del bucle interior
            for (j = i - 1; j >= 0 && numeros[j] > aux; j--) {  //desplaza los números del array en la parte ordenada, hasta que j vale -1
                                                                //o hasta que es menor que el comparado
                numeros[j + 1] = numeros[j];
            }
            numeros[j + 1] = aux;  //coloca el valor comparado en su posición correspondiente
        }
    }
    
}
