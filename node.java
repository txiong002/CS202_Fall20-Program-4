//Tou Xiong
//Node Class: Contains all function for my nodes

public class node {

    //Data members
    protected node next;
    protected playList ptr;

    //Default Node Constructor
    public node(){
        next = null;
        ptr = null;
    }

    //Node Constructor with args. Takes in a base class pointer
    public node(playList to_add){ ptr = to_add;}

    //node functions
    public node getNext() {return this.next;}       //get next pointer
    public playList get_head() {return this.ptr;}   // head pointer for base class pointer
    public void connectNext(node connect) {this.next = connect;}

    //Display node information, calls display function of current base class pointer object
    public final int display(){

        ptr.display();
        return 1;
    }

    //Calls getter and setter function to current object
    public String getTopic(){ return ptr.getTopic(); }
    public String getType() { return ptr.getType(); }
    public void add_view(){ ptr.add_view(); }

}
