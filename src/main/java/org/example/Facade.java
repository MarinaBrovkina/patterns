package org.example;

//Суть в том, чтобы предоставить упрощенный интерфейс к сложной подсистеме.
//Не захламляем метод main, а выносим логику в отдельные классы и методы
public class Facade {
    public static void main(String[] args) {
        WorkFlowFacade workFlowFacade = new WorkFlowFacade();
        workFlowFacade.solveProblems();
        workFlowFacade.rest();
    }
}

class Job {
    public void doJob() {
        System.out.println("Job in progress..");
    }
}

class BugTracker {
    private boolean activeSprint;

    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint is active");
        activeSprint = true;
    }

    public void finishSprint() {
        System.out.println("Sprint is not active");
        activeSprint = false;
    }
}

class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker) {
        if (bugTracker.isActiveSprint()) {
            System.out.println("Developer is solving problems");
        } else {
            System.out.println("Developer is watching youtube");
        }
    }
}

class WorkFlowFacade {
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();
    Developer developer = new Developer();

    public void solveProblems() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }

    public void rest() {
        bugTracker.finishSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}