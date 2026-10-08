package Test;

import Classes.IntervaloException;
import org.junit.jupiter.api.*;
import Classes.Intervalo;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class IntervaloTest {

    @Test
    @DisplayName("Teste de criação do objeto")
    public void CriaIntervalo(){
        Assertions.assertDoesNotThrow(() ->  new Intervalo(5,16,67 ));
    }


    @Test
    @DisplayName("Teste de total de horas tem o intervalo")
    public void TesteRetornoHoras(){
        Intervalo intervalo = new Intervalo(3, 20, 89);
        Assertions.assertEquals(3, intervalo.getHoras());
    }

    @Test
    @DisplayName("Teste de minutos")
    public void TesteRetornoMinutos(){
        Intervalo intervalo = new Intervalo(4,37,55);
        Assertions.assertEquals(37, intervalo.getMinutos());
    }

    @Test
    @DisplayName("Teste de total de minutos")
    public void TesteTotalMinutos(){
        Intervalo intervalo = new Intervalo(2,40,10);
        Assertions.assertEquals(160, intervalo.getTotalMinutos());
    }

    @Test
    @DisplayName("Teste de segundos")
    public void TesteRetornoSegundos(){
        Intervalo intervalo = new Intervalo(5,16,49);
        Assertions.assertEquals(49,intervalo.getSegundos());
    }

    @Test
    @DisplayName("Teste de Total de Segundos")
    public void TesteTotalSegundos(){
        Intervalo intervalo = new Intervalo(2,40,10);
        Assertions.assertEquals(9610, intervalo.getTotalSegundos());
    }

    @Test
    @DisplayName("Teste soma de intervalo")
    public void TesteSomaIntervalo(){
        Intervalo intervalo = new Intervalo(0,0,10);
        Intervalo intervaloSoma = new Intervalo(0,0,15);
        Assertions.assertEquals(25, intervalo.somar(intervaloSoma).getTotalSegundos());
    }

    @Test
    @DisplayName("Teste subtração de intervalo")
    public void TesteSubtraiIntervalo(){
        Intervalo intervalo = new Intervalo(0,0,25);
        Intervalo intervaloSub = new Intervalo(0,0,35);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IntervaloException.class,() -> intervalo.subtrair(intervaloSub)),
                () -> Assertions.assertEquals(10, intervaloSub.subtrair(intervalo).getTotalSegundos())
        );

    }

    @Test
    @DisplayName("Teste de igualdade")
    public void TesteIgualdade(){
        Intervalo intervalo = new Intervalo(4,15,0);
        Intervalo intervaloIgual = new Intervalo(4,14,60);
        Intervalo intervaloDiferente = new Intervalo(2,43,16);

        Assertions.assertAll(
                () -> Assertions.assertTrue(intervalo.ehIgual(intervaloIgual)),
                () -> Assertions.assertFalse(intervalo.ehIgual(intervaloDiferente))
        );
    }



}



/*
* Assertions.assertThrows(RuntimeException.class,() -> moto.acelera(-1));
*  Assertions.assertAll(
                () -> Assertions.assertEquals(0, moto.getVelocidade()),
                () -> Assertions.assertDoesNotThrow(() -> moto.acelera(20)),
                () -> Assertions.assertEquals(20, moto.getVelocidade())
        );
*
*
* */