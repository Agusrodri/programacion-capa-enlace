package entidades;

public class Main {

    public static void main(String[] args) {

        Emisor emisor=new Emisor();
        Receptor receptor=new Receptor();
        emisor.setReceptor(receptor);
        emisor.entramado(new char[]{'1', '1', '1', '1', '1', '1', '1','0'});
        emisor.paridadEmisor();

    }

}

