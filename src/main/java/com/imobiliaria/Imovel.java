package main.java.com.imobiliaria;

public abstract class Imovel {
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    protected Proprietario proprietario;
    private static int idCont  =1;
    private int id;

    public Imovel(String endereco, int numero,Proprietario proprietario){
        this.id= idCont++;
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario= proprietario;

    }

    public int getId(){return  id;}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    public abstract String estaAlugado();

    public String contatoProprietario(){
        return "Proprietário: " + proprietario.getNome() + ", Telefone: " + proprietario.getTelefone();
    }

    public abstract int calcularAluguel(int meses);

    @Override
    public String toString() {
        return  "ID: " +id+
                "\nEndereço: " +endereco+
                "\nNúmero: " +numero+
                "\nStatus: " +estaAlugado()+
                "\nProprietário: " +proprietario.getNome() + ", Telefone: " + proprietario.getTelefone();
    }

}