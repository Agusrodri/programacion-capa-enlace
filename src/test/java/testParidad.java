
import entidades.Emisor;
import entidades.Receptor;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testParidad {

    @Test
    public void verificarParidadDistinta(){

        Emisor emisor=new Emisor();
        Receptor receptor= new Receptor();

        emisor.setReceptor(receptor);

        emisor.setBufferEmisor(new char[]{'1', '1', '1', '1', '1', '1', '1','0'});
        emisor.getReceptor().setBufferReceptor(new char[]{'1', '1', '1', '1', '1', '1', '1','1'});

        emisor.getReceptor().paridadReceptor();
        emisor.paridadEmisor();

        Assertions.assertFalse(emisor.getReceptor().controlParidad(emisor.getArregloParidadEmisor()));

    }

}
