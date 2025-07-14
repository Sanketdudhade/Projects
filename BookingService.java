import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList=new ArrayList<>();
    private  List<Ticket> ticketList=new ArrayList<>();
    public BookingService(){
        trainList.add(new Train(101,"RajdhaniExpress","Shirdi","Delhi",120));
        trainList.add(new Train(102,"Duronto Express"," Mumbai Central ","Ahmedabad",90));
        trainList.add(new Train(103,"Shatabdi Express","New Delhi ","Lucknow",60));
        trainList.add(new Train(104,"Maharashtra Express ","Gondia Jn","Kolhapur",80));
        trainList.add(new Train(105,"Godavari Express","Hyderabad Deccan","Visakhapatnam",90));
        trainList.add(new Train(101,"RajdhaniExpress","Delhi","Shirdi",150));

    }

    public List<Train> searchTrain(String source,String destination) {
        List<Train> res=new ArrayList<>();
        for(Train train:trainList){
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)){
                res.add(train);
            }
        }
        return res;
    }
    public Ticket bookTicked(User user,int trainid,int seatcount) {
        for (Train train : trainList) {
            if (train.gettrainidId() == trainid) {
                if (train.bookSeat(seatcount)) {
                    Ticket ticket = new Ticket(user, train, seatcount);
                    ticketList.add(ticket);
                    return ticket;
                } else {
                    System.out.println("No enough seat available");
                    return null;
                }
            }
        }
        System.out.println("Train id not found");
        return null;
    }
    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res=new ArrayList<>();
        for(Ticket ticket:ticketList){
            if (ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                res.add(ticket);
            }
        }
        return res;
    }
    public boolean cancleTicket(int ticketid,User user){
        Iterator<Ticket> iterator=ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket=iterator.next();
            if(ticket.getTicketId()==ticketid && ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Train train=ticket.getTrain();
                train.cancleSeat(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket"+ticketid+"Cancelled successfully");
                return true;
            }
        }
        System.out.println("Ticket not found");
        return false;
    }

    public void ListallTrain(){
        System.out.println("List of all train :");
        for(Train train:trainList){
            System.out.println(train);
        }
    }
}
