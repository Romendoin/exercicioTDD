package Classes;

import java.time.Duration;

public class Intervalo {
    private int tempo;

    public Intervalo(int horas, int minutos, int segundos){
        this.tempo = (horas * 60 * 60) + (minutos * 60) + (segundos);
        if (this.tempo < 0){
            throw new IntervaloException("O intervalo não pode ser negativo!");
        }
    }

    public int getHoras(){return (int) Duration.ofSeconds(this.tempo).toHours();}

    public int getMinutos(){return Duration.ofSeconds(this.tempo).toMinutesPart();}

    public int getTotalMinutos(){return (int) Duration.ofSeconds(this.tempo).toMinutes();}

    public int getSegundos(){return Duration.ofSeconds(this.tempo).toSecondsPart();}

    public int getTotalSegundos(){return (int) Duration.ofSeconds(this.tempo).toSeconds();}

    public Intervalo somar(Intervalo intervaloSoma){
        return new Intervalo(0,0, this.tempo + intervaloSoma.getTotalSegundos());
    }

    public Intervalo subtrair(Intervalo intervaloSub){
        return new Intervalo(0, 0, this.tempo - intervaloSub.getTotalSegundos());
    }

    public boolean ehIgual(Intervalo intervaloIgual){
        return this.tempo == intervaloIgual.getTotalSegundos();
    }

    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", getHoras(), getMinutos(), getSegundos());
    }
}
