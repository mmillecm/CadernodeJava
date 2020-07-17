import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.util.ArrayList;
import java.util.List;
public class Loja { 

    private String modelo;
    private Double valor;
    private int op,id;
    private final List<Carros> regisvenda = new ArrayList<Carros>();   
    Estoque estoqueloja = new Estoque ();

    public void Menu(){
 

        do{   
            this.op = Integer.parseInt(JOptionPane.showInputDialog(null,"Bem vindo(a) a Loja do Ice ! \n Vendedor escolha suas opções: \n 1- Cadastro \n 2- Venda \n 3- Mostrar Estoque \n 4- Mostrar Registro de Venda\n 5-Sair"));

            switch (op) {
            case 1:
                Cadastrar();
                break;
            case 2:
                Venda();
                break;
            case 3:
                EstoqueLoja();
                break;
            case 4:
                ResgisVendaLoja();
                break;
        
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção valida por favor");
                break;
        }}while(op!=5);
     
    }

    public void Cadastrar(){
        this.modelo=JOptionPane.showInputDialog(null,"Marca do carro:");
        this.valor= Double.parseDouble(JOptionPane.showInputDialog(null, "Valor do carro: "));

        estoqueloja.Adicionar(this.modelo, this.valor);
       
    }

    public void EstoqueLoja(){
        if(estoqueloja.ListarEstoque().size()==0){
            JOptionPane.showMessageDialog(null,"Estoque vazio");
        }else{
            for(int i=0; i<estoqueloja.ListarEstoque().size();i++){
                JOptionPane.showMessageDialog(null,"Cadastro \n ID:"+estoqueloja.ListarEstoque().get(i).id+"\n Modelo:"+estoqueloja.ListarEstoque().get(i).modelo+"\n Valor:"+estoqueloja.ListarEstoque().get(i).valor);
            }
        }
      
    }

    public void Venda(){
        this.id=Integer.parseInt(JOptionPane.showInputDialog(null, "ID do carro vendido:"));
        for(int i=0; i<estoqueloja.ListarEstoque().size();i++){

            if(estoqueloja.ListarEstoque().get(i).id==id){
                regisvenda.add(estoqueloja.ListarEstoque().get(i));
                estoqueloja.Retirada(i);
            }
        }

    }

    public void ResgisVendaLoja(){
        if(regisvenda.size()==0){
            JOptionPane.showMessageDialog(null, "Registro Vazio");
        }
        else{
            for(int i=0; i<regisvenda.size();i++){
                JOptionPane.showMessageDialog(null, "Cadastro \n ID:"+ regisvenda.get(i).id+"\n Modelo:"+regisvenda.get(i).modelo + " \n Valor: "+regisvenda.get(i).valor);
            }
        }
      
    }

    
}