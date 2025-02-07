public class Conta {


        public Cliente Cliente = new Cliente();
        public int numConta = 0;
        public double saldo = 0;
        public double limite = 0;
        public Operacao[] operacoes = new Operacao[1000];
        public int nOperacoes = 0;

        public void imprimirInfo() {
            System.out.println("....Numero da conta:  " + numConta);
            System.out.println("....Nome:  " + Cliente.nome);
            System.out.println("....Saldo atual:  " + saldo);
            System.out.println("....Limite:  " + limite);
        }

        public boolean sacar(double valor) {
            if (valor > saldo || valor < 0) {
                return false;
            } else {
                this.saldo -= valor;
                this.operacoes[nOperacoes] = new OperacaoSaque(valor);
                nOperacoes++;
                return true;
            }
        }

        public boolean depositar(double valor) {
            if (valor < 0){
                return false;
            } else {
                this.saldo += valor;
                this.operacoes[nOperacoes] = new OperacaoDeposito(valor);
                nOperacoes++;
                return true;
            }
        }

        public void imprimirExtrato() {
            System.out.println("Extrato Bancário");
            for (int i = 0; i < 1000; i++) {
                System.out.println("DATA " + this.operacoes[nOperacoes].getData() + " Operação: " + this.operacoes[nOperacoes].getTipo() + " Valor: R$" + this.operacoes[nOperacoes].getValor());
            }
        }


}
