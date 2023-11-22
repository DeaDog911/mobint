package org.mobint.models;

public class Group {
    private String groupId;
    private String parentId;
    private String name;

    public Group(String groupId, String parentId, String name) {
        this.groupId = groupId;
        this.parentId = parentId;
        this.name = name;
    }

    public Group() {

    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
