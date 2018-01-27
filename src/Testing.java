import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;


public class Testing{
	public static void main(String[] args){
		
            String csvFile = args[0];
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the action(Search/Add/Remove)");
            String action= scan.nextLine();
           

            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = ",";
            List<Contact> contactList = new ArrayList<Contact>();

            try{

                br = new BufferedReader(new FileReader(csvFile));

                while ((line = br.readLine()) != null) {
                    String [] contacts = line.split(cvsSplitBy);

                    contactList.add(new Contact(contacts[0],contacts[1],contacts[2],contacts[3],contacts[4],contacts[5]));

                }
            } catch(IOException e){

                    System.out.println(e);//e.printStackTrace();

            }
                    if((action.equalsIgnoreCase("search"))|| (action.equalsIgnoreCase("remove"))){
                        System.out.println("Enter the name");
                        String value= scan.nextLine();
                            for(int iteration=0; iteration<contactList.size(); iteration++){
                                    String currentITR = contactList.get(iteration).getFirstName();
                                            if(value.equalsIgnoreCase(currentITR)){
                                                if(action.equalsIgnoreCase("search")){
                                                    System.out.println("Name - "+value+"\nPhone Number - "+contactList.get(iteration).getPhoneNumber()+"\nEmail - "+contactList.get(iteration).getEmail()+"\n");
                                                }
                                                else{
                                                    contactList.remove(contactList.get(iteration).getFirstName());
                                                    FileWriter sw = new FileWriter(csvFile);
                                                    CSVWriter writer = new CSVWriter(sw);
                                                    writer.writeAll(allElements);
                                                    writer.close();
                                                } 
                                    }

                            }
                    }
                  if(action.equalsIgnoreCase("add")){
//                    for(int iteration=0; iteration<contactList.size(); iteration++){
//                           
//                    }
//                    contactList.add(new Contact(args[2],args[3],args[4],args[5],args[6],args[7]));

                  
                    System.out.println("Enter the data that wanted to add");
                    String data= scan.nextLine();
                    //int i=1;
                    String [] dataValues = data.replaceAll("\\s", ",").split(",");
                 try{
                     
                    FileWriter writer = new FileWriter(csvFile,true);

                        writer.append((Integer.toString(contactList.size())));
                        writer.append(',');

                        writer.append(dataValues[0]);
                        writer.append(',');
                        writer.append(dataValues[1]);
                        writer.append(',');
                        writer.append(dataValues[2]);
                        writer.append(',');
                        writer.append(dataValues[3]);
                        writer.append(',');
                        writer.append(dataValues[4]);
                        
                        writer.append('\n');
                        
                        writer.flush();
                        writer.close();
                   }
                   catch(IOException e){
                   } 
                }
                 
            }
}