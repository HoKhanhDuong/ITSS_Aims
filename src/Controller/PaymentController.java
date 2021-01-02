package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentController {
	
	public PaymentController() {
		
	}
	public int check(String cart_number, float totalBill){
        List<String> data =  new ArrayList<String>();
        int flag = 0;
        try {
            File myObj = new File("src/Controller/card.txt");
            
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String tmp = myReader.nextLine();
                    if (!tmp.equals("")) {
                        String[] splitString = tmp.split(" ");
                        if(splitString[0].trim().equals(cart_number)){
                            float balance = Float.parseFloat(splitString[1]);
                            if(balance >= totalBill){
                                balance -= totalBill;
                                flag = 1;
                            }else {
                            	flag = -1;
                            }
                            data.add(splitString[0] + " " + balance); 
                        }else{
                            data.add(tmp);
                        }                     
                    }        
                }
            }
            try (FileWriter myWriter = new FileWriter("src/Controller/card.txt")) {
                for(String tmp : data){
                    myWriter.write(tmp);
                }
                myWriter.close();
            }
            return flag;
        } catch (Exception e) {
            return flag;
        }
    }
    public boolean refund(String cart_number, float totalBill){
        List<String> data =  new ArrayList<String>();
        boolean flag = false;
        try {
            File myObj = new File("src/Controller/card.txt");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String tmp = myReader.nextLine();
                    if (!tmp.equals("")) {
                        String[] splitString = tmp.split(" ");
                        if(splitString[0].equals(cart_number)){
                            float balance = Float.parseFloat(splitString[1]);
                            balance += totalBill;
                            flag = true;
                            data.add(splitString[0] + " " + balance); 
                        }else{
                            data.add(tmp);
                        }                     
                    }        
                }
            }
            try (FileWriter myWriter = new FileWriter("src/Controller/card.txt")) {
                for(String tmp : data){
                    myWriter.write(tmp);
                }
                myWriter.close();
            }
            return flag;
        } catch (Exception e) {
            return flag;
        }
    }
    public static void reset(){
        List<String> data =  new ArrayList<String>();
        try {
            File myObj = new File("src/Controller/card.txt");
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String tmp = myReader.nextLine();
                    if (!tmp.equals("")) {
                        String[] splitString = tmp.split(" ");
                        data.add(splitString[0] + " " + 1000000);
                    }        
                }
            }
            try (FileWriter myWriter = new FileWriter("src/Controller/card.txt")) {
                for(String tmp : data){
                    myWriter.write(tmp);
                }
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
        }
    }
}
