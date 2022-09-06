import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ListUpdater {

  public ArrayList<TuposDapanis> updateExpenseTypeList(ArrayList<TuposDapanis> list, String file) {
      try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String listType;
        StringTokenizer lineToken;
        String token;

        int type = 0;
        String code = null;
        String description = null;
        double megistiMiniaiaApozimiosi = 0;
        double timiAnaMonada = 0;
        String monadaMetrisis = null;
        double posostoDapanis = 0;

        line = br.readLine();

        while (line != null) {
          lineToken = new StringTokenizer(line);

          if (lineToken.hasMoreTokens()) {
            token = lineToken.nextToken();

            //Elegxoume tis times ths kathe grammhs mexri na ftasoume sto telos twn stoixeiwn enos antikeimenou
            if (!token.equals("}")) {
              if (token.equals("TYPE") || token.equals("TYPE".toLowerCase())) {
                token = lineToken.nextToken();
                type = Integer.parseInt(token);
              }
              else if (token.equals("CODE") || token.equals("CODE".toLowerCase())) {
                token = lineToken.nextToken();
                code = token;
              }
              else if (token.equals("DECSR") || token.equals("DECSR".toLowerCase())) {
                token = lineToken.nextToken();
                description = token;
              }
              else if (token.equals("MAX_MONTHLY_COMPENSATION") || token.equals("MAX_MONTHLY_COMPENSATION".toLowerCase())) {
                token = lineToken.nextToken();
                megistiMiniaiaApozimiosi = Double.parseDouble(token);
              }
              else if (token.equals("PRICE_PER_QUANTITY") || token.equals("PRICE_PER_QUANTITY".toLowerCase())) {
                token = lineToken.nextToken();
                timiAnaMonada = Double.parseDouble(token);
              }
              else if (token.equals("MEASUREMENT_UNIT") || token.equals("MEASUREMENT_UNIT".toLowerCase())) {
                token = lineToken.nextToken();
                monadaMetrisis = token;
              }
              else if (token.equals("PERCENTAGE_RETURN") || token.equals("PERCENTAGE_RETURN".toLowerCase())) {
                token = lineToken.nextToken();
                posostoDapanis = Double.parseDouble(token);
              }
            }
            else {
              if (type == 1 && code!=null && description!=null) {
                //Ftiaxnoume antikeimeno prwtou tupou
                list.add(new TuposDapanis1(code, description, megistiMiniaiaApozimiosi, timiAnaMonada, monadaMetrisis));
              }
              else if (type == 2 & code!=null && description!=null) {
                //Ftiaxnoume antikeimeno deuterou tupou
                list.add(new TuposDapanis2(code, description, megistiMiniaiaApozimiosi, posostoDapanis));
              }
              else{
                System.out.println("Invalid type of expense");
              }
              type = 0;
              code = null;
              description = null;
              megistiMiniaiaApozimiosi = 0;
              timiAnaMonada = 0;
              monadaMetrisis = null;
              posostoDapanis = 0;

            }
          }
          line = br.readLine();

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      //Epistrefoume thn enhmerwmenh lista tupwn dapanhs
      return list;
    }

  public ArrayList<Ergazomenos> updateEmployeeList(ArrayList < Ergazomenos > list, String file){
      try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringTokenizer lineToken;
        String token;

        String code = null;
        String name = null;
        String surname = null;
        float maxMonthlyCompensation = 0;

        line = br.readLine();

        while (line != null) {
          lineToken = new StringTokenizer(line);

          if (lineToken.hasMoreTokens()) {
            token = lineToken.nextToken();

            //Elegxoume tis times ths kathe grammhs mexri na ftasoume sto telos twn stoixeiwn enos antikeimenou
            if (!token.equals("}")) {
              if (token.equals("CODE") || token.equals("CODE".toLowerCase())) {
                //System.out.print(token + " ");
                token = lineToken.nextToken();
                code = token;
                //System.out.println(code);
              } else if (token.equals("FIRSTNAME") || token.equals("FIRSTNAME".toLowerCase())) {
                //System.out.print(token + " ");
                token = lineToken.nextToken();
                name = token;
                //System.out.println(name);
              } else if (token.equals("SURNAME") || token.equals("SURNAME".toLowerCase())) {
                //System.out.print(token + " ");
                token = lineToken.nextToken();
                surname = token;
                //System.out.println(token);
              } else if (token.equals("MAX_MONTHLY_VAL") || token.equals("MAX_MONTHLY_VAL".toLowerCase())) {
                //System.out.print(token + " ");
                token = lineToken.nextToken();
                maxMonthlyCompensation = Float.parseFloat(token);
                //System.out.println(token);
              }
            }
            //Afou exoume diavasei ola ta stoixeia tou antikeimenou elegxoume ean kapoio ap'auta leipei.
            //Ean exoume ta aparaithta stoixeia ftiaxnoume ena antikeimeno tupou Ergazomenos kai to kataxwroume
            //sth lista pou mas dothhke.
            else {
              if (code == null || name == null || surname == null || maxMonthlyCompensation == 0) {
                System.out.println("Invalid employee.");
              }
              else {
                list.add(new Ergazomenos(code, name, surname, maxMonthlyCompensation));
              }

              //Afou dhmiourghthei to antikeimeno (h kai oxi) diagrafoume tis times twn metavlhtwn gia to epomeno
              code = null;
              name = null;
              surname = null;
              maxMonthlyCompensation = 0;
            }
          }
          line = br.readLine();

        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    //Epistrefoume thn enhmerwmeni lista ergazomenwn
    return list;
    }

  public ArrayList<DapaniErgazomenou> updateEmployeeExpenseTypeList(ArrayList<DapaniErgazomenou> list, String file) {
        try {
          BufferedReader br = new BufferedReader(new FileReader(file));
          String line;
          String listType;
          StringTokenizer lineToken;
          String token;

          String employee_code = null;
          int expense_type = 0;
          double val = 0;
          String expense_code = null;
          double megistiMiniaiaApozimiosiDapanis = 150;
          String descriptionOfEmployeeExpense = "mia tupikh dapani ergazomenou";
          double timiAnaMonadaOfEmployee = 0;
          String monadaMetrisisOfEmployee = null;
          double posostoDapanisOfEmployee = 0;
          String nameOfEmployee = null;
          String surnameOfEmployee = null;
          float maxMonthlyCompensationOfEmployee = 0;

          line = br.readLine();

          while (line != null) {
            lineToken = new StringTokenizer(line);

            if (lineToken.hasMoreTokens()) {
              token = lineToken.nextToken();

              //Elegxoume tis times ths kathe grammhs mexri na ftasoume sto telos twn stoixeiwn enos antikeimenou
              if (!token.equals("}")) {
                if (token.equals("EMPLOYEE_CODE") || token.equals("EMPLOYEE_CODE".toLowerCase())) {
                  token = lineToken.nextToken();
                  employee_code = token;
                }
                else if (token.equals("EXPENSE_TYPE") || token.equals("EXPENSE_TYPE".toLowerCase())) {
                  token = lineToken.nextToken();
                  expense_type = Integer.parseInt(token);
                }
                else if (token.equals("EXPENSE_CODE") || token.equals("EXPENSE_CODE".toLowerCase())) {
                  token = lineToken.nextToken();
                  expense_code = token;
                }
                else if (token.equals("VAL") || token.equals("VAL".toLowerCase())) {
                  token = lineToken.nextToken();
                  val = Double.parseDouble(token);
                }
                else if (token.equals("DECSR") || token.equals("DECSR".toLowerCase())) {
                  token = lineToken.nextToken();
                  descriptionOfEmployeeExpense = token;
                }
               else if (token.equals("FIRSTNAME") || token.equals("FIRSTNAME".toLowerCase())) {
                token = lineToken.nextToken();
                nameOfEmployee = token;
              }
              else if (token.equals("SURNAME") || token.equals("SURNAME".toLowerCase())) {
                token = lineToken.nextToken();
                surnameOfEmployee = token;
              }
              else if (token.equals("MAX_MONTHLY_VAL") || token.equals("MAX_MONTHLY_VAL".toLowerCase())) {
                token = lineToken.nextToken();
                maxMonthlyCompensationOfEmployee = Float.parseFloat(token);
              }

              else if (token.equals("MAX_MONTHLY_COMPENSATION") || token.equals("MAX_MONTHLY_COMPENSATION".toLowerCase())) {
                token = lineToken.nextToken();
                megistiMiniaiaApozimiosiDapanis = Double.parseDouble(token);
              }
              else if (token.equals("PRICE_PER_QUANTITY") || token.equals("PRICE_PER_QUANTITY".toLowerCase())) {
                token = lineToken.nextToken();
                timiAnaMonadaOfEmployee = Double.parseDouble(token);
              }
              else if (token.equals("MEASUREMENT_UNIT") || token.equals("MEASUREMENT_UNIT".toLowerCase())) {
                token = lineToken.nextToken();
                monadaMetrisisOfEmployee = token;
              }
              else if (token.equals("PERCENTAGE_RETURN") || token.equals("PERCENTAGE_RETURN".toLowerCase())) {
                token = lineToken.nextToken();
                posostoDapanisOfEmployee = Double.parseDouble(token);
              }
            }
              else {
                if (expense_type == 1 && employee_code!=null && expense_code!=null && val!=0) {
                  //Ftiaxnoume antikeimeno prwtou tupou
                  list.add(new DapaniErgazomenou(new Ergazomenos(employee_code, nameOfEmployee, surnameOfEmployee, maxMonthlyCompensationOfEmployee) , new TuposDapanis1(expense_code, descriptionOfEmployeeExpense, megistiMiniaiaApozimiosiDapanis, timiAnaMonadaOfEmployee, monadaMetrisisOfEmployee), val));
                }
                else if (expense_type == 2 && employee_code!=null && expense_code!=null && val!=0) {
                  //Ftiaxnoume antikeimeno deuterou tupou
                  list.add(new DapaniErgazomenou(new Ergazomenos(employee_code, nameOfEmployee, surnameOfEmployee, maxMonthlyCompensationOfEmployee) , new TuposDapanis2(expense_code, descriptionOfEmployeeExpense, megistiMiniaiaApozimiosiDapanis, posostoDapanisOfEmployee), val));
                }
                else {
                  System.out.println("Invalid type of employee expense");
                }
                employee_code = null;
                expense_type = 0;
                val = 0;
                expense_code = null;
                descriptionOfEmployeeExpense = "mia tupikh dapani ergazomenou";
                megistiMiniaiaApozimiosiDapanis = 150;
                timiAnaMonadaOfEmployee = 0;
                monadaMetrisisOfEmployee = null;
                posostoDapanisOfEmployee = 0;
                nameOfEmployee = null;
                surnameOfEmployee = token;
                maxMonthlyCompensationOfEmployee = 0;
              }

            }
            line = br.readLine();
          }
        }
        catch (IOException e) {
          e.printStackTrace();
        }
        //Epistrefoume thn enhmerwmenh lista tupwn dapanhs
        return list;
      }

  public ArrayList<Kiniseis> updateMovementTypeList(ArrayList<Kiniseis> list, String file) {
          try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String listType;
            StringTokenizer lineToken;
            String token;

            String trn_code = null;
            String trn_type = null;
            double trn_value = 0;
            String trn_name = "Onoma";
            String trn_surname = "Epitheto";
            float trn_maxMonthlyCompensation = 300;
            int trn_expense_type = 0;
            String trn_expense_code = null;
            String trn_description = "mia tupiki apozimiosi";
            double trn_megistiMiniaiaApozimiosi = 150;
            double trn_timiAnaMonada = 20;
            String trn_monadaMetrisis = "km/h";
            double trn_posostoDapanis = 13;

            line = br.readLine();

            while (line != null) {
              lineToken = new StringTokenizer(line);

              if (lineToken.hasMoreTokens()) {
                token = lineToken.nextToken();

                //Elegxoume tis times ths kathe grammhs mexri na ftasoume sto telos twn stoixeiwn enos antikeimenou
                if (!token.equals("}")) {
                  if (token.equals("EMPLOYEE_CODE") || token.equals("EMPLOYEE_CODE".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_code = token;
                  }
                  else if (token.equals("TYPE") || token.equals("TYPE".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_type = token;
                  }
                  else if (token.equals("VAL") || token.equals("VAL".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_value = Double.parseDouble(token);
                  }
                  else if (token.equals("FIRSTNAME") || token.equals("FIRSTNAME".toLowerCase())) {
                  //System.out.print(token + " ");
                  token = lineToken.nextToken();
                  trn_name = token;
                  //System.out.println(name);
                } else if (token.equals("SURNAME") || token.equals("SURNAME".toLowerCase())) {
                  //System.out.print(token + " ");
                  token = lineToken.nextToken();
                  trn_surname = token;
                  //System.out.println(token);
                } else if (token.equals("MAX_MONTHLY_VAL") || token.equals("MAX_MONTHLY_VAL".toLowerCase())) {
                  //System.out.print(token + " ");
                  token = lineToken.nextToken();
                  trn_maxMonthlyCompensation = Float.parseFloat(token);
                  //System.out.println(token);
                }
                  else if (token.equals("EXPENSE_TYPE") || token.equals("EXPENSE_TYPE".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_expense_type = Integer.parseInt(token);
                  }
                  else if (token.equals("EXPENSE_CODE") || token.equals("EXPENSE_CODE".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_expense_code = token;
                  }
                  else if (token.equals("DECSR") || token.equals("DECSR".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_description = token;
                  }
                  else if (token.equals("MAX_MONTHLY_COMPENSATION") || token.equals("MAX_MONTHLY_COMPENSATION".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_megistiMiniaiaApozimiosi = Double.parseDouble(token);
                  }
                  else if (token.equals("PRICE_PER_QUANTITY") || token.equals("PRICE_PER_QUANTITY".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_timiAnaMonada = Double.parseDouble(token);
                  }
                  else if (token.equals("MEASUREMENT_UNIT") || token.equals("MEASUREMENT_UNIT".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_monadaMetrisis = token;
                  }
                  else if (token.equals("PERCENTAGE_RETURN") || token.equals("PERCENTAGE_RETURN".toLowerCase())) {
                    token = lineToken.nextToken();
                    trn_posostoDapanis = Double.parseDouble(token);
                  }
                }
                else {
                  if (trn_type == "APOZIMIOSI" || trn_type == "APOZIMIOSI".toLowerCase()) {
                    if(trn_expense_type == 1){
                      list.add(new KiniseisApozimiosis(new Ergazomenos(trn_code, trn_name, trn_surname, trn_maxMonthlyCompensation), trn_value, new TuposDapanis1(trn_expense_code, trn_description, trn_megistiMiniaiaApozimiosi, trn_timiAnaMonada, trn_monadaMetrisis)));
                    }
                    else if(trn_expense_type ==2){
                      list.add(new KiniseisApozimiosis(new Ergazomenos(trn_code, trn_name, trn_surname, trn_maxMonthlyCompensation), trn_value, new TuposDapanis2(trn_expense_code, trn_description, trn_megistiMiniaiaApozimiosi, trn_posostoDapanis)));
                    }
                    else{
                      System.out.println("Not valid expense type");
                    }
                  }
                  else if (trn_type == "PROKATAVOLI" || trn_type == "PROKATAVOLI".toLowerCase()) {
                    list.add(new KiniseisProkatavolis(new Ergazomenos(trn_code, trn_name, trn_surname, trn_maxMonthlyCompensation), trn_value));
                  }
                  else if (trn_type == "DIAFORA" || trn_type == "DIAFORA".toLowerCase()) {
                    list.add(new KiniseisDiaforas(new Ergazomenos(trn_code, trn_name, trn_surname, trn_maxMonthlyCompensation), trn_value));
                  }
                  else if (trn_type == "FINAL_APOZIMIOSI" || trn_type == "FINAL_APOZIMIOSI".toLowerCase()) {
                    list.add(new KiniseisTelikisApozimiosis(new Ergazomenos(trn_code, trn_name, trn_surname, trn_maxMonthlyCompensation), trn_value));
                  }
                  else {
                    System.out.println("Wrong format of movement type");
                  }
                  trn_code = null;
                  trn_type = null;
                  trn_value = 0;
                  trn_name = "Onoma";
                  trn_surname = "Epitheto";
                  trn_maxMonthlyCompensation = 300;
                  trn_expense_type = 0;
                  trn_expense_code = null;
                  trn_description = "mia tupiki apozimiosi";
                  trn_megistiMiniaiaApozimiosi = 150;
                  trn_timiAnaMonada = 20;
                  trn_monadaMetrisis = "km/h";
                  trn_posostoDapanis = 13;

                }
              }
              line = br.readLine();

            }
          } catch (IOException e) {
            e.printStackTrace();
          }
          //Epistrefoume thn enhmerwmenh lista tupwn dapanhs
          return list;
        }

  public void writeEmployeeExpense(ArrayList<DapaniErgazomenou> list) {
    try {

      FileWriter writer = new FileWriter("employee_expenses.txt");

      writer.write("EMPLOYEE_LIST" +
              "\n{");
      for(DapaniErgazomenou de : list) {
        if(de.tuposDapanis.tupos == 1) {

          TuposDapanis1 tempD = (TuposDapanis1) de.tuposDapanis;
          Ergazomenos tempE = de.ergazomenos;

          writer.write("\n EMPLOYEE" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  EXPENSE_TYPE 1" +
                  "\n  EXPENSE_CODE " + tempD.kodikos +
                  "\n  VAL " + de.aksiaApozimiosis +
                  "\n  DESCR " + tempD.perigrafi +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempD.megistiMiniaiaApozimiosi +
                  "\n  MAX_MONTHLY_COMPENSATION " + tempE.megistiMiniaiaApozimiosi +
                  "\n  PRICE_PER_QUANTITY " + tempD.timiAnaMonada +
                  "\n  MEASUREMENT_UNIT " + tempD.monadaMetrisis +
                  "\n }");
        }
        else if(de.tuposDapanis.tupos == 2) {

          TuposDapanis2 tempD = (TuposDapanis2) de.tuposDapanis;
          Ergazomenos tempE = de.ergazomenos;

          writer.write("\n EMPLOYEE" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  EXPENSE_TYPE 1" +
                  "\n  EXPENSE_CODE " + tempD.kodikos +
                  "\n  VAL " + de.aksiaApozimiosis +
                  "\n  DESCR " + tempD.perigrafi +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempD.megistiMiniaiaApozimiosi +
                  "\n  MAX_MONTHLY_COMPENSATION " + tempE.megistiMiniaiaApozimiosi +
                  "\n  RETURN_PERCENTAGE " + tempD.posostoApozimiosis +
                  "\n }");
        }
      }
      writer.write("\n}");

      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void writeEmployeeMovement(ArrayList<Kiniseis> list) {
    try {

      FileWriter writer = new FileWriter("TRN_LIST.txt");
      writer.write("TRN_LIST" +
              "\n{");
      for(Kiniseis k : list) {
        Ergazomenos tempE = k.ergazomenos;

        //Ean exoume kinhsh apozhmiwshs
        if(k.tupos == 1) {
          KiniseisApozimiosis tempK = (KiniseisApozimiosis) k;
          TuposDapanis tempD = tempK.tuposDapanis;

          writer.write("\n TRN" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  TYPE APOZIMIOSI" +
                  "\n  VAL " + tempK.aksiaApozimiosis +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempD.megistiMiniaiaApozimiosi);
          if(tempD.tupos == 1) {
            TuposDapanis1 tempD1 = (TuposDapanis1) tempD;

            writer.write("\n  EXPENSE_TYPE 1" +
                  "\n  EXPENSE_CODE " + tempD.kodikos +
                  "\n  DESCR " + tempD.perigrafi +
                  "\n  MAX_MONTHLY_COMPENSATION " + tempD.megistiMiniaiaApozimiosi +
                  "\n  PRICE_PER_QUANTITY " + tempD1.timiAnaMonada +
                  "\n  MEASUREMENT_UNIT " + tempD1.monadaMetrisis +
                  "\n }");
          }
          else {
            TuposDapanis2 tempD2 = (TuposDapanis2) tempD;

            writer.write("\n  EXPENSE_TYPE 1" +
                    "\n  EXPENSE_CODE " + tempD.kodikos +
                    "\n  DESCR " + tempD.perigrafi +
                    "\n  MAX_MONTHLY_COMPENSATION " + tempD.megistiMiniaiaApozimiosi +
                    "\n  RETURN_PERCENTAGE " + tempD2.posostoApozimiosis +
                    "\n }");
          }

        }
        //Ean exoume kinhsh diaforas
        else if(k.tupos == 2) {
          writer.write("\n TRN" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  TYPE DIAFORA " +
                  "\n  VAL " + k.aksiaApozimiosis +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempE.megistiMiniaiaApozimiosi +
                  "\n }");
        }
        //Ean exoume kinhsh prokatavolhs
        else if(k.tupos == 3) {
          writer.write("\n TRN" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  TYPE PROKATAVOLI " +
                  "\n  VAL " + k.aksiaApozimiosis +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempE.megistiMiniaiaApozimiosi +
                  "\n }");
        }
        //Ean exoume kinhsh telikhs apozhmiwshs
        else if(k.tupos == 4) {
          writer.write("\n TRN" +
                  "\n {" +
                  "\n  EMPLOYEE_CODE " + tempE.kwdikos +
                  "\n  TYPE FINAL_APOZIMIOSI " +
                  "\n  VAL " + k.aksiaApozimiosis +
                  "\n  FIRSTNAME " + tempE.onoma +
                  "\n  SURNAME " + tempE.epitheto +
                  "\n  MAX_MONTHLY_VAL " + tempE.megistiMiniaiaApozimiosi +
                  "\n }");
        }

      }
      writer.write("\n}");

      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

}
