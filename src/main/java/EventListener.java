public class EventListener {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
        while (!readyToQuit()){

        }

    }

    public Boolean readyToQuit() {
//        assert EventTracker.getInstance() != null;
        if  (eventTracker != null && eventTracker.equals("quit")){
          return true;
      }
        return false;
    }

    public Boolean shouldReply() {
        if (eventTracker.equals(messageToListenFor)){
            return true;
        }
        return eventTracker != null && eventTracker.equals("quit");
    }

    public void reply() {
    }
}