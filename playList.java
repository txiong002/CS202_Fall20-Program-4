//Tou Xiong
//Play list Classes
//This file contains all the Classes for my Hierarchy
//**********MAY NEED TO CHANGE FILE SOURCE LOCATION******************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Util{
    protected Scanner input;
    public Util(){
        input = new Scanner(System.in);
    }
}

//Abstract Base Class Playlist
abstract class playList extends Util {

    //data members
    protected String topic;
    protected String type;
    protected int views;

    //Default Constructor
    public playList(){

        this.topic = null;
        this.type = null;
        this.views = 0;
    }

    //virtual functions
    abstract public void create_topic() throws FileNotFoundException;
    abstract public void remove_topic();
    abstract public void edit_topic();
    //abstract public void read_in(String to_find) throws FileNotFoundException;  //read in external file

    //Display Topic data member
    public void display(){

        System.out.print("\n#######################################################################");
        System.out.print("\nTopic: " + topic);
    }
    //Getters used by Array to compare
    public String getTopic() { return topic; }
    public String getType() {return type; }

    //Setter used by Array to change number of views
    public void add_view(){ this.views = ++views;}

}

//Video Class
class video extends playList {

    //Video data members
    protected String video;
    protected int num_of_videos;
    protected String comments;

    //Default constructor
    public video(){

        this.video = null;
        this.num_of_videos = 0;
        this.comments = null;
    }

    //Loads Topic from text file, for which client can choose which Topic they want to load
    public void create_topic() throws FileNotFoundException {

        System.out.print("\nLoad which topic\n=======================\n");

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_video = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Videos");
        Scanner file = new Scanner(load_video);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            topic = temp_array[0];
            System.out.print("\n" + topic);
        }
        System.out.print("\nWhich topic would you like to load?\n==============================\n");
        topic = input.nextLine();
        type = "Video";
        read_in(topic);

    }
    public void remove_topic() {};
    public void edit_topic() {};

    //Read in from text file to load videos, compares Topic from client and loads correct videos
    public void read_in(String to_find) throws FileNotFoundException {

        String temp_video;

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_video = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Videos");
        Scanner file = new Scanner(load_video);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            String compare = temp_array[0];

            if(to_find.compareTo(compare) == 0){
                
                //String[] video_num = temp_array[1].split(",");
                video = temp_array[1];
                num_of_videos = temp_array.length;
            }
        }
    }

    //Display Playlist Information
    public void display() {
        super.display();
        System.out.println("\nVideo #: " + this.video + "\nComments: " + this.comments + "\nViews: " + this.views);
    }
}

//Quiz Class
class quiz extends video{

    //Quiz data members
    protected String question;
    protected int quiz_number;
    protected int num_of_questions;

    //Default constructor
    public quiz(){
        question = null;
        quiz_number = 0;
        num_of_questions = 0;
    }

    //Create Topic, calls Parent class to create topic, then calls function to add quiz
    public void create_topic() throws FileNotFoundException {

        super.create_topic();
        add_quiz();
    }

    //Create a quiz, calls function to add question
    public void add_quiz() throws FileNotFoundException {

        System.out.print("\nWhat Quiz # is this: ");
        quiz_number = input.nextInt();
        input.nextLine();
        add_question(topic);
    }

    //Add questions from a text file
    public void add_question(String to_find) throws FileNotFoundException {

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_question = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Quizzes");
        Scanner file = new Scanner(load_question);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            String compare = temp_array[0];

            if (to_find.compareTo(compare) == 0) {

                question = temp_array[1];
                num_of_questions = temp_array.length;
            }
        }
    }

    //Display Quiz object, calls parents class first
    public void display(){
        super.display();
        System.out.print("\nQuiz #" + quiz_number + "\n" + question + "\n");
    }
}

//Slideshow Class
class slideshow extends playList {

    //Slideshow data members
    protected String slide;
    protected int slide_number;

    //Default constructor
    public slideshow(){
        slide = null;
        slide_number = 0;
    }

    //Create topic, loads information from text file
    public void create_topic() throws FileNotFoundException {

        System.out.print("\nLoad which topic\n=======================\n");

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_video = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Slideshow");
        Scanner file = new Scanner(load_video);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            topic = temp_array[0];
            System.out.print("\n" + topic);
        }
        System.out.print("\nWhich topic would you like to load?\n==============================\n");
        topic = input.nextLine();
        type = "Slideshow";
        read_in(topic);

    }

    //Read in and load questions from text file
    public void read_in(String to_find) throws FileNotFoundException {

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_question = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Slideshow");
        Scanner file = new Scanner(load_question);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            String compare = temp_array[0];

            if (to_find.compareTo(compare) == 0) {

                slide = temp_array[1];
                slide_number = temp_array.length;
            }
        }
    }

    public void remove_topic() {};
    public void edit_topic() {};

    //Display Slideshow object, calls parent class first
    public void display() {
        super.display();
        System.out.print("\nSlides: " + slide + "\nViews: " + views);
    }
}

//Notes Class
class notes extends playList {

    //Notes data member
    protected String definitions;

    //Default constructor
    public notes(){ definitions = null; }

    //Create topic, loads information from text file
    public void create_topic() throws FileNotFoundException {

        System.out.print("\nLoad which topic\n=======================\n");

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_video = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Notes");
        Scanner file = new Scanner(load_video);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            topic = temp_array[0];
            type = "Notes";
            System.out.print("\n" + topic);
        }
        System.out.print("\nWhich topic would you like to load?\n==============================\n");
        topic = input.nextLine();
        read_in(topic);

    }

    //Read in and loads notes from text file
    public void read_in(String to_find) throws FileNotFoundException {

        //************MAY NEED TO CHANGE PATHNAME WHEN TESTING*******************
        File load_question = new File("C:\\Users\\tfx22\\IdeaProjects\\Prog04_Playlist\\src\\Notes");
        Scanner file = new Scanner(load_question);
        while(file.hasNext()) {

            String line = file.nextLine().trim();
            String[] temp_array = line.split(":");
            String compare = temp_array[0];
            //String [] definition = temp_array[1].split(";");

            if (to_find.compareTo(compare) == 0) {

                definitions = temp_array[1];
            }
        }
    }
    public void remove_topic() {};
    public void edit_topic() {};

    //Display Notes object
    public void display() {
        super.display();
        System.out.print("\nDefine the following terms\n=============================\n" + definitions);
    }
}
