package com.epam.rd.autotasks.sprintplanning.tickets;

/**
 * UserStory
 * We consider a user story to be a ticket that may contain some dependencies.
 * A dependency is another user story that must be completed first to allow the dependent user story to complete.
 * One provides dependencies of the UserStory via the constructor of the UserStory class.
 *    - complete() - Like the Ticket#complete() method, this sets the ticket to completed state.
 *      The difference is that the user story may not be completed if its dependencies are not completed yet.
 *    - getDependencies() - Returns a defensive copy of dependencies array.
 *    - toString() - Returns a String representing this user story, using its id and name. Example: "[US 1] User Registration Entity"
 * */
public class UserStory extends Ticket {

    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependencies = new UserStory[dependsOn.length];
        for (int i = 0; i < dependsOn.length; i++) {
            this.dependencies[i] = dependsOn[i];
        }
    }

    @Override
    public void complete() {
        for (UserStory dependency : dependencies) {
            if(!dependency.isCompleted()){
                System.out.println("user story may not be completed if its dependencies are not completed yet. Dependency not completed: " + dependency.getName());
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        UserStory[] dependenciesCopy = new UserStory[dependencies.length];
        for (int i = 0; i < dependencies.length; i++) {
            dependenciesCopy[i] = dependencies[i];
        }
        return dependenciesCopy;
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();

    }
}
