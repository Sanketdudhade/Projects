public class Train {
    private  int trainid;
    private  String name;
    private String source;
    private  String destination;
    private  int totalSeat;
    private  int availableSeat;

    public Train(int id, String name, String source, String destination,int totalSeat) {
        this.trainid = id;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalSeat = totalSeat;
        this.availableSeat = totalSeat;
    }

    public int gettrainidId() {
        return trainid;
    }

    public void setId(int id) {
        this.trainid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
    public boolean bookSeat(int count){
        if (count<=availableSeat){
            availableSeat-=count;
            return true;
        }
        return false;
    }
    public void cancleSeat(int count){
        availableSeat+=count;
    }

    @Override
    public String toString() {
        return trainid +" | "+name+" | "+source+"--->"+destination+" available seat:"+availableSeat;
    }
}
