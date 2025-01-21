package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean requestComplete = false;
    private boolean finished = false;

    public CompleteByRequestTask() {
    }

    @Override
    public void execute() {
        if (requestComplete && !finished) {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        requestComplete = true;
    }
}
