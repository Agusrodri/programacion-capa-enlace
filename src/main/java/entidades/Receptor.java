package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receptor {

    private char[] bufferReceptor;
    char[] arregloParidadReceptor= new char[9];

    public void recibir(char[] info){

        int contador=0;
        char[] paqueteOriginal=new char[8];
        boolean bandera=false;
        for(int i=0;i<info.length-1;i++){

            if (info[i]=='1'){
                contador++;
            }else{
                contador=0;
            }

            if(contador==5){
                paqueteOriginal[i]=info[i];
                bandera=true;
                contador=0;

            }else{
                if(bandera){
                    paqueteOriginal[i]=info[i+1];

                }else{
                    paqueteOriginal[i]=info[i];
                }

            }

        }

        this.bufferReceptor=paqueteOriginal;
        System.out.println("Recibido: ") ;
        System.out.println(bufferReceptor);
        System.out.println("******************");


    }

    public void paridadReceptor(){

        int contadorParidad=0;

        for(int i=0; i<arregloParidadReceptor.length; i++){

            if(i<arregloParidadReceptor.length-1){
                if(bufferReceptor[i]=='1'){
                    contadorParidad++;
                }
                arregloParidadReceptor[i]=bufferReceptor[i];
            }else{
                if(contadorParidad % 2==0){
                    arregloParidadReceptor[i]='0';

                }else {
                    arregloParidadReceptor[i]='1';
                }

            }


        }



        System.out.println("Paridad Receptor: ");
        System.out.println(arregloParidadReceptor);

    }

    public boolean controlParidad(char[] arregloParidadEmisor){

        if(arregloParidadEmisor[arregloParidadEmisor.length-1]==
                arregloParidadReceptor[arregloParidadReceptor.length-1]){
            System.out.println("*************************************");
            System.out.println("El paquete se recibió sin errores");
            return true;
        }else{
            System.out.println("*************************************");
            System.out.println("El paquete contiene un error de un bit");
            return false;
        }

    }

}
