//Tou Xiong
//CS202 Program04: Playlist
//Data Structure: Array of Linear Linked List
//Implemented with Dynamic Binding

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class main extends Util {

    public static void main(String [] arg) throws IOException{

        Scanner input;
        input = new Scanner(System.in);

        playList ptr = null;
        int choice;
        int size;
        char response;

        System.out.print("How many topics for this class? ");
        size = input.nextInt();
        input.nextLine();
        array my_array = new array(size);

        do{

            System.out.print("What type of media are you ready to load? ");
            System.out.print("\n1. Video\n2. Slideshow\n3. Notes");
            System.out.print("\nChoice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice){

                case 1:{
                    ptr = new quiz();
                    break;
                }
                case 2: {
                    ptr = new slideshow();
                    break;
                }
                case 3: {
                    ptr = new notes();
                    break;
                }
            }

            ptr.create_topic();
            my_array.add_topic(ptr);

            System.out.print("Add another? (y or n) ");
            response = input.next().charAt(0);
            input.nextLine();

        }while(response == 'y');

        my_array.display_all();

        //********************Comment out to test, View a Media *********************
       // do{

       //     System.out.print("Which Topic would you like to view: ");
       //     String temp = input.nextLine();

       //     do{
       //         my_array.view_topic(temp);
       //         System.out.print("\nView another Media? (y or n) \nChoice: ");
       //         response = input.next().charAt(0);
       //         input.nextLine();

       //     }while(response == 'y');

       //     System.out.print("\nView another Topic: (y or n)\nChoice: ");
       //     response = input.next().charAt(0);
       //     input.nextLine();

       // }while(response == 'y');

        //****************Comment out to test, Remove a Media *********************
        //System.out.print("\nWhich Topic would you like to remove from: ");
        //String temp = input.nextLine();

        //my_array.remove_obj(temp);
        //my_array.display_all();

        //***************Comment out to test, Copies Entire Array******************
        //System.out.print("\nCopy Entire List\n===========================\n");
        //array copy_array = new array(size);
        //copy_array.copy_all(my_array);

        //copy_array.display_all();
    }
}
