import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    
    private int id;
    private List<Carros> estoque = new ArrayList<Carros>();

    public void Adicionar(String modelo, Double valor){
        this.id+=1;
        Carros car = new Carros();
        car.modelo=modelo;
        car.valor=valor;
        car.id=id;
        estoque.add(car);
    }

    public void Retirada(int id){
        estoque.remove(id);
       
    }

    public List<Carros> ListarEstoque(){
        return estoque;
    }
    
}