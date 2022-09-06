/*
Arithos Omadas: 86
Xrhstos Pekos 3180153
Aggeliki Boulieri 3180121
Gewrgios Papastathopoulos 3200144
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MainApp {

    public static void main (String[] args) {
        ArrayList<TuposDapanis> expenseTypeList = new ArrayList<TuposDapanis>();
        ArrayList<Ergazomenos> employeesList = new ArrayList<Ergazomenos>();
        ArrayList<DapaniErgazomenou> employeeExpensesList = new ArrayList<DapaniErgazomenou>();
        ArrayList<Kiniseis> employeeMovementsList = new ArrayList<Kiniseis>();

      //---------------------- ARXIKOPOIHSH LISTAS TUPWN DAPANWN ----------------------//
      expenseTypeList.add(new TuposDapanis1("1103", "Travelling", 80, 1.5, "km"));
      expenseTypeList.add(new TuposDapanis1("1104", "Staying in a hotel", 200, 40, "days"));
      expenseTypeList.add(new TuposDapanis1("1105", "Nutrition", 100, 30, "days"));
      expenseTypeList.add(new TuposDapanis2("1106", "Taxi Route", 50, 0.45));
      expenseTypeList.add(new TuposDapanis2("1107", "Phone purchase", 50, 0.2));
      expenseTypeList.add(new TuposDapanis2("1108", "Laptop purchase", 200, 0.25));

      //---------------------- ARXIKOPOIHSH LISTAS ERGAZOMENWN ----------------------//
      employeesList.add(new Ergazomenos("1231", "NIKOS", "PAPADOPOULOS", 200));
      employeesList.add(new Ergazomenos("2341", "TASOS", "ANDREOU", 250));
      employeesList.add(new Ergazomenos("3563","XRISTOS", "KOUTSIKAS", 180));
      employeesList.add(new Ergazomenos("9865", "VASILIS", "KONSTAS", 220));

      //---------------------- ARXIKOPOIHSH LISTAS DAPANWN ERGAZOMENWN ----------------------//
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(0), expenseTypeList.get(0), expenseTypeList.get(0).upologismosDapanis(90)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(0), expenseTypeList.get(1), expenseTypeList.get(1).upologismosDapanis(3)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(0), expenseTypeList.get(2), expenseTypeList.get(2).upologismosDapanis(3)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(0), expenseTypeList.get(3), expenseTypeList.get(3).upologismosDapanis(15)));

      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(1), expenseTypeList.get(0), expenseTypeList.get(0).upologismosDapanis(50)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(1), expenseTypeList.get(1), expenseTypeList.get(1).upologismosDapanis(5)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(1), expenseTypeList.get(4), expenseTypeList.get(4).upologismosDapanis(200)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(1), expenseTypeList.get(5), expenseTypeList.get(5).upologismosDapanis(800)));

      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(2), expenseTypeList.get(0), expenseTypeList.get(4).upologismosDapanis(75)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(2), expenseTypeList.get(1), expenseTypeList.get(4).upologismosDapanis(1)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(2), expenseTypeList.get(2), expenseTypeList.get(4).upologismosDapanis(3)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(2), expenseTypeList.get(5), expenseTypeList.get(4).upologismosDapanis(600)));

      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(3), expenseTypeList.get(1), expenseTypeList.get(4).upologismosDapanis(2)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(3), expenseTypeList.get(2), expenseTypeList.get(4).upologismosDapanis(4)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(3), expenseTypeList.get(3), expenseTypeList.get(4).upologismosDapanis(20)));
      employeeExpensesList.add(new DapaniErgazomenou(employeesList.get(3), expenseTypeList.get(4), expenseTypeList.get(4).upologismosDapanis( 175)));

      //---------------------- ARXIKOPOIHSH LISTAS KINHSEWN ERGAZOMENWN ----------------------//
      employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(0),80));
      employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(1),70));
      employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(2),100));
      employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(3),50));

        Scanner scr = new Scanner(System.in);
        ListUpdater updater = new ListUpdater();

        //---------------------- ENHMERWSH LISTWN ME VASH TA ARXEIA TXT ----------------------//
        employeesList = updater.updateEmployeeList(employeesList,"EMPLOYEE_LIST.txt");
        expenseTypeList = updater.updateExpenseTypeList(expenseTypeList,"EXPENSE_TYPE_LIST.txt");
        employeeExpensesList = updater.updateEmployeeExpenseTypeList(employeeExpensesList,"EXPENSE_LIST.txt");
        employeeMovementsList = updater.updateMovementTypeList(employeeMovementsList,"TRN_LIST.txt");

        String name;
        String surname;
        String code;
        float maxMontlyCompensation;

        boolean flag = false;
        int c1 = 0;
        int c2 = 0;
        String c3;
        double c4 = 0;
        String description;
        double price = 0;
        String measurementUnit = null;
        double compensationPercentage;
        double sum;
        double diafora;

        while (!flag) {
          System.out.println("         Menu      \n" +
                  "1. Enter a new expense type.\n" +
                  "2. Enter a new employee.\n" +
                  "3. Enter a new employee expense.\n" +
                  "4. Enter a new advance fee.\n" +
                  "5. Show expenses of all employees.\n" +
                  "6. Clean employee's expenses.\n" +
                  "7. Show an employee's movements.\n" +
                  "8. Clean expenses of all employees.\n" +
                  "9. Show final monthly compensation for all employees.\n" +
                  "10. Write all the new employee expenses on a txt.\n" +
                  "11. Write all the new employee movements on a txt.\n" +
                  "12. Exit.");

            c1 = Integer.parseInt(scr.nextLine());
            switch (c1) {

                //Getting from user a new expense type
                case 1:
                    System.out.println("What type of formula will be used for the calculation of the expense? \n" +
                            "1. Quantity * Price \n" +
                            "2. Value * Compensation Percentage");
                    c2 = Integer.parseInt(scr.nextLine());

                    System.out.println("Enter a code.");
                    code = scr.nextLine();
                    System.out.println("Enter a description.");
                    description = scr.nextLine();
                    System.out.println("Enter the max monthly compensation.");
                    maxMontlyCompensation = Float.parseFloat(scr.nextLine());

                    if (c2 == 1) {
                        System.out.println("Enter a price per measurement unit.");
                        price = Integer.parseInt(scr.nextLine());
                        System.out.println("Enter a measurement unit.");
                        measurementUnit = scr.nextLine();
                        expenseTypeList.add(new TuposDapanis1(code, description, maxMontlyCompensation, price, measurementUnit));

                    } else {
                        System.out.println("Enter a compensation percentage.");
                        compensationPercentage = Double.parseDouble(scr.nextLine());
                        expenseTypeList.add(new TuposDapanis2(code, description, maxMontlyCompensation, compensationPercentage));

                    }
                    break;

                //Getting from user a new employee
                case 2:
                    System.out.println("Enter employee's name.");
                    name = scr.nextLine();
                    System.out.println("Enter employee's surname.");
                    surname = scr.nextLine();
                    System.out.println("Enter employee's max monthly compensation value.");
                    maxMontlyCompensation = Float.parseFloat(scr.nextLine());
                    System.out.println("Enter employee's code.");
                    code = scr.nextLine();

                    Ergazomenos ergazomenos = new Ergazomenos(code, name, surname, maxMontlyCompensation);
                    employeesList.add(ergazomenos);

                    break;

                //Getting from user a new employee expense
                case 3:
                    Ergazomenos tempE = null;
                    TuposDapanis tempD = null;

                    System.out.println("Choose the employee for whom you want to create an expense:");
                    for (int i = 0; i < employeesList.size(); i++) {
                        System.out.println((i + 1) + ". " + employeesList.get(i).onoma + " " + employeesList.get(i).epitheto);
                    }
                    c2 = Integer.parseInt(scr.nextLine()) - 1;
                    tempE = employeesList.get(c2);

                    for (int i = 0; i < expenseTypeList.size(); i++) {
                        System.out.println(i + ". " + expenseTypeList.get(i).perigrafi);
                    }
                    System.out.println("Choose the expense type you want.");
                    c2 = Integer.parseInt(scr.nextLine());
                    tempD = expenseTypeList.get(c2);
                    System.out.println("Enter the amount/value this expense refers to.");
                    double poso = tempD.upologismosDapanis(Double.parseDouble(scr.nextLine()));
                    employeeExpensesList.add(new DapaniErgazomenou(tempE, tempD, poso));

                    break;

                //Getting from user a new advance fee
                case 4:
                    int l = 1;
                    KiniseisProkatavolis tempM = null;
                    for (Ergazomenos erg : employeesList) {
                        System.out.println(l + erg.toString());
                        l++;
                    }
                    System.out.println("Choose the number of the employer you want to add the ");
                    c1 = Integer.parseInt(scr.nextLine());
                    System.out.println("Choose the amount of money");
                    c4 = Double.parseDouble(scr.nextLine());
                    tempM = new KiniseisProkatavolis(employeesList.get(c1 - 1), c4);
                    employeeMovementsList.add(tempM);
                    break;

                //Printing the expenses of all employees
                case 5:
                    System.out.println(employeeExpensesList.size());
                    for (int i = 1; i < employeeExpensesList.size(); i++) {
                        System.out.println(employeeExpensesList.get(i).toString());
                    }
                    break;

                //Cleaning an employee's expenses
                case 6:
                    sum = 0;
                    l = 1;
                    System.out.println("Choose one of the employees to calculate all their expenses.");
                    for (Ergazomenos erg : employeesList) {
                        System.out.println(l + ". " + erg.toString());
                        l++;
                    }
                    c2 = Integer.parseInt(scr.nextLine()) - 1;

                    l = 0;
                    do {
                        if (employeeExpensesList.get(l).ergazomenos.equals(employeesList.get(c2))) {
                            System.out.println(employeeExpensesList.get(l).tuposDapanis.perigrafi + " " +
                                    employeeExpensesList.get(l).aksiaApozimiosis);
                            //Comparing expense's value with max compensation that can been given for it's type
                            //If the amount is greater than max compensation we change it to max compensation amount
                            if (employeeExpensesList.get(l).aksiaApozimiosis > employeeExpensesList.get(l).tuposDapanis.megistiMiniaiaApozimiosi) {
                                employeeExpensesList.get(l).aksiaApozimiosis = employeeExpensesList.get(l).tuposDapanis.megistiMiniaiaApozimiosi;
                            }
                            //Adding expense's compensation as employee's movement
                            employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisApozimiosis(employeesList.get(c2),
                                    employeeExpensesList.get(l).aksiaApozimiosis, employeeExpensesList.get(l).tuposDapanis));
                            employeeMovementsList.add(new KiniseisApozimiosis(employeesList.get(c2),
                                    employeeExpensesList.get(l).aksiaApozimiosis, employeeExpensesList.get(l).tuposDapanis));
                            //Removing the expense from employees' expenses list
                            employeeExpensesList.remove(l);
                            continue;
                        }
                        l++;
                    } while (l < employeeExpensesList.size());

                    for (Kiniseis k : employeesList.get(c2).kiniseisErgazomenou) {
                        sum += k.aksiaApozimiosis;
                    }
                    System.out.println(sum);
                    //Adding difference movement
                    diafora = sum - employeesList.get(c2).megistiMiniaiaApozimiosi;
                    if (diafora < 0) {
                        diafora = 0;
                    }
                    employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisDiaforas(employeesList.get(c2), diafora));
                    employeeMovementsList.add(new KiniseisDiaforas(employeesList.get(c2), diafora));

                    //Adding payment in advance movement
                    System.out.println("What amount would you like to pay in advance for " + employeesList.get(c2).epitheto + "'s " +
                            "expenses?\n" +
                            "Their total compensation amount for this month is " + (sum - diafora));
                    c4 = Double.parseDouble(scr.nextLine());
                    employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisProkatavolis(employeesList.get(c2), c4));
                    employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(c2), c4));

                    //Adding final compensation movement
                    employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisTelikisApozimiosis(employeesList.get(c2), sum - diafora - c4));
                    employeeMovementsList.add(new KiniseisTelikisApozimiosis(employeesList.get(c2), sum - diafora - c4));
                    break;

                //Printing an employee's movements
                case 7:
                    l = 1;
                    System.out.println("Choose the employee whose movements you want to see.");
                    for (Ergazomenos erg : employeesList) {
                        System.out.println(l + ". " + erg.toString());
                        l++;
                    }
                    c2 = Integer.parseInt(scr.nextLine()) - 1;

                    for (int i = 0; i < employeesList.get(c2).kiniseisErgazomenou.size(); i++) {
                        System.out.println(employeesList.get(c2).kiniseisErgazomenou.get(i).toString());
                    }
                    break;

                //Cleaning all employees' expenses
                case 8:
                    for (c2 = 0; c2 < employeesList.size(); c2++) {
                        l = 0;
                        sum = 0;
                        do {
                            if (employeeExpensesList.get(l).ergazomenos.equals(employeesList.get(c2))) {
                                System.out.println(employeeExpensesList.get(l).tuposDapanis.perigrafi + " " +
                                        employeeExpensesList.get(l).aksiaApozimiosis);
                                //Comparing expense's value with max compensation that can been given for it's type
                                //If the amount is greater than max compensation we change it to max compensation amount
                                if (employeeExpensesList.get(l).aksiaApozimiosis > employeeExpensesList.get(l).tuposDapanis.megistiMiniaiaApozimiosi) {
                                    employeeExpensesList.get(l).aksiaApozimiosis = employeeExpensesList.get(l).tuposDapanis.megistiMiniaiaApozimiosi;
                                }
                                //Adding expense's compensation as employee's movement
                                employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisApozimiosis(employeesList.get(c2),
                                        employeeExpensesList.get(l).aksiaApozimiosis, employeeExpensesList.get(l).tuposDapanis));
                                employeeMovementsList.add(new KiniseisApozimiosis(employeesList.get(c2),
                                        employeeExpensesList.get(l).aksiaApozimiosis, employeeExpensesList.get(l).tuposDapanis));
                                //Removing the expense from employees' expenses list
                                employeeExpensesList.remove(l);
                                continue;
                            }
                            l++;
                        } while (l < employeeExpensesList.size());

                        for (Kiniseis k : employeesList.get(c2).kiniseisErgazomenou) {
                            sum += k.aksiaApozimiosis;
                        }
                        System.out.println(sum);
                        //Adding difference movement
                        diafora = sum - employeesList.get(c2).megistiMiniaiaApozimiosi;
                        if (diafora < 0) {
                            diafora = 0;
                        }
                        employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisDiaforas(employeesList.get(c2), diafora));
                        employeeMovementsList.add(new KiniseisDiaforas(employeesList.get(c2), diafora));

                        //Adding payment in advance movement
                        System.out.println("What amount would you like to pay in advance for " + employeesList.get(c2).epitheto + "'s " +
                                "expenses?\n" +
                                "Their total compensation amount for this month is " + (sum - diafora));
                        c4 = Double.parseDouble(scr.nextLine());
                        employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisProkatavolis(employeesList.get(c2), c4));
                        employeeMovementsList.add(new KiniseisProkatavolis(employeesList.get(c2), c4));

                        //Adding final compensation movement
                        employeesList.get(c2).kiniseisErgazomenou.add(new KiniseisTelikisApozimiosis(employeesList.get(c2), sum - diafora - c4));
                        employeeMovementsList.add(new KiniseisTelikisApozimiosis(employeesList.get(c2), sum - diafora - c4));
                    }
                    break;

                //Calculating and printing the total compensation amount for all the employees
                case 9:
                    for (Ergazomenos erg : employeesList){
                      System.out.println(erg.toString() + " " + erg.megistiMiniaiaApozimiosi);
                      System.out.println("To sunoliko poso apozimiosis einai " + Kiniseis.upologismosKinhseon(erg.kiniseisErgazomenou));
                    }
                    break;

                //Updating EXPENSE_LIST.txt with all the expenses that have been added till now
                case 10:
                    updater.writeEmployeeExpense(employeeExpensesList);
                    break;

                //Updating TRN_LIST.txt with all the movements that have been added till now
                case 11:
                    updater.writeEmployeeMovement(employeeMovementsList);
                    break;

                //Updating EXPENSE_LIST.txt and TRN_LIST.txt and exiting the program
                case 12:
                    flag = true;
                    updater.writeEmployeeExpense(employeeExpensesList);
                    updater.writeEmployeeMovement(employeeMovementsList);
                    break;

                default:
                    System.out.println("The number you entered is invalid!Please try again.\n");
                    break;
            }
        }
    }
}
