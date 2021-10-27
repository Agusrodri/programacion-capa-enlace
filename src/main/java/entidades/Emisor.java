package entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emisor {
    private char[] bufferEmisor= new char[8];
    char[] arregloParidadEmisor= new char[9];
    private Receptor receptor;


    public void entramado(char[] info){
        this.bufferEmisor=info;
        int contador=0;
        char[] infoAux=new char[9];
        boolean bandera=false;
        for(int i=0;i<info.length;i++){

             if (info[i]=='1'){
                 contador++;
             }else{
                 contador=0;
             }

             if(contador==5){
                 infoAux[i+1]='0';
                 bandera=true;
                 contador=0;
                 infoAux[i]=info[i];
             }else{
                 if(bandera){
                     infoAux[i+1]=info[i];

                 }else{
                     infoAux[i]=info[i];
                 }

             }

        }
        System.out.println("******************");
        System.out.println("Enviado: ");
        System.out.println(info);
        System.out.println("******************");
        System.out.println("Entramado: ");
        System.out.println(infoAux);
        System.out.println("******************");
        receptor.recibir(infoAux);
        receptor.paridadReceptor();

    }

    public void paridadEmisor(){

        int contadorParidad=0;

        for(int i=0; i<arregloParidadEmisor.length; i++){

            if(i<arregloParidadEmisor.length-1){
                if(bufferEmisor[i]=='1'){
                    contadorParidad++;
                }
                arregloParidadEmisor[i]=bufferEmisor[i];
            }else{
                if(contadorParidad % 2==0){
                    arregloParidadEmisor[i]='0';

                }else {
                    arregloParidadEmisor[i]='1';
                }

            }


        }

        System.out.println("******************");
        System.out.println("Paridad Emisor: ");
        System.out.println(arregloParidadEmisor);
        receptor.controlParidad(arregloParidadEmisor);

    }


}
