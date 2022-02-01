//Tou Xiong
//Array of LLL Class: Contains all functions for my Array

import java.util.Scanner;

public class array extends Util{

    protected node [] head;
    protected int index;

    //array constructor, sets size and each index to null
    array(int size){

        index = size;
        head = new node [index];

        for(int i = 0; i < index; ++i){

            head [i] = null;
        }
    }

    //Add objects to Array List, takes in base class pointer as arg
    public int add_topic(playList to_add){

        if(head == null) return 0;

        int index = 0;
        return add_topic(head,to_add, 0);
    }

    //Add objects to Array
    protected int add_topic(node head[],playList to_add, int index){

        //Checks to make sure we don't go out of bounds of Array
        if(index >= head.length) return 0;

        //If current index is occupied
        if(head[index] != null) {

            //Check to see if Topic are the same, if so, insert node in front of list
            if (to_add.topic.compareTo(head[index].getTopic()) == 0) {

                node temp = new node(to_add);
                temp.connectNext(head[index]);
                head[index] = temp;

                return 1;
            }
        }
        //If index is Empty, and is a new Topic, insert node in new index
        if(head[index] == null){

            head[index] = new node(to_add);
            return 1;
        }
        //Recursive call to move to next index of array
        add_topic(head, to_add, ++index);
        return 1;
    }

    //Display all, wrapper function
    public final int display_all(){

        if(head == null) return 0;

        int count = display_all(head,0);

        return count;
    }
    //Display all, function to traverse array index
    protected final int display_all(node head[], int index){

        if(index >= head.length) return 0;

        int count = display_list(head[index]);

        return display_all(head, ++index) + count;
    }
    //Display all, function to display each list of each index
    protected final int display_list(node head){

        if(head == null) return 0;

        head.display();

        return display_list(head.getNext()) + 1;
    }

    //Remove an Item from the Array, takes in string from user
    public void remove_obj(String to_remove){

        if(head == null) return;

        remove_obj(head, 0, to_remove);
    }

    //Remove an Item from Array, this function traverses the Array and search for Topic first
    protected void remove_obj(node head[],int index, String to_remove){

        if(index >= head.length) return;

        //If array is not empty, compare Topic name
        if(head[index] != null) {
            if (to_remove.compareTo(head[index].getTopic()) == 0) {

                System.out.print("Found Topic, which media type would you like to remove? ");
                System.out.print("\nVideo\nSlideshow\nNotes\nMedia: ");
                String temp = input.nextLine();

                //Once topic is found, it will find media type to remove
                //Compares media type to first node, if match, then remove first node
                if(temp.compareTo(head[index].getType()) == 0){

                    this.head[index].connectNext(head[index].getNext());
                    this.head[index] = head[index].getNext();
                    return;
                }

                //If doesn't match first node, then traverse rest of LLL of the Array
                //Create a look ahead pointer, head will trail behind
                remove_media(head[index],head[index].getNext(), temp);
            }
        }
        remove_obj(head, ++index, to_remove);
    }

    //Remove media from LLL
    protected void remove_media(node head, node curr, String to_find){

        if(head == null) return;

        //If match to current node, then remove
        if(to_find.compareTo(curr.getType()) == 0){

            //If current node is last in list, set heads next pointer to null
            if(curr.getNext() == null){
                head.connectNext(null);
                return;
            }
            //else set heads next pointer to currents next node
            head.connectNext(curr.getNext());
            return;
        }
        //Recursive function to move current ahead, while head trails behind
        remove_media(head.getNext(),curr.getNext(), to_find);
    }

    //Find Topic and media to view
    public void view_topic(String to_find){

        if(head == null) return;

        view_topic(head, 0, to_find);
    }

    //Find Topic first
    protected void view_topic(node head[], int index, String to_find){

        if(index >= head.length){

            System.out.print("\nCould not find " + to_find);
            return;
        }
        if(head[index] != null){
            if(to_find.compareTo(head[index].getTopic()) == 0){

                System.out.print("Found Topic, which media type would you like to remove? ");
                System.out.print("\nVideo\nSlideshow\nNotes\nMedia: ");
                String temp = input.nextLine();

                //Once topic is found, it will find media type to view
                //Compares media type to first node, if match, then view
                if(temp.compareTo(head[index].getType()) == 0){

                    System.out.print("\nYou have viewed " + temp);
                    head[index].add_view();
                    head[index].display();
                    return;
                }
                view_topic(head[index], temp);
            }
        }
        view_topic(head, ++index, to_find);
    }

    //Find and view media object
    protected void view_topic(node head, String to_find){

        if(head == null) {

            System.out.print("\nCould not find " + to_find);
            return;
        }

        if(to_find.compareTo(head.getType()) == 0){

            System.out.print("\nYou have viewed " + to_find);
            head.add_view();
            head.display();
            return;
        }
        view_topic(head.getNext(), to_find);
    }

    //Copy List, Wrapper Function
    public void copy_all(array source){

        if(source.head == null) {

            head = null;
            return;
        }
        int index = 0;
        copy_all(head, source.head, 0);
    }

    //Copy List, Traverse Array then calls function to copy each list
    protected void copy_all(node dest[], node source[], int index){

        if(index >= source.length) return;

        if(source[index] != null){

            dest[index] = copy_all(dest[index], source[index]);
        }
        copy_all(dest, source, ++index);
    }

    //Copy List, Copies each List for each index
    protected node copy_all(node dest, node source){

        if(source == null) return null;

        dest = new node(source.ptr);

        dest.connectNext(copy_all(dest.getNext(), source.getNext()));

        return dest;
        }
}
