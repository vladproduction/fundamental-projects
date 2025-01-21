package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitRepoObservers {
    public static Repository newRepository() {
        return new RepositoryImpl();
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        return new WebHookImpl(branchName, Event.Type.MERGE);
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        return new WebHookImpl(branchName, Event.Type.COMMIT);
    }

    private static class WebHookImpl implements WebHook {
        private final String branch;
        private final Event.Type type;
        private final List<Event> caughtEvents = new ArrayList<>();

        public WebHookImpl(String branch, Event.Type type) {
            this.branch = branch;
            this.type = type;
        }

        @Override
        public String branch() {
            return branch;
        }

        @Override
        public Event.Type type() {
            return type;
        }

        @Override
        public List<Event> caughtEvents() {
            return new ArrayList<>(caughtEvents);
        }

        @Override
        public void onEvent(Event event) {
            if (event.type() == type && event.branch().equals(branch)) {
                caughtEvents.add(event);
            }
        }
    }

    private static class RepositoryImpl implements Repository {
        private final Map<String, List<Commit>> branches = new HashMap<>();
        private final List<WebHook> webHooks = new ArrayList<>();

        @Override
        public void addWebHook(WebHook webHook) {
            webHooks.add(webHook);
        }

        @Override
        public Commit commit(String branch, String author, String[] changes) {
            Commit newCommit = new Commit(author, changes);
            branches.computeIfAbsent(branch, k -> new ArrayList<>()).add(newCommit);
            Event commitEvent = new Event(Event.Type.COMMIT, branch, List.of(newCommit));
            notifyWebHooks(commitEvent);

            return newCommit;
        }

        @Override
        public void merge(String sourceBranch, String targetBranch) {
            List<Commit> sourceCommits = branches.getOrDefault(sourceBranch, new ArrayList<>());
            List<Commit> targetCommits = branches.computeIfAbsent(targetBranch, k -> new ArrayList<>());
            List<Commit> commitsToMerge = new ArrayList<>();

            for (Commit commit : sourceCommits) {
                if (!targetCommits.contains(commit)) {
                    targetCommits.add(commit);
                    commitsToMerge.add(commit);
                }
            }

            if (!commitsToMerge.isEmpty()) {
                Event mergeEvent = new Event(Event.Type.MERGE, targetBranch, commitsToMerge);
                notifyWebHooks(mergeEvent);
            }

        }

        private void notifyWebHooks(Event event) {
            for (WebHook webHook : webHooks) {
                webHook.onEvent(event);
            }
        }
    }
}
