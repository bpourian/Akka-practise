package com.myapp.controller;

import akka.actor.*;
import com.myapp.listener.Listener;
import com.myapp.master.Master;
import com.myapp.message.Calculate;

public class Pi {

    public void calculate(final int nrOfWorkers, final int nrOfElements, final int nrOfMessages) {

        // Create an Akka system
        ActorSystem system = ActorSystem.create("PiSystem");

        // create the result listener, which will print the result and shutdown the system
        final ActorRef listener = system.actorOf(new Props(Listener.class), "listener");

        // create the master
        ActorRef master = system.actorOf(new Props(
                (UntypedActorFactory) () -> new Master(
                        nrOfWorkers,
                        nrOfMessages,
                        nrOfElements,
                        listener)), "master");



        // start the calculation
        master.tell(new Calculate());

    }
}
