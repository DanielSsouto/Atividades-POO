package Auxiliar;

import static Auxiliar.Consts.TIMER_DISPARO;
import java.io.Serializable;

public class Posicao implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;

    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }

    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= TIMER_DISPARO*2*Auxiliar.Consts.RES) // sao 2*Res celulas, e cada celula eh dividida em 8
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        return true;
    }
    
    public int getLinha(){
        return linha;
    }
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }

    public int getColuna(){
        return coluna;
    }

    public boolean estaNaMesmaPosicao(Posicao posicao){
        // dois elementos estao na mesma posicao se eles estao na mesma linha e se
        // a distancia de suas colunas eh menor do que o numero de colunar em uma celula
        return (Math.abs(linha - posicao.getLinha()) == 0 && Math.abs(coluna-posicao.getColuna()) <= TIMER_DISPARO);
    }

    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }
}
