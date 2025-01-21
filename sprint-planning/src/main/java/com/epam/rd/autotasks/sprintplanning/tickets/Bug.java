package com.epam.rd.autotasks.sprintplanning.tickets;

/**
 * Bug
 * We consider a bug to be a ticket, that is related to some completed user story. Bugs may not exists by their on, without a related user story.
 *      - createBug(int id, String name, int estimate, UserStory userStory) - A static method to create a Bug instance.
 *        Returns null if the related user story is null or is not completed. Otherwise, returns a created Bug instance.
 *      - toString() - Returns a String representing this bug, using its id, name and the name of the related user story.
 *        Example: with id = 2, name = "Add password repeat" and the related user story name = "Registration Form"
 *        the resulting string would be "[Bug 2] Registration Form: Add password repeat"
 * */
public class Bug extends Ticket {

    private UserStory relatedUserStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if(userStory == null || !userStory.isCompleted()){
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.relatedUserStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + relatedUserStory.getName() + ": " + getName();
    }
}
