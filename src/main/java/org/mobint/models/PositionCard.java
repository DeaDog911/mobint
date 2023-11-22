package org.mobint.models;

public class PositionCard {
    private String id;
    private boolean isShowInApp;
    private String name;
    private String groupId;

    public PositionCard(String id, boolean isShowInApp, String name, String groupId) {
        this.id = id;
        this.isShowInApp = isShowInApp;
        this.name = name;
        this.groupId = groupId;
    }

    public PositionCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isShowInApp() {
        return isShowInApp;
    }

    public void setShowInApp(boolean showInApp) {
        isShowInApp = showInApp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
