package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

/**
 * Sprint
 * Sprints has the time capacity and the tickets limit, specified via constructor.
 * It is not allowed for a Sprint to contain tickets with total estimate greater than time capacity.
 * It is not allowed for a Sprint to contain total amount of tickets greater than tickets limit.
 * We consider a sprint to accept tickets via add* methods. That methods return true when an input ticket was accepted and false otherwise.
 * Note that we consider a sprint to not accept:
 *      * null values,
 *      * tickets, that are already completed
 *      * tickets, that has an estimate value that will lead to capacity overflow if added
 *      * any ticket, if the sprint ticket limit is reached.
 * Methods:
 *       - addUserStory(UserStory userStory) - accepts a userStory, if it is not null, not completed and its uncompleted dependencies are already accepted to the sprint.
 *          Returns true if the user story is accepted, false otherwise.
 *       - addBug(Bug bugReport) - accepts a bug, if it is not null and not completed. Returns true if the bug is accepted, false otherwise.
 *       - getTickets() - Returns a defensive copy of the array of the sprint tickets. Make sure the order of tickets is as they were accepted to the sprint.
 *       - getTotalEstimate() - Returns the sum of estimates of all the tickets accepted to the sprint.
 * */
public class Sprint {

    private int capacity;
    private int ticketsLimit;
    private Ticket[] tickets;
    private int currentEstimate;
    private int count;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
        this.currentEstimate = 0;
        this.count = 0;
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null || userStory.isCompleted() || count >= ticketsLimit || currentEstimate + userStory.getEstimate() > capacity){
            return false;
        }
        //if dependencies are added:
        for (UserStory dependency: userStory.getDependencies()) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if(tickets[i] == dependency){
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        tickets[count++] = userStory;
        currentEstimate += userStory.getEstimate();
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null || bugReport.isCompleted() || count >= ticketsLimit || currentEstimate + bugReport.getEstimate() > capacity){
            return false;
        }
        tickets[count++] = bugReport;
        currentEstimate += bugReport.getEstimate();
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] ticketsArray = new Ticket[count];
        for (int i = 0; i < count; i++) {
            ticketsArray[i] = tickets[i];

        }
        return ticketsArray;
    }

    public int getTotalEstimate() {
        return currentEstimate;
    }
}
