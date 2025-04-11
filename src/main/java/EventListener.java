import java.util.Map;

public class EventListener extends Thread {

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
            if (shouldReply()){
                eventTracker.handle(messageToReplyWith, () -> System.out.println(messageToReplyWith));
            }
        }

    }

    public Boolean readyToQuit() {
        if  (eventTracker != null && eventTracker.has("quit")){
          return true;
      }
        return false;
    }

    public Boolean shouldReply() {
        if (eventTracker.has(messageToListenFor)){
            return true;
        }
        return false;
    }

    public void reply() {
        eventTracker.handle(messageToReplyWith,() -> {});
    }



}