import java.util.Scanner;

public class VendingMachine {
    private VendingMachineService vendingMachineService;
    public void start(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice == -1){
            System.out.println("CCPROG3 Vending Machine");
            System.out.println("Menu: ");
            System.out.println("1. Create a Vending Machine.\n2. Test a Vending Machine\n3. Exit");
            choice = scanner.nextInt();
            if (choice == 1){
//                this.createVendingMachine();
            }
            else if (choice == 2){
                testVendingMachine();
            }

            else if (choice == 3){

                scanner.close();
            }
            else{
                System.out.println("Wrong input! ");
            }



        }
    }
    private void createVendingMachine(){
       this.vendingMachineService = new VendingMachineService();
    }

    private void testVendingMachine(){

    }

}
