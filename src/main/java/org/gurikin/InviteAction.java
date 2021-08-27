package org.gurikin;

public class InviteAction {
    private final String name;

    public InviteAction(String name) {
        this.name = name;
    }

    public synchronized void invite(InviteAction invitedObject) {
        System.out.println(name + " invite " + invitedObject.getName());
        invitedObject.action();
    }

    public synchronized void action() {
        System.out.println(name + " action");
    }

    public String getName() {
        return name;
    }
}
