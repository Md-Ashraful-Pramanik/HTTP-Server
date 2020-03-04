package client;

import common.CONSTANT;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int ID;
        String status= CONSTANT.DEFAULT_STATUS;

        ObjectOutputStream ous;
        ObjectInputStream ois;

        //temporary object
        int id;
        String choice;
        Object object;

        try {
            Socket socket=new Socket(CONSTANT.IP, CONSTANT.PORT);

            ous=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());

            object=ois.readObject();

            if(object instanceof Integer){
                ID=(int)object;
                System.out.println("I am client "+ID);
            }
            else{
                System.out.println("Can not get ID from server");
                return;
            }

            while (true){

                System.out.println("\nPlease select an option");
                System.out.println("1 for GET");
                System.out.println("2 for SET");
                System.out.print("Enter your choice: ");

                choice = scanner.nextLine();

                if(choice.equals("1")){
                    System.out.print("Enter ID: ");
                    try {
                        id=Integer.parseInt(scanner.nextLine());
                    }
                    catch (Exception ex){
                        System.out.println("Please Enter a number");
                        continue;
                    }

                    ous.writeObject(id);
                    ous.flush();

                    object=ois.readObject();
                    if(object instanceof String){
                        System.out.println((String) object);
                    }
                    else {
                        System.out.println("!!!No user registered with this ID.");
                    }

                }
                else if(choice.equals("2")){
                    System.out.print("Enter new status: ");
                    status=scanner.nextLine();

                    ous.writeObject(status);
                    ous.flush();
                }
                else {
                    System.out.println("!!!Please select correctly.Try Again.");
                }

            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Client has problem");
        }

    }
}
