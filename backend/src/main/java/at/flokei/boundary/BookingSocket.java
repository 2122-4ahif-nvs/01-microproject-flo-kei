package at.flokei.boundary;


import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/booking/{name}")
@ApplicationScoped
public class BookingSocket {

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {
        sessions.put(name, session);
        broadcast("User " + name + " joined");
    }

    @OnClose
    public void onClose(Session session, @PathParam("name") String name) {
        sessions.remove(name);
        broadcast("User " + name + " left");
    }

    @OnError
    public void onError(Session session, @PathParam("name") String name, Throwable throwable) {
        sessions.remove(name);
        broadcast("User " + name + " left on error: " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("name") String name) {
        broadcast(">> " + name + ": " + message);
    }

    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }
}
