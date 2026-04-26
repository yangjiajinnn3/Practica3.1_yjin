public class CompteBancari {

   private String titular;

   private String iban;

   private double saldo;

 

   public CompteBancari(String titular, String iban, double saldoInicial) {

       if (titular == null || titular.equals("")) {

           throw new IllegalArgumentException("Error titular");

       }

       if (iban == null || iban.equals("")) {

           throw new IllegalArgumentException("Error iban");

       }

       if (saldoInicial < 0) {

           throw new IllegalArgumentException("Error saldo");

       }

 

       this.titular = titular;

       this.iban = iban;

       this.saldo = saldoInicial;

   }

 

   public void ingressar(double q) {

       if (q <= 0) {

           throw new IllegalArgumentException("Error");

       } else {

           System.out.println("Ingrés iniciat");

           saldo = saldo + q;

           System.out.println("S'ha ingressat " + q);

           System.out.println("Saldo actual " + saldo);

           if (saldo < 1000) {

               System.out.println("Saldo baix");

           } else if (saldo >= 1000 && saldo < 5000) {

               System.out.println("Saldo normal");

           } else {

               System.out.println("Saldo alt");

           }

           System.out.println("Ingrés acabat");

       }

   }

 

   public void retirar(double q) {

       if (q <= 0) {

           throw new IllegalArgumentException("Error");

       } else {

           if (q > saldo) {

               throw new IllegalArgumentException("Error");

           } else {

               System.out.println("Retirada iniciada");

               saldo = saldo - q;

               System.out.println("S'ha retirat " + q);

               System.out.println("Saldo actual " + saldo);

               if (saldo < 1000) {

                   System.out.println("Saldo baix");

               } else if (saldo >= 1000 && saldo < 5000) {

                   System.out.println("Saldo normal");

               } else {

                   System.out.println("Saldo alt");

               }

               System.out.println("Retirada acabada");

           }

       }

   }

 

   public void mostrarDades() {

       System.out.println("Titular: " + titular);

       System.out.println("IBAN: " + iban);

       System.out.println("Saldo: " + saldo);

       if (saldo < 1000) {

           System.out.println("Saldo baix");

       } else if (saldo >= 1000 && saldo < 5000) {

           System.out.println("Saldo normal");

       } else {

           System.out.println("Saldo alt");

       }

   }

 

   public String getTitular() {

       return titular;

   }

 

   public String getIban() {

       return iban;

   }

 

   public double getSaldo() {

       return saldo;

   }

}
